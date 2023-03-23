import java.util.Random;

public class PereReisile {

    public static void main(String[] args) {
        Random ran = new Random();
        int x = ran.nextInt(6) + 5; // vahemikus 5-10
        Pereliige isa = new Pereliige("isa", 1000000, "EUR", "USD");
        Pereliige ema = new Pereliige("ema", 1, "EUR", "EUR");
        Pereliige poeg = new Pereliige("poeg", 579, "EUR", "RUB");
        Pereliige tütar = new Pereliige("tütar", 75, "EUR", "AUD");
        Pereliige vanaema = new Pereliige("vanaema", 391, "EUR", "EGP");
        Pereliige vanaisa = new Pereliige("vanaisa", 500000, "EUR", "CAD");
        Pereliige onu = new Pereliige("onu", 25975, "EUR", "AED");
        Pereliige tädi = new Pereliige("tädi", 1769, "EUR", "JPY");
        isa.teisendaRaha(isa.getAlgusValuuta(), isa.getRahaKogus(), isa.getSihtValuuta());
    }
}
