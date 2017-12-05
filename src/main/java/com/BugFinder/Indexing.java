package com.BugFinder;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class Indexing{
	
	public static void indexDocs(ExampleBug example_bug) throws UnknownHostException{

	// on startup

	Settings settings = Settings.builder().put("cluster.name", "bug-application").build();
	TransportClient client = new PreBuiltTransportClient(settings);
	client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));

	
	String description = "";
	if (ScrapeBugzilla.arrayEle !=null && ScrapeBugzilla.arrayEle.size() > 0){
		for (String element : ScrapeBugzilla.arrayEle) {
			description += element;
		}
	}
	
	Map<String, Object> json = new HashMap<String, Object>();
	json.put("product",example_bug.getBugs().get(0).getProduct());
	json.put("id",example_bug.getBugs().get(0).getId());
	json.put("summary",example_bug.getBugs().get(0).getSummary());
	json.put("status",example_bug.getBugs().get(0).getStatus());
	json.put("category",example_bug.getBugs().get(0).getCategory());
	json.put("foundInVersion",example_bug.getBugs().get(0).getFoundInVersion());
	json.put("foundInProduct",example_bug.getBugs().get(0).getFoundInProduct());
	json.put("component",example_bug.getBugs().get(0).getComponent());
	json.put("description", description.replace(" ", " "));
	
	IndexResponse response = client.prepareIndex("myindex", "mytype", ScrapeBugzilla.bug_id)
	        .setSource(json)
	        .get();
	
	// on shutdown
	client.close();
	}
	

}