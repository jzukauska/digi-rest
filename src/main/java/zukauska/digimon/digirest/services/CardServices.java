package zukauska.digimon.digirest.services;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import zukauska.digimon.digirest.models.CardModel;
import zukauska.digimon.digirest.models.CardReferenceModel;

@Service
public class CardServices {

  private static final String GET_ALL_CARDS = "https://digimoncard.io/api-public/getAllCards.php";
  private static final String SEARCH_CARDS = "https://digimoncard.io/api-public/search.php";
  

  public List<CardReferenceModel> getAllCards(AllCardQuery query) {
    WebClient webClient = WebClient.create();
    Mono<List<CardReferenceModel>> response = webClient.get().uri(query.getQueryFromUri(GET_ALL_CARDS))        
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<List<CardReferenceModel>>() {
        });
        
    List<CardReferenceModel> cards = response.block();

 
    return cards;
  }

  public CardModel[] getCardsByQuery(CardQuery query) {
    return null;

  }

  // private String addParams() {
  // return "";
  // }
}
