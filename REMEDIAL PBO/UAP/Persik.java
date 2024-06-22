package UAP;
public class Persik extends Tanaman {

    public Persik() {
        super(180, 250, 15);
    }

    @Override
    public void berkembang() {
        setLamaHidup(getLamaHidup() + 1);
        setProsesBerbuah(getProsesBerbuah() + getPerkembangan());
        if (prosesBerbuah >= getBerbuah()) {
            setBuah(getBuah() + 1);
            prosesBerbuah = prosesBerbuah - getBerbuah();
        }
    }
}