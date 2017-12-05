package com.BugFinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class ScrapeBugzilla{
	
		public static String bug_id; 
		public static String userid = "mambaskar";
		public static String password = "Sherlock007!!";
		public static String authString;
		public static String authStringEnc;
		public static String Bugzilla_login_cookie;
		public static String Bugzilla_logincookie_cookie;
		public static Map<String, String> cookieMap;
		public static String str;
		public static ExampleBug example_bug;
		public static ArrayList<String> arrayEle = new ArrayList<>();
		

	
		public static void main(String args[]) throws IOException, JSONException{
			
			try {
				encode();
				myPostRequest();
				
				File file = new File("C:/Users/mambaskar/myworkspace/bug_list.txt");
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				//StringBuffer stringBuffer = new StringBuffer();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					bug_id = line;
					myGetRequest();
					getBugFields();
					Indexing.indexDocs(example_bug);
					
				}
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		public static void encode(){
			authString = userid + ":" + password;		
			byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
			authStringEnc = new String(authEncBytes);
		}
		
		
		public static void myPostRequest() throws IOException{
			Connection.Response res = Jsoup.connect("https://bugzilla.eng.vmware.com/index.cgi")
				    .data("Bugzilla_login", userid, "Bugzilla_password", password)
				    .method(Method.POST)
				    .execute();

				cookieMap = res.cookies();
				Bugzilla_login_cookie = res.cookie("Bugzilla_login"); 
				Bugzilla_logincookie_cookie = res.cookie("Bugzilla_logincookie");
		}
		
		
		public static void myGetRequest() throws IOException{
						
						int i, j = 0;
						
						Connection.Response res = Jsoup.connect("https://bugzilla.eng.vmware.com/show_bug.cgi?id="+bug_id)
							    .data("Bugzilla_login", userid, "Bugzilla_password", password).cookies(cookieMap)
							    .method(Method.GET)
							    .execute();
						
						Document doc = res.parse();
						Elements ele1 = doc.select("div.comment_text_quoted");
						Elements ele2 = doc.select("div.norm");
						
						ArrayList<String> arrayEle1 = new ArrayList<>();
						ArrayList<String> arrayEle2 = new ArrayList<>();				
						
						/* Adding each element in an ArrayList for easy retrieval */
						for(Element element : ele1){
							arrayEle1.add(element.text());
						}
						
						for(Element element : ele2){
							arrayEle2.add(element.text());
						}
						
						
						for(i=0, j=0; i<arrayEle1.size() && j<arrayEle2.size(); i++, j++){
							arrayEle.add(arrayEle1.get(i));
							arrayEle.add(arrayEle2.get(j));
						}
						
						
						if(arrayEle1.size()>i){
							while(i!=arrayEle1.size()){
								arrayEle.add(arrayEle1.get(i));
								i++;
							}
						}
						
						else{
							while(j!=arrayEle2.size()){
								arrayEle.add(arrayEle2.get(j));
								j++;
							}
						}
						
		}
		

		
		public static void getBugFields() throws IOException, JSONException{
			
			String result = null;
			URL obj = new URL("http://bugzilla-rest.eng.vmware.com/rest/v1/bug/"+bug_id);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", "Basic "+authStringEnc);
			con.connect();
		
			
			InputStream instream = con.getInputStream();
			
		    BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
		    StringBuilder sb = new StringBuilder();

		    String line = null;
		    try {
		        while ((line = reader.readLine()) != null) {
		            sb.append(line + "\n");
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            instream.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		    result =  sb.toString();
		    
		    JsonParser parser = new JsonParser(); 
		    JsonElement mJson =  parser.parse(result);
		    Gson gson = new Gson();
		    example_bug = gson.fromJson(mJson, ExampleBug.class);
			
		}
				
}
	

