package UAP;

public abstract class Tanaman {
    private int masaHidup;
    public int lamaHidup;
    private int berbuah;
    private int buah;
    private double perkembangan;
    protected double prosesBerbuah;

    public Tanaman(int masaHidup, int berbuah, double perkembangan) {
        this.masaHidup = masaHidup;
        this.lamaHidup = 0;
        this.berbuah = berbuah;
        this.buah = 0;
        this.perkembangan = perkembangan;
        this.prosesBerbuah = 0;
    }

    public abstract void berkembang();

    public String getStatus() {
        if (lamaHidup >= masaHidup) {
            return "Mati";
        } else {
            return "Hidup";
        }
    }

    public String toString() {
        return "Masa hidup: " + masaHidup + " hari\n" +
               "Umur tanaman: " + lamaHidup + " hari\n" +
               "Menghasilkan: " + buah + " buah " + this.getClass().getSimpleName() + "\n" +
               "Status: " + getStatus();
    }

    public void treatment() {
        this.perkembangan += this.getClass().getSimpleName().equals("Tomat") ? 5 :
                this.getClass().getSimpleName().equals("Stroberi") ? 5 : 2.5;
    }

    public int getLamaHidup() {
        return lamaHidup;
    }

    public void setLamaHidup(int lamaHidup) {
        this.lamaHidup = lamaHidup;
    }

    public int getBerbuah() {
        return berbuah;
    }

    public void setBerbuah(int berbuah) {
        this.berbuah = berbuah;
    }

    public int getBuah() {
        return buah;
    }

    public void setBuah(int buah) {
        this.buah = buah;
    }

    public double getPerkembangan() {
        return perkembangan;
    }

    public void setPerkembangan(double perkembangan) {
        this.perkembangan = perkembangan;
    }

    public double getProsesBerbuah() {
        return prosesBerbuah;
    }

    public void setProsesBerbuah(double prosesBerbuah) {
        this.prosesBerbuah = prosesBerbuah;
    }
}