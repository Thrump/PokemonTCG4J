package io.osu.TCG;

import org.json.JSONArray;
import org.json.JSONObject;

public class SetArray {
	
	// private members =======================
	
	Set[] setArray;
	
	// constructors ==========================
	
	SetArray(){
		QueryBuilder query = new QueryBuilder("sets/");
		JSONObject cards = query.getSingleQuerySearch();
		JSONArray querySearch = cards.getJSONArray("sets");
		setArray =  new Set[querySearch.length()];
		for(int i = 0; i < querySearch.length(); i++) {
			setArray[i] = new Set(querySearch.getJSONObject(i).getString("id"));
		}
	
		
	}
	
	SetArray(String parameter,String search){
		QueryBuilder query = new QueryBuilder("sets?" + parameter + "=" + search);
		JSONObject cards = query.getSingleQuerySearch();
		JSONArray querySearch = cards.getJSONArray("sets");
		setArray =  new Set[querySearch.length()];
		for(int i = 0; i < querySearch.length(); i++) {
			setArray[i] = new Set(querySearch.getJSONObject(i).getString("id"));
		}
	}
	
	// public members =============================
	
	public Set[] getSetArray() {
		return setArray;
	}

}
