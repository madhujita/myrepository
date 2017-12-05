package com.BugFinder;

import java.util.HashMap;
import java.util.Map;

public class BugFinderImpl implements WebService {
	
	static String displayResult;
	static String url = "https://kb.vmware.com/selfservice/microsites/searchEntry.do";
	static String type = null;
	static String area = null;
	Integer statusCode;
	String statusErrorType;
	static boolean ElasticFlag = false;
	static Map<String, ThreadElasticSearch> mapElasticSearch = new HashMap<String, ThreadElasticSearch>();	
	static Map<String, Long> timeMap = new HashMap<String, Long>();
	String searchQuery = "";
	static String sessionId;
	static long startTime;
	static int nextCount;


	public BugFinderImpl() {
		init();
	}

	public void init() {
		System.out.println("In INIT");	
		Example example = new Example();
		ResponseToBot responsetobot = new ResponseToBot();
	}
	
	
	public ResponseToBot returnFollowUp(){
		ResponseToBot followupbot = new ResponseToBot();
			System.out.println("returning event");
			FollowupEvent fe = new FollowupEvent();
			fe.setName("follow-up-1");
			followupbot.setFollowupEvent(fe);

		System.out.println("Returning follow-up bot!");
		
		return followupbot;
	}
	
	public ResponseToBot initiateSearch(Example example) {

		ResponseToBot bot = new ResponseToBot();
		/* Time taken */
		if(!timeMap.containsKey(sessionId)){
			System.out.println("inside timeMap if");
			startTime = System.currentTimeMillis();
			timeMap.put(sessionId, startTime);
		}	
		
		System.out.println("inside addPatient method");
		searchQuery = example.getResult().getResolvedQuery();
		sessionId = example.getSessionId();
		
		if(searchQuery.toLowerCase().equals("next")){
			nextCount++;
			if(nextCount == 3){
				bot.setSpeech("No more results exist. Please provide another query.");
				bot.setDisplayText("No more results exist. Please provide another query.");
				nextCount = 0;
				return bot;
			}
			ResponseToBot elasticResult = mapElasticSearch.get(sessionId).elasticResult();
			return elasticResult;
		}
		
		if (null != mapElasticSearch.get(sessionId)){
			ThreadElasticSearch threadElasticSearchFromMap = mapElasticSearch.get(sessionId);
			if (threadElasticSearchFromMap.isDoneKnown()){
				mapElasticSearch.remove(sessionId);
			} else {
				if (threadElasticSearchFromMap.isDone()){
					threadElasticSearchFromMap.setDoneKnown(true);
					return threadElasticSearchFromMap.getResultToBot();
				}else{
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (threadElasticSearchFromMap.isDone()){
						threadElasticSearchFromMap.setDoneKnown(true);
						return threadElasticSearchFromMap.getResultToBot();
					}else{
						return returnFollowUp();
					}
				}
			}
		}
		
		ThreadElasticSearch threadElasticSearch = new ThreadElasticSearch();
		mapElasticSearch.put(sessionId, threadElasticSearch);
		threadElasticSearch.setSearchQ(searchQuery);
		
		Thread t = new Thread(threadElasticSearch);
		t.start();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (threadElasticSearch.isDone()){
			threadElasticSearch.setDoneKnown(true);
			return threadElasticSearch.getResultToBot();
		}else{
			return returnFollowUp();
		}
	}
	

//	public void invokeDatabase(){
//		System.out.println("Started Invoking Kb.vmware database.");
//		 int count = 0;
//		 
//		    HttpClient client = new HttpClient();
//
//		    PostMethod method = new PostMethod(url);
//		    method.addRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
//		    method.addRequestHeader("Content-Type", "application/x-www-form-urlencoded");
//		    
//		    String body = null;
//		
//		    System.out.println("My search string is: "+ type + " " + area);
//		    body = "searchString='" + type + " " + area + "'&btnSearchAll=Search&product=SG_VMWARENSXFORVSPHERE_1_2&language=UMLU_EN_1_1&cmd=search&accesslevels=SAL_Public&locale=LA_eng_US&contextType=gs&showsplink=true&evaluateRF=true&searchFor=&rwTarget=%2FrfPlayerWidget.do&document=DT_KB_1_1&searchMode=GuidedSearch&showSavedSearches=true&usemicrosite=true";
//		    System.out.println("My body is:- "+body);
//		    
//		    
//		    InputStream input1 = new ByteArrayInputStream(body.getBytes(StandardCharsets.UTF_8));
//		    method.setRequestBody(input1);
//		    
//		    // Provide custom retry handler is necessary
//		    method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
//		    		new DefaultHttpMethodRetryHandler(3, false));
//
//		    String input = null;
//		    File file = null;
//		    try {
//		      // Execute the method.
//		      int statusCode = client.executeMethod(method);
//
//		      if (statusCode != HttpStatus.SC_OK) {
//		        System.err.println("Method failed: " + method.getStatusLine());
//		      }
//
//		      // Read the response body.
//			input = method.getResponseBodyAsString();
//
//		    } catch (HttpException e) {
//		      System.err.println("Fatal protocol violation: " + e.getMessage());
//		      e.printStackTrace();
//		    } catch (IOException e) {
//		      System.err.println("Fatal transport error: " + e.getMessage());
//		      e.printStackTrace();
//		    } finally {
//		      method.releaseConnection();
//		    }  
//		    
//		    Document doc = null;
//				doc = Jsoup.parse(input);
//
//		    Elements ele = doc.select("div.vmresults");
//		    String[] article_link = new String[3];
//		    String[] title = new String[3];
//		    int i=0;
//		    for(Element element : ele.select("div.vmdoc")){
//		    	if(count == 3)
//		    		break;
//		    	
//		    	Elements links = element.select("a[href]");
//		    	String linkhref = links.attr("href");
//		    	System.out.println("linkhref:- "+linkhref);
//		    	article_link[i] = "https://kb.vmware.com/selfservice/microsites/" + linkhref;
//		    	title[i] = element.select("a").text();
//		    	i++;
//		    	count++;
//		    }
//		    
//		     displayResult = "1. "+title[0]+"\t"+article_link[0]+"\n"+"2. "+title[1]+"\t"+article_link[1]+"\n"+"3. "+title[2]+"\t"+article_link[2];
//		     System.out.println("Invoked kb.vmware database successfully. Here are retreived results:-\n");
//		     System.out.println("Displaying result: \n\n"+displayResult);
//	}


}
