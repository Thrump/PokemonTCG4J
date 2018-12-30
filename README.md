# PokemonTCG4J
A java api wrapper for [pokemontcg.io's](https://pokemontcg.io/) Pokemon Trading Card API 


## Usage


### Card
```java
Card chansey = new Card("base1-2");
String name = chansey.getName();
```


#### Card Data
```
name
id
nationalPokedexNumber
types
subtype
supertype
hp
number
artist
rarity
series
set
setCode
retreatCost
convertedRetreatCost
test
attackDamage
attackCost
attackName
attackText
weaknesses
resistances
ancientTrait
abilityName
abilityText
abilityType
evolvesFrom
imageUrl
```


### CardArray
```java
CardArray query = new cardArray();
// or 
CardArray query = new cardArray("types", "Water");
Card[] cardA = query.getCardArray();
```


### Set
```java
Set doubleCrisis = new Set("dc1");
String name = doubleCrisis.getName();
```


#### Set Data
```
name
ptcgoCode
series
totalCards
standardLegal
expandedLegal
code
releaseDate
symbolUrl
logoUrl
```


### SetArray
```java
SetArray query = new SetArray()
// or
SetArray query = new SetArray("standardLegal", "true");
Set[] setA = query.getSetArray();
```


### Types
```java
Types types = new Types();
String[] typeList = types.getTypes;
```


### Subtypes
```java
Types subtypes = new subtypes();
String[] subtypeList = subtypes.getSubtypes;
```


### Supertypes
```java
Types supertypes = new supertypes();
String[] supertypeList = supertypes.getSupertypes;
```
