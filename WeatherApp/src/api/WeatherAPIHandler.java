package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherAPIHandler {
    private static final String API_KEY = "44dcae1e89aa15cd7d5f9f62dcd81c66";
    private static final String API_URL = "http://api.weatherstack.com/current?access_key=" + API_KEY + "&query=";

    public static String getWeatherData(String location) throws IOException {
        URL url = new URL(API_URL + location);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}
