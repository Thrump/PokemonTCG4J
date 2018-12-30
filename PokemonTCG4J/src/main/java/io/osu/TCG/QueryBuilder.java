package io.osu.TCG;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

class QueryBuilder {
	
	final private String website = "https://api.pokemontcg.io/v1/";
	private OkHttpClient client = new OkHttpClient();
	private JSONArray query;
	private JSONObject singleQuerySearch;
	
	//=========================================================
	
	private String run(String url) {
		String responseTxt = null;
			Request request = new Request.Builder().url(url).build();
			try(Response response = client.newCall(request).execute()) {
				responseTxt = response.body().string();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return responseTxt;
	}	
	
	//============================================================
	
	
	QueryBuilder(String redirect)  {
		String response  = run(website + redirect);
		if(response.charAt(0) == '{') {			
			singleQuerySearch = new org.json.JSONObject(response);
		}else {
			query = new org.json.JSONArray(response);
		}
		
	}
		
	//============================================================	
		

	
	public JSONArray getQuery() {
		return query;
	}
	
	public JSONObject getSingleQuerySearch() {
		return singleQuerySearch;
	}
	
}
