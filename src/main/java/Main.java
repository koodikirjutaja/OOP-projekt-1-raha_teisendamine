import com.google.gson.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/*
https://www.exchangerate-api.com/docs/java-currency-api
https://www.youtube.com/watch?v=vL-yBY540c0
https://blog.jetbrains.com/idea/2020/11/sharing-your-project-on-github/
*/

public class Main extends RahaNetist {
    private static final String API_KEY = "b32a153551f11c9aab47484d";

    public static void main(String[] args) throws IOException {
        // Saame kasutaja sisendi
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta valuuta kood: ");
        String currencyCode = scanner.nextLine();

        // Proovime päringuga kätte saada soovitud valuuta koodi
        try {
            // Konstrueerime URL-i
            String url_sisse = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + currencyCode;

            // Kutsume rahaNetist funktsiooni
            String[] resultArray = rahaNetist(url_sisse);

            // Konverteerime tulemuse JSON-iks
            JsonObject jsonobj = JsonParser.parseString(resultArray[0]).getAsJsonObject();

            // Ligipääs objektile
            String req_result = jsonobj.get("result").getAsString();
            System.out.println(req_result);

            // Saame konverteerimiskursside objekti
            JsonObject conversionRatesObject = jsonobj.getAsJsonObject("conversion_rates");
            System.out.println(conversionRatesObject);

            // Kui tegib error koodiga info kätte saamisel, anname kasutajale sellest teada
        } catch(Exception FileNotFoundException){
            System.out.println("Sellist valuuta koodi ei ole");
        }
    }

}
