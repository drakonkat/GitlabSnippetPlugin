package it.drakonkat.gitlabsnippetplugin.client;

import it.drakonkat.gitlabsnipperplugin.config.PropertiesManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 *
 * @author mmazzocchetti
 */
public class GitlabClient {

        public static void main(String[] args) {

                try {
                        Properties p = PropertiesManager.getInstance().loadProperties();
                        URL url = new URL(p.getProperty("url"));
                        //URL url = new URL("http://localhost:8080/RESTfulExample/json/product/get");
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("GET");
                        conn.setRequestProperty("Accept", "application/json");

                        if (conn.getResponseCode() != 200) {
                                throw new RuntimeException("Failed : HTTP error code : "
                                        + conn.getResponseCode());
                        }

                        BufferedReader br = new BufferedReader(new InputStreamReader(
                                (conn.getInputStream())));

                        String output;
                        System.out.println("Output from Server .... \n");
                        while ((output = br.readLine()) != null) {
                                System.out.println(output);
                        }

                        conn.disconnect();

                } catch (MalformedURLException e) {

                        e.printStackTrace();

                } catch (IOException e) {

                        e.printStackTrace();

                }

        }

}
