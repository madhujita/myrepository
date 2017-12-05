package com.BugFinder;

import java.net.UnknownHostException;

import org.json.JSONException;

public class ThreadElasticSearch implements Runnable {
	private boolean done = false;
	private boolean isDoneKnown = false;
	private ResponseToBot resultToBot = null;
	private String searchQ = null;
	private int index = 0;
	private searchElastic currObj = new searchElastic();
	

	@Override
	public void run(){
		System.out.println("Inside thread start/run");
				try {
					setResultToBot(getResponseToBot(getSearchQ()));
					
				} catch (UnknownHostException | JSONException e) {
					e.printStackTrace();
				}
				finally{
					setDone(true);
				}
		
	}

	public ResponseToBot getResponseToBot(String searchQuery) throws UnknownHostException, JSONException{

		System.out.println("Going to search elasticsearch");
		setCurrObj(searchElastic.searchDocs(searchQuery));
		setDone(true);
		System.out.println("done flag became TRUE");
		ResponseToBot elasticResult = elasticResult();

		return elasticResult;
	}

	public  ResponseToBot elasticResult(){
		
		ResponseToBot bot = new ResponseToBot();
			if(currObj.exceptionFlag){
				bot.setSpeech("Invalid response! Please change your search query.");
				bot.setDisplayText("Invalid response! Please change your search query.");
				return bot;
			}
			String result = "";
			int i = getIndex()+5;
			for(; getIndex() < i; index++){
				result = result.concat("\n"+(getIndex()+1)+")"+" Summary: "+currObj.summary[getIndex()]+"\n   Highlighted Description: "+currObj.highlighted_desc[getIndex()]+"\n   Link: "+currObj.link[getIndex()]+"\n");
			}
			
			long duration = System.currentTimeMillis() - BugFinderImpl.startTime;
			duration = duration/1000;
			
			bot.setSpeech("Total search results: "+searchElastic.searchCount+"\nTime taken: "+duration+" seconds"+"\nMax score: "+currObj.maxScore+result+"\nType 'next' to get the next 5 results.");
			bot.setDisplayText("Total search results: "+searchElastic.searchCount+"\nTime taken: "+duration+" seconds"+"\nMax score: "+currObj.maxScore+result+"\nType 'next' to get the next 5 results.");
			
			BugFinderImpl.timeMap.clear();


		System.out.println("Returning Final BOT");
		
		
		return bot;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public ResponseToBot getResultToBot() {
		return resultToBot;
	}

	public void setResultToBot(ResponseToBot resultToBot) {
		this.resultToBot = resultToBot;
	}

	public String getSearchQ() {
		return searchQ;
	}

	public void setSearchQ(String searchQ) {
		this.searchQ = searchQ;
	}

	public searchElastic getCurrObj() {
		return currObj;
	}

	public void setCurrObj(searchElastic currObj) {
		this.currObj = currObj;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isDoneKnown() {
		return isDoneKnown;
	}

	public void setDoneKnown(boolean isDoneKnown) {
		this.isDoneKnown = isDoneKnown;
	}


}
