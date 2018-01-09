package ylabs.Ylabsapi;

import org.json.JSONObject;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/*import com.sun.deploy.net.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;*/

public class AccountCreationConsumer {

	    public static void main(String[] args) throws Exception {

	       // System.out.println(makeRequest());
	        test();

	    }

	    public static void test(){
	        HttpURLConnection httpcon;
	        String url = null;
	        String data = null;
	        String result = null;
	        try {
	            //Connect
	            httpcon = (HttpURLConnection) ((new URL("https://ylabsapi.yantracard.com/api/application").openConnection()));
	            httpcon.setDoOutput(true);
	            httpcon.setRequestProperty("Content-Type", "application/json");
	            httpcon.setRequestProperty("token","razorthink:bad293c332834b3a8acfbf3bb3f23d2d");
	            System.out.println("is connected");

	            httpcon.setRequestProperty("Accept", "application/json");
	            httpcon.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");

	            httpcon.setRequestMethod("POST");
	            httpcon.connect();
	            System.out.println("connected");
	            JSONObject json = new JSONObject();
	            json.put("title", "Mr");
	            json.put("firstName", "James");
	            json.put("lastName", "Smith");
	            json.put("addressLine1", "Lakeview");
	            json.put("addressLine2", "Lawrence");
	            json.put("city", "Lawrence");
	            json.put("state", "KS");
	            json.put("zipCode", "66044");
	            json.put("ssn", "543456095");
	            json.put("email", "jamesmith@email.com");
	            json.put("phoneNumber", "8756738766");
	            json.put("password", "Test123$");
	            json.put("gender", "MALE");
	            json.put("dob", "1990-12-27");
	            System.out.println("JSONM ");
	            //Write
	            OutputStream os = httpcon.getOutputStream();
	            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
	            writer.write(json.toString());
	            writer.close();
	            os.close();
	            System.out.println("OOOUt");
	            System.out.println("i m here " + httpcon.getHeaderFieldKey(1));
	            System.out.println(" "+ httpcon.getResponseCode());
	            BufferedReader br;
	            if (200 <= httpcon.getResponseCode() && httpcon.getResponseCode() <= 299) {
	                br = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
	            } else {
	                br = new BufferedReader(new InputStreamReader(httpcon.getErrorStream()));
	            }
	            StringBuilder sb = new StringBuilder();
	            String output;
	            while ((output = br.readLine()) != null) {
	            sb.append(output);
	            System.out.println(sb);
	            }
	           
	         


	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }


}
