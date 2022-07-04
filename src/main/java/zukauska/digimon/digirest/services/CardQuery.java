package zukauska.digimon.digirest.services;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;

import lombok.Data;


@Data
public class CardQuery {
  String sort;
  String series;

  String sortdirection;

  
}
