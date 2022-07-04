package zukauska.digimon.digirest.models;

import java.net.URI;
import java.util.Optional;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;
import zukauska.digimon.digirest.services.IQuery;

@Data
public class CardQuery implements IQuery {

  String name,
      description,
      color,
      type,
      attribute,
      card_number,
      set_name,
      sort,
      sortdirection,
      series = "Digimon Card Game";

  @Override
  public URI getQueryFromUri(String base) {
    UriComponentsBuilder uriBuild = UriComponentsBuilder.fromUriString(base);
    uriBuild.queryParamIfPresent("n", Optional.ofNullable(this.name));
    uriBuild.queryParamIfPresent("desc", Optional.ofNullable(this.description));
    uriBuild.queryParamIfPresent("color", Optional.ofNullable(this.color));
    uriBuild.queryParamIfPresent("type", Optional.ofNullable(this.type));
    uriBuild.queryParamIfPresent("attribute", Optional.ofNullable(this.attribute));
    uriBuild.queryParamIfPresent("card", Optional.ofNullable(this.card_number));
    uriBuild.queryParamIfPresent("pack", Optional.ofNullable(this.set_name));
    uriBuild.queryParamIfPresent("sort", Optional.ofNullable(this.sort));
    uriBuild.queryParamIfPresent("sortdirection", Optional.ofNullable(this.sortdirection));
    uriBuild.queryParamIfPresent("series", Optional.ofNullable(this.series));

    UriComponents uriComponent = uriBuild.build(false);
    URI uri = uriComponent.toUri();
    System.out.println(uri);

    return uri;
  }

}
