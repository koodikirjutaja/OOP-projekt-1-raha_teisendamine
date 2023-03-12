import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class RahaNetist {
    public static String[] rahaNetist(String url_sisse) throws IOException {
        // Teeb päringu
        URL url = new URL(url_sisse);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Konverteerib JSON-iks
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((request.getInputStream()), StandardCharsets.UTF_8));
        JsonObject jsonobj = root.getAsJsonObject();

        // Tagastab tulemuse massiivina
        return new String[] {jsonobj.toString()};
    }
}
