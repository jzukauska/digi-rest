# Requirements 
- Java jdk 11
- Maven 

# Setup
-  `./mvnw install -f pom.xml`
# Running
- `mvn package`
- `java -jar target/digi-rest-0.0.1-SNAPSHOT.jar`
- Make requests to: `localhost:8080` if running locally

# Api schema
## Get all cards: 
Path:
`/api/cards/all`


```json
{  
  "sort":"name";
  "series" = "seriesOptions";
  "sort_direction" = "sortDirectionOptions";
}
```


  seriesOptions:
  - Digimon Card Game
  - Digimon Digi-Battle Card Game
  - Digimon Collectible Card Game 

  sortDirectionOptions: 
  - asc
  - desc

## Search Specific Cards: 

Path:
`/api/cards/search`

```json 
{
    "name": "Any string",
    "description": "Any string",
    "color": "colorOptions",
    "type": "typeOptions",
    "attribute":"Any String",
    "card_number": "Any String",
    "set_name":"Any String",
    "sort":"sortOptions",
    "sortdirection": "sortDirectionOptions",
    "series": "seriesOptions"
}
```
colorOptions:
- Black
- Blue
- Colorless
- Green
- Purple
- Red
- White
- Yellow

typeOptions:
- Digimon
- Option
- Tamer
- Digi-Egg

sortOptions:
- name
- power
- code
- color
- random

sortDirection: 
- asc
- desc

seriesOptions:
- Digimon Card Game
- Digimon Digi-Battle Card Game
- Digimon Collectible Card Game 