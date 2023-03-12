import com.google.gson.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private static final String API_KEY = "b32a153551f11c9aab47484d";

    public static void main(String[] args) throws IOException {
        // Making Request
        URL url = new URL("https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD");
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((request.getInputStream())));
        JsonObject jsonobj = root.getAsJsonObject();

        // Accessing object
        String req_result = jsonobj.get("result").getAsString();
        System.out.println(req_result);

        // Read JSON file
        String data = new String(Files.readAllBytes(Paths.get("src/main/demo.json")));

        // Parse JSON using Gson library
        JsonObject jsonObject = JsonParser.parseString(data).getAsJsonObject();
        JsonObject conversionRatesObject = jsonObject.getAsJsonObject("conversion_rates");
        System.out.println(conversionRatesObject);
    }

    public static String[] rahaNetist(String url_sisse) throws IOException {
        // Making Request
        URL url = new URL(url_sisse);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((request.getInputStream())));
        JsonObject jsonobj = root.getAsJsonObject();

        // Accessing object
        String req_result = jsonobj.get("result").getAsString();

        // Return result as an array of strings
        return new String[] {req_result};
    }
}
