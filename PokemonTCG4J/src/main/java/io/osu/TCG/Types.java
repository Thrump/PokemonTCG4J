package io.osu.TCG;

import org.json.JSONArray;

public class Types {
	// private members ===============================
	
	private String[] types;
	
	// constructors ===================================
	
	public Types() {
		QueryBuilder query = new QueryBuilder("types");
		JSONArray search = query.getSingleQuerySearch().getJSONArray("types");
		types = new String[search.length()];
		for(int i = 0; i < search.length(); i++) {
			types[i] = search.getString(i);
		}
	}
	
	
	// public methods ==================================
	
	public String[] getTypes() {
		return types;
	}
	

}
