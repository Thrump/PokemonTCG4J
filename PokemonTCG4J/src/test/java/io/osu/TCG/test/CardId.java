package io.osu.TCG.test;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class CardId {
	
	//private members ========================================
	private JSONObject card;
	private String name;
	private String id;
	private int pokedexNum;
	private String subtype;
	private String supertype;
	private String hp;
	private String number;
	private String artist;
	private String rarity;
	private String series;
	private String set;
	private String setCode;
	private String ancientTrait;
	private String evolvesFrom;
	private String abilityName;
	private String abilityText;
	private String abilityType;
	private int convertedRetreatCost;
	private String text;
	private String imageUrl;
	private String[] types;
	private String[] retreatCost;	
	private String[] attackDamage;
	private String[][] attackCost;
	private String[] attackName;
	private String[] attackText;
	private int[] convertedEnergyCost;
	private Map<String, String> weaknesses;
	private Map<String, String> resistances;
	
	
	
	// Constructor =========================================================
	
	public CardId(String id){
		QueryBuilder query = new QueryBuilder("cards/" + id);
		card = query.getSingleQuerySearch().getJSONObject("card");
		
		// ==========================
		
		this.id              = card.has("id") ? card.getString("id") : null;
		name                 = card.has("name") ? card.getString("name") : null;
		pokedexNum           = card.has("nationalPokedexNumber") ? card.getInt("nationalPokedexNumber") : 0;	
		subtype				 = card.has("subtype") ? card.getString("subtype") : null;
		supertype 			 = card.has("supertype") ? card.getString("supertype") : null;
		hp					 = card.has("hp") ? card.getString("hp") : null;
		number				 = card.has("number") ? card.getString("number") : null;
		artist				 = card.has("artist") ? card.getString("artist") : null;
		rarity				 = card.has("rarity") ? card.getString("rarity") : null;
		series 				 = card.has("series") ? card.getString("series") : null;
		set                  = card.has("set") ? card.getString("set") : null;
		setCode              = card.has("setCode") ? card.getString("setCode") : null;
		text				 = card.has("text") ? card.getString("text") : null;
		ancientTrait		 = card.has("ancientTrait") ? card.getString("ancientTrait") : null;
		evolvesFrom			 = card.has("evolvesFrom") ? card.getString("evolvesFrom") : null;
		abilityName 		 = card.has("abilityName") ? card.getString("abilityName") : null;
		abilityText 		 = card.has("abilityText") ? card.getString("abilityText") : null;
		abilityType			 = card.has("abilityType") ? card.getString("abilityType") : null;
		convertedRetreatCost = card.has("convertedRetreatCost") ? card.getInt("convertedRetreatCost") : 0;
		imageUrl			 = card.has("imageUrl") ? card.getString("imageUrl") : null;
		
		
		if(card.has("types")) {
			JSONArray typesArray = card.getJSONArray("types");	
			types = new String[typesArray.length()];
			for(int i = 0; i < typesArray.length(); i++) {
				types[i] = typesArray.getString(i);
			}
		}else {
			types = null;
		}
		
		if(card.has("retreatCost")) {
			JSONArray retreatCostArray = card.getJSONArray("retreatCost");
			retreatCost = new String[retreatCostArray.length()];
			for(int i = 0; i < retreatCostArray.length(); i++) {
				retreatCost[i] = retreatCostArray.getString(i);
			}
		}else {
			retreatCost = null;
		}
		
		if(card.has("attacks")) {
			JSONArray attacks = card.getJSONArray("attacks");
			attackName = new String[attacks.length()];
			attackText = new String[attacks.length()];
			attackCost = new String[attacks.length()][];
			attackDamage = new String[attacks.length()];
			convertedEnergyCost = new int[attacks.length()];
			for(int i = 0; i < attacks.length(); i++) {
				JSONObject attack = attacks.getJSONObject(i);
				attackName[i] = attack.getString("name");
				attackText[i] = attack.getString("text");
				attackDamage[i] = attack.getString("damage");
				convertedEnergyCost[i] = attack.getInt("convertedEnergyCost");
				JSONArray cost = attack.getJSONArray("cost");
				attackCost[i] = new String[cost.length()];
				for(int j = 0; j < cost.length(); j++) {
					attackCost[i][j] = (String) cost.getString(j);
				}
			}	
		}else {
			attackName = null;
			attackText = null;
			attackCost = null;
			attackDamage = null;
			convertedEnergyCost = null;
		}
		
		weaknesses = new HashMap<>();
		if(card.has("weaknesses")) {
			JSONArray weaknessesArray = card.getJSONArray("weaknesses");
			for(int i = 0; i < weaknessesArray.length(); i++) {
				JSONObject weakness = weaknessesArray.getJSONObject(i);
				weaknesses.put(weakness.has("type") ? weakness.getString("type") : null, weakness.has("value") ? weakness.getString("value") : null);
			}
		}else {
			weaknesses = null;
		}
		
		resistances = new HashMap<>();
		if(card.has("resistances")) {
			JSONArray resistanceArray = card.getJSONArray("resistances");
			
			for(int i = 0; i < resistanceArray.length(); i++) {
				JSONObject resistance = resistanceArray.getJSONObject(i);
				resistances.put(resistance.has("type") ? resistance.getString("type") : null ,resistance.has("value") ? resistance.getString("value") : null);
			}
		}else {
			resistances = null;
		}
		
		
	}
	
	// public methods =================================================================================
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	public int getNationalPokemonNumber() {
		return pokedexNum;
	}
	
	public String[] getTypes() {
		return types;
	}
	
	public String getSubtype() {
		return subtype;
	}
	
	public String getSupertype() {
		return supertype;
	}
	
	public String getHp() {
		return hp;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getArtist() {
		return artist;
	}

	public String getRarity() {
		return rarity;
	}
	
	public String getSeries() {
		return series;
	}
	
	public String getSet() {
		return set;
	}
	
	public String getSetCode() {
		return setCode;
	}
	
	public String[] getRetreatCost() {
		return retreatCost;
	}
	public int getConvertedRetreatCost() {
		return convertedRetreatCost;
	}
	
	public String getText() {
		return text;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public String[] getAttackDamage() {
		return attackDamage;
	}
	
	public String[][] getAttackCost() {
		return attackCost;
	}
	
	public String[] getAttackName() {
		return attackName;
	}
	
	public String[] getAttackText() {
		return attackText;
	}
	
	public Map<String, String> getWeaknesses() {
		return weaknesses;
	}
	
	public Map<String, String> getResistances() {
		return resistances;
	}
	
	public String getAncientTrait() {
		return ancientTrait;
	}
	
	public String getAbilityName() {
		return abilityName;
	}
	
	public String getAbilityType() {
		return abilityType;
	}
	
	public String getAbilityText() {
		return abilityText;
	}
	
	public String getEvolvesFrom() {
		return evolvesFrom;
	}
	
	
}

