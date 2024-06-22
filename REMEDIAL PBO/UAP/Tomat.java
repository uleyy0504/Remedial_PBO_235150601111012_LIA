package UAP;
public class Tomat extends Tanaman {

    public Tomat() {
        super(100, 100, 25);
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