package io.osu.TCG;

import org.json.JSONArray;

public class Supertypes {
	
private String[] supertypes;
	
	// constructors ===================================
	
	public Supertypes() {
		QueryBuilder query = new QueryBuilder("supertypes");
		JSONArray search = query.getSingleQuerySearch().getJSONArray("supertypes");
		supertypes = new String[search.length()];
		for(int i = 0; i < search.length(); i++) {
			supertypes[i] = search.getString(i);
		}
	}
	
	
	// public methods ==================================
	
	public String[] superTypes() {
		return supertypes;
	}

}
