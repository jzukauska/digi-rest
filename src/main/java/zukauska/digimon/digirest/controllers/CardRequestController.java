package zukauska.digimon.digirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import zukauska.digimon.digirest.models.CardModel;
import zukauska.digimon.digirest.models.CardReferenceModel;
import zukauska.digimon.digirest.services.AllCardQuery;
import zukauska.digimon.digirest.services.CardServices;


@RestController
@RequestMapping("/api/cards")
public class CardRequestController {
  
  @Autowired
  private CardServices cardServices;

  @ResponseBody
  @GetMapping(value = "/all", consumes = "application/json")
  public List<CardReferenceModel> getAll(@RequestBody AllCardQuery param) {
    
    return this.cardServices.getAllCards(param);
  }
  
  


}
