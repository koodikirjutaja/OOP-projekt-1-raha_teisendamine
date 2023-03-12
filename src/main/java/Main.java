import com.google.gson.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    private static final String API_KEY = "b32a153551f11c9aab47484d";

    public static void main(String[] args) throws IOException {
        // Get user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter currency code: ");
        String currencyCode = scanner.nextLine();

        // Construct URL
        String url_sisse = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + currencyCode;

        // Call rahaNetist function
        String[] resultArray = rahaNetist(url_sisse);

        // Convert result to JSON
        JsonObject jsonobj = JsonParser.parseString(resultArray[0]).getAsJsonObject();

        // Accessing object
        String req_result = jsonobj.get("result").getAsString();
        System.out.println(req_result);

        // Get conversion rates object
        JsonObject conversionRatesObject = jsonobj.getAsJsonObject("conversion_rates");
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
        return new String[] {jsonobj.toString()};
    }
}
