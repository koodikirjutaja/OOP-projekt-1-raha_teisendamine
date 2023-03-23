public class Pereliige extends RahaTulemus {
    private String pereliige;
    private double rahaKogus;
    private String algusValuuta;
    private String sihtValuuta;

    public Pereliige(String pereliige, double rahaKogus, String algusValuuta, String sihtValuuta) {
        this.pereliige = pereliige;
        this.rahaKogus = rahaKogus;
        this.algusValuuta = algusValuuta;
        this.sihtValuuta = sihtValuuta;
    }

    public String getPereliige() {
        return pereliige;
    }

    public void setPereliige(String pereliige) {
        this.pereliige = pereliige;
    }

    public double getRahaKogus() {
        return rahaKogus;
    }

    public void setRahaKogus(double rahaKogus) {
        this.rahaKogus = rahaKogus;
    }

    public String getAlgusValuuta() {
        return algusValuuta;
    }

    public void setAlgusValuuta(String algusValuuta) {
        this.algusValuuta = algusValuuta;
    }

    public String getSihtValuuta() {
        return sihtValuuta;
    }

    public void setSihtValuuta(String sihtValuuta) {
        this.sihtValuuta = sihtValuuta;
    }
}
