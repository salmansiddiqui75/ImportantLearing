package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        String countryName="india";
        String phone="75708687";
        //creating connection with url
        String apiUrl="https://jsonmock.hackerrank.com/api/countries?name=" + countryName;
        URL url=new URL(apiUrl);
        HttpURLConnection connection= (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        // Checking response code

        int responseCode=connection.getResponseCode();
        if(responseCode!=200)
        {
            throw new RuntimeException("responseCode"+responseCode);
        }
        else{

            //Reading response
            StringBuilder inline=new StringBuilder();
            Scanner scanner=new Scanner(url.openStream());
            while (scanner.hasNext())
            {
                inline.append(scanner.nextLine());
            }

            //Parse the JSON response
            JSONParser parser=new JSONParser();
            JSONObject jsonObject= (JSONObject) parser.parse(inline.toString());
            JSONArray data= (JSONArray) jsonObject.get("data");

            if(data.isEmpty())
            {
                System.out.println("-1");
            }
            JSONObject countryInfo= (JSONObject) data.get(0);
            JSONArray callingCode= (JSONArray) countryInfo.get("callingCodes");
            String region= (String) countryInfo.get("region");
            Long population= (Long) countryInfo.get("population");
            String capital= (String) countryInfo.get("capital");

            if(callingCode.isEmpty())
            {
                System.out.println("-1");
            }

            String callCode= (String) callingCode.get(callingCode.size()-1);
            System.out.println("+" + callCode +" "+phone +" " + region +" "+population +" "+capital);


        }



    }
}