package com.BugFinder;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class searchElastic{
	double maxScore;
	double[] score = new double[20];
	String[] summary = new String[20];
	String[] link = new String[20];
	String[] id = new String [20];
	String[] highlighted_desc = new String[20];
	static int searchCount;
	boolean exceptionFlag = false;
	
	
	public static searchElastic searchDocs(String searchQuery) throws UnknownHostException, JSONException{
		int i;
		searchElastic currObj = new searchElastic();
		
		System.out.println("My searchQuery is= "+searchQuery);
		Settings settings = Settings.builder().put("cluster.name", "bug-application").build();
		TransportClient client = new PreBuiltTransportClient(settings);
		try{
		client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
		

        final HighlightBuilder highlight = new HighlightBuilder()
                .field("summary").field("description");
		
		SearchResponse response = client.prepareSearch()
		        .setQuery(QueryBuilders.wrapperQuery("{\r\n" + 
		        		"        \"multi_match\": {\r\n" + 
		        		"    	\"fields\":  [ \"summary^2\", \"description\" ],\r\n" + 
		        		"    	\"query\":     \"   " + searchQuery + "   \",\r\n" + 
		        		"    	\"fuzziness\": \"AUTO\"\r\n" + 
		        		"    	}\r\n" + 
		        		"    }"))
		        .setSize(20)
		        .highlighter(highlight)
		        .get();

		JSONArray hitsArray = null;
		JSONObject hits = null;
		JSONObject source = null;
		JSONObject json = null;
		JSONObject highlights = null;

		json = new JSONObject(response.toString());
		hits = json.getJSONObject("hits");
		currObj.maxScore = hits.getDouble("max_score");
	    hitsArray = hits.getJSONArray("hits");
		
	    if(currObj.maxScore<1.0){
	    	BugFinderImpl.ElasticFlag = true;									//Match from Bugzilla does not exist
	    }
	    else{
	    	BugFinderImpl.ElasticFlag = false;		
	    }
	    
	    searchCount = hitsArray.length();
	    for(i=0; i<hitsArray.length(); i++){
	    	JSONObject obj = hitsArray.getJSONObject(i);
	    	highlights = obj.getJSONObject("highlight");
	    	source = obj.getJSONObject("_source");
	    	

	    		if(highlights.isNull("summary")){
	    			currObj.summary[i] = source.getString("summary");
	    		}
	    		else{
	    			currObj.summary[i] = highlights.get("summary").toString().replace("<em>", "*").replace("<\\/em>", "*");
	    		}
	    		if(highlights.isNull("description")){
	    			currObj.highlighted_desc[i] = source.getString("description");
	    		}
	    		else{
	    			currObj.highlighted_desc[i] = highlights.get("description").toString().replace("<em>", "*").replace("<\\/em>", "*").replace("\\\"", "\"");
	    		}

	    	currObj.score[i] = obj.getDouble("_score");
	    	source = obj.getJSONObject("_source");
	    	currObj.id[i] = source.getString("id");
	    	currObj.link[i] = "https://bugzilla.eng.vmware.com/show_bug.cgi?id="+ currObj.id[i];	
	    }
	    
		}catch(Throwable t){
			currObj.setExceptionFlag(true);
		//	currObj.exception = "Invalid response! Please change your search query.";
		}finally{
			client.close();
		}
		return currObj;
	}
	
	public boolean isExceptionFlag() {
		return exceptionFlag;
	}

	public void setExceptionFlag(boolean exceptionFlag) {
		this.exceptionFlag = exceptionFlag;
	}
	
}