package io.osu.TCG;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class CardArray {

// private members ===============================
	
	String[] cardJSONArray;
	Map<String, String> cardPair;
// constructors =====================================
	
	CardArray(){
		QueryBuilder query = new QueryBuilder("cards/");
		JSONObject cards = query.getSingleQuerySearch();
		JSONArray querySearch = cards.getJSONArray("cards");
		for(int i = 0; i < querySearch.length(); i++) {
			cardJSONArray[i] = querySearch.getString(i);
			JSONObject obj = querySearch.getJSONObject(i);
		}
	}
	
	CardArray(String parameter, String search){
		QueryBuilder query = new QueryBuilder("cards?" + parameter + "=" + search);
		JSONObject cards = query.getSingleQuerySearch();
		JSONArray querySearch = cards.getJSONArray("cards");
		for(int i = 0; i < querySearch.length(); i++) {
			cardJSONArray[i] = querySearch.getString(i);
		}
	}
	
 // public methods =========================================
	
	public String[] getCardArray() {
		return cardJSONArray;
	}
	
}
