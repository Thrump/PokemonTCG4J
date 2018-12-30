package io.osu.TCG;

import org.json.JSONArray;

public class Subtypes {
	
private String[] subtypes;
	
	// constructors ===================================
	
	public Subtypes() {
		QueryBuilder query = new QueryBuilder("subtypes");
		JSONArray search = query.getSingleQuerySearch().getJSONArray("subtypes");
		subtypes = new String[search.length()];
		for(int i = 0; i < search.length(); i++) {
			subtypes[i] = search.getString(i);
		}
	}
	
	
	// public methods ==================================
	
	public String[] getSubtypes() {
		return subtypes;
	}

}
