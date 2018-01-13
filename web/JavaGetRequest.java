package com.zetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

// HttpURLConnection creates a network connection to an HTTP servlet

public class JavaGetRequest {

    public static void main(String[] args) throws MalformedURLException, 
            ProtocolException, IOException {
        
        String url = "http://www.something.com";

        URL myurl = new URL(url);
        HttpURLConnection con = (HttpURLConnection) myurl.openConnection();

        con.setRequestMethod("GET");

        StringBuilder content;
        
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()))) {
            
            String line;
            content = new StringBuilder();
            
            while ((line = in.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
        }
        
        System.out.println(content.toString());        
    }
}
