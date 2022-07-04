package zukauska.digimon.digirest.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardModel {

  

  String name,
      type,
      color,
      stage,
      digi_type,
      attribute,
      card_rarity,
      card_number,
      main_effect,
      source_effect,
      set_name,
      image_url,
      artist;

  String[] card_sets;
  int level, evolution_cost, dp, play_cost;

  // "name": "Agumon",
  // "type": "Digimon",
  // "color": "Red",
  // "stage": "Rookie",
  // "digi_type": "Reptile",
  // "attribute": "Vaccine",
  // "level": 3,
  // "play_cost": 3,
  // "evolution_cost": 0,
  // "cardrarity": "Rare",
  // "artist": "TANIMESO",
  // "dp": 2000,
  // "cardnumber": "BT1-010",
  // "maineffect": "[On Play] Reveal 5 cards from the top of your deck. Add 1
  // Tamer card among them to your hand. Place the remaining cards at the bottom
  // of your deck in any order.",
  // "soureeffect": null,
  // "set_name": "BT01-03: Release Special Booster Ver.1.0",
  // "card_sets": [
  // "BT01-03: Release Special Booster Ver.1.0"
  // ],
  // "image_url": "https://images.digimoncard.io/images/cards/BT1-010.jpg"
}
