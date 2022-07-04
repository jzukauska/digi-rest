package zukauska.digimon.digirest.models;

import com.fasterxml.jackson.annotation.JsonAlias;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({ "name", "card_number", "level", "play_cost", "evolution_cost" })
public class CardModel {

  String name,
      type,
      color,
      stage,
      digi_type,
      attribute,
      set_name,
      image_url,
      artist;

  String[] card_sets;
  int level, evolution_cost, dp, play_cost;

  @JsonAlias({ "cardrarity" })
  String card_rarity;

  @JsonAlias({ "cardnumber" })
  String card_number;

  @JsonAlias({ "maineffect" })
  String main_effect;

  @JsonAlias({ "soureeffect" })
  String security_effect;

}
