package zukauska.digimon.digirest.controllers;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import zukauska.digimon.digirest.models.AllCardQuery;
import zukauska.digimon.digirest.models.CardModel;
import zukauska.digimon.digirest.models.CardQuery;
import zukauska.digimon.digirest.models.CardReferenceModel;
import zukauska.digimon.digirest.services.CardServices;

@RestController
@RequestMapping("/api/cards")
public class CardRequestController {
  private static final int CAPACITY = 1;
  private static final int DURATION_SECONDS = 15;

  @Autowired
  private CardServices cardServices;

  private final Bucket bucket;

  public CardRequestController() {
    Refill refill = Refill.intervally(CAPACITY, Duration.ofSeconds(DURATION_SECONDS));
    Bandwidth limit = Bandwidth.classic(CAPACITY, refill);
    Bucket bucket = Bucket.builder()
        .addLimit(limit)
        .build();
    this.bucket = bucket;
  }

  @ResponseBody
  @GetMapping(value = "/all", consumes = "application/json")
  public ResponseEntity<List<CardReferenceModel>> getAll(@RequestBody AllCardQuery param) {

    if (bucket.tryConsume(1)) {
      return ResponseEntity.ok(this.cardServices.getAllCards(param));
    }
    return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
  }

  @ResponseBody
  @GetMapping(value = "/search", consumes = "application/json")
  public ResponseEntity<List<CardModel>> getAll(@RequestBody CardQuery param) {

    if (bucket.tryConsume(1)) {
      return ResponseEntity.ok(this.cardServices.getCardsByQuery(param));
    }
    return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
  }

}
