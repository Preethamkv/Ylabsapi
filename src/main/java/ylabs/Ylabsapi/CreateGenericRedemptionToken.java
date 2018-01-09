package ylabs.Ylabsapi;
import org.json.JSONObject;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class CreateGenericRedemptionToken {
	
								    public static void main(String[] args) throws Exception {

								       // System.out.println(makeRequest());
								        test();

								    }

								    public static void test(){
								        HttpURLConnection httpcon;
								      // int funding_source_id=601;
								        String url="https://ylabsapi.yantracard.com/api/moneyrequest/";
								       
								        try {
								            //Connect
								            httpcon = (HttpURLConnection) ((new URL(url).openConnection()));
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
								        
								          
								            json.put("accountId","1112");
								            json.put("emailId","jamesmith@email.com");
								            json.put("amount","10");
								            json.put("referenceNumber", "redem0014");
								            json.put("notes","redemToken");
								            json.put("purposeCode", "P102");
								            
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



