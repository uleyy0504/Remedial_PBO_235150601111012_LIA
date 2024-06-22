package UAP;
public class Stroberi extends Tanaman {

    public Stroberi() {
        super(60, 150, 35);
    }

    @Override
    public void berkembang() {
        lamaHidup++;
        prosesBerbuah += getPerkembangan();
        if (prosesBerbuah >= getBerbuah()) {
            setBuah(getBuah() + 1);
            prosesBerbuah = prosesBerbuah - getBerbuah();
        }
    }
}