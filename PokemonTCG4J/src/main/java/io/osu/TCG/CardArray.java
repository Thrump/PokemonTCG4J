package io.osu.TCG;


import org.json.JSONArray;
import org.json.JSONObject;

public class CardArray {

// private members ===============================
	
	Card[] cardArray;
	
// constructors =====================================
	
	CardArray(){
		QueryBuilder query = new QueryBuilder("cards/");
		JSONObject cards = query.getSingleQuerySearch();
		JSONArray querySearch = cards.getJSONArray("cards");
		cardArray =  new Card[querySearch.length()];
		for(int i = 0; i < querySearch.length(); i++) {
			cardArray[i] = new Card(querySearch.getJSONObject(i).getString("id"));
			
		}
	}
	
	CardArray(String parameter, String search){
		QueryBuilder query = new QueryBuilder("cards?" + parameter + "=" + search);
		JSONObject cards = query.getSingleQuerySearch();
		JSONArray querySearch = cards.getJSONArray("cards");
		cardArray =  new Card[querySearch.length()];
		for(int i = 0; i < querySearch.length(); i++) {
			cardArray[i] = new Card(querySearch.getJSONObject(i).getString("id"));
			
		}
	}
	
 // public methods =========================================
	
	public Card[] getCardArray() {
		return cardArray;
	}
	
}
