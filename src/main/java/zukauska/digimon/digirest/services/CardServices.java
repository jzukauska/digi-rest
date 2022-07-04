package zukauska.digimon.digirest.services;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import zukauska.digimon.digirest.models.AllCardQuery;
import zukauska.digimon.digirest.models.CardModel;
import zukauska.digimon.digirest.models.CardQuery;
import zukauska.digimon.digirest.models.CardReferenceModel;

@Service
public class CardServices {

  private static final String GET_ALL_CARDS = "https://digimoncard.io/api-public/getAllCards.php";
  private static final String SEARCH_CARDS = "https://digimoncard.io/api-public/search.php";

  // private final Bucket bucket;

  public List<CardReferenceModel> getAllCards(AllCardQuery query) {
    WebClient webClient = WebClient.create();
    Mono<List<CardReferenceModel>> response = webClient.get().uri(query.getQueryFromUri(GET_ALL_CARDS))
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<List<CardReferenceModel>>() {
        });

    List<CardReferenceModel> cards = response.block();

    return cards;
  }

  public List<CardModel> getCardsByQuery(CardQuery query) {
    WebClient webClient = WebClient.create();
    Mono<List<CardModel>> response = webClient.get().uri(query.getQueryFromUri(SEARCH_CARDS))
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<List<CardModel>>() {
        });

    List<CardModel> cards = response.block();

    return cards;

  }

  // private String addParams() {
  // return "";
  // }
}
