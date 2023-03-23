import com.google.gson.*;
import java.util.Scanner;

/*
Kasutatud materjalid

https://www.exchangerate-api.com/docs/java-currency-api
https://www.youtube.com/watch?v=vL-yBY540c0
https://blog.jetbrains.com/idea/2020/11/sharing-your-project-on-github/
https://github.com/google/gson
*/

public class RahaTulemus extends RahaNetist{
    private static final String API_KEY = "b32a153551f11c9aab47484d";

    public double teisendaRaha(String algne, double rahaKogus, String uusValuuta) {
        /*
        // Saame kasutaja sisendi
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Sisesta valuuta kood: ");
        String sinu_currencyCode = scanner1.nextLine().toUpperCase();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Sisesta rahasumma: ");
        String summa = scanner2.nextLine();
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Sisesta teisendatav valuuta kood: ");
        String teisendatava_currencyCode = scanner3.nextLine().toUpperCase();
         */

        // Proovime päringuga kätte saada soovitud valuuta koodi kordajaid
        JsonObject jsonobj = null;
        try {
            // Konstrueerime URL-i
            String url_sisse = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + algne;

            // Kutsume rahaNetist funktsiooni
            String[] resultArray = rahaNetist(url_sisse);

            // Konverteerime tulemuse JSON-iks
            jsonobj = JsonParser.parseString(resultArray[0]).getAsJsonObject();

            // Ligipääs objektile
            String req_result = jsonobj.get("result").getAsString();
            System.out.println(req_result);

            // Kui tekib error koodiga info kätte saamisel, anname kasutajale sellest teada
        } catch (Exception FileNotFoundException) {
            System.out.println("Sellist valuuta koodi ei ole");
        }
        assert jsonobj != null;
        JsonObject conversionRatesObject = jsonobj.getAsJsonObject("conversion_rates");
        float väärtus = (float) conversionRatesObject.get(uusValuuta).getAsDouble();

        float vastus = (float) rahaKogus * väärtus;
        return vastus;
    }
}
