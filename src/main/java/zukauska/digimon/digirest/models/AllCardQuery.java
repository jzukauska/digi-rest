package zukauska.digimon.digirest.models;

import java.net.URI;
import java.util.Optional;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;
import zukauska.digimon.digirest.services.IQuery;

@Data
public class AllCardQuery implements IQuery {

  String sort;
  String series = "Digimon Card Game";
  String sort_direction = "asc";

  @Override
  public URI getQueryFromUri(String base) {

    UriComponentsBuilder uriBuild = UriComponentsBuilder.fromUriString(base);
    uriBuild.queryParam("series", this.series);
    uriBuild.queryParam("sortdirection", this.sort_direction);
    uriBuild.queryParamIfPresent("sort", Optional.ofNullable(this.sort));

    UriComponents uriComponent = uriBuild.build(false);

    URI uri = uriComponent.toUri();

    System.out.println(uri);

    return uri;

  }

}
