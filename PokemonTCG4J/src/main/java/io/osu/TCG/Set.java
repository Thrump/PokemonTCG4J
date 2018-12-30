package io.osu.TCG;

import org.json.JSONObject;

public class Set {
	
	// private members ============================
	private JSONObject set;
	private String code;
	private String name;
	private String series;
	private String ptcgoCode;
	private int totalCards;
	private boolean standardLegal;
	private boolean expandedLegal;
	private String releaseDate;
	private String symbolUrl;
	private String logoUrl;
	
	// constructors =================================
	
	public Set(String code) {
		QueryBuilder query = new QueryBuilder("sets/" + code);
		set = query.getSingleQuerySearch().getJSONObject("set");
		
		// ===========================================
		
		this.code     = set.has(code)            ? set.getString("code") : null;
		name		  = set.has("name")          ? set.getString("name") : null;
		series 		  = set.has("series")        ? set.getString("series") : null;
		ptcgoCode	  = set.has("ptcgoCode")     ? set.getString("ptcgoCode") : null;
		totalCards    = set.has("totalCards")    ? set.getInt("totalCards") : null;
		standardLegal = set.has("standardLegal") ? set.getBoolean("standardLegal") : null;
		expandedLegal = set.has("expandedLegal") ? set.getBoolean("expandedLegal") : null;
		releaseDate   = set.has("ReleaseDate")   ? set.getString("releaseDate") : null;
		symbolUrl     = set.has("symbolUrl")     ? set.getString("symbolUrl") : null;
		logoUrl       = set.has("logoUrl")       ? set.getString("logoUrl") : null;
	}
	
	// public methods ================================
	
	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSeries() {
		return series;
	}
	
	public String getPtcgoCode() {
		return ptcgoCode;
	}
	
	public int getTotalCards() {
		return totalCards;
	}
	
	public boolean getStandardLegal() {
		return standardLegal;
	}
	
	public boolean getExpandedLegal() {
		return expandedLegal;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	
	public String getsymbolUrl() {
		return symbolUrl;
	}
	
	public String getLogoUrl() {
		return logoUrl;
	}
	
	

}
