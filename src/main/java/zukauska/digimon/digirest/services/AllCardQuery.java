package zukauska.digimon.digirest.services;

import java.net.URI;
import java.util.Optional;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriBuilderFactory;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Data
public class AllCardQuery implements IQuery{

  String sort;
  String series = "Digimon Card Game";

  String sortdirection = "asc";

  public URI getQueryFromUri(String base) {

    UriComponentsBuilder uriBuild = UriComponentsBuilder.fromUriString(base);
    uriBuild.queryParam("series", this.series);
    uriBuild.queryParam("sortdirection", this.sortdirection);
    uriBuild.queryParamIfPresent("sort", Optional.ofNullable(this.sort));

    UriComponents uriComponent=uriBuild.build(false);

    URI uri = uriComponent.toUri();

    System.out.println(uri);
    
    return uri;
    
  }

 
  

}
