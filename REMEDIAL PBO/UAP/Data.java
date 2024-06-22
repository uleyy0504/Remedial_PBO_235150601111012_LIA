package UAP;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    static ArrayList<Tanaman> tanamans = new ArrayList<>();
    static ArrayList<Integer> lokasi = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public static void mulai() {
        System.out.print("Masa tanam (bulan): ");
        int masaTanamBulan = in.nextInt();
        int masaTanamHari = masaTanamBulan * 30;
        menanam();
        menanam();
        menanam();
        for (int i = 1; i <= masaTanamHari; i++) {
            for (int j = 0; j < tanamans.size(); j++) {
                if (tanamans.get(j).getStatus().equals("Hidup")) {
                    if (!lokasi.contains(j)) {
                        tanamans.get(j).berkembang();
                        if (i % 90 == 0) {
                            tanamans.get(j).treatment();
                        }
                        if (i == masaTanamHari) {
                            System.out.println("---HASIL MENANAM---");
                            for (int k = 0; k < tanamans.size(); k++) {
                                System.out.println("Tanaman buah ke-" + (k + 1));
                                System.out.println(tanamans.get(k).toString());
                            }
                        }
                    } else {
                        continue;
                    }
                } else {
                    lokasi.add(j);
                    System.out.println("Tanaman " + tanamans.get(j).getStatus() + " telah mati.");
                    if (i == masaTanamHari) {
                        System.out.println("---HASIL MENANAM---");
                        for (int k = 0; k < tanamans.size(); k++) {
                            System.out.println("Tanaman buah ke-" + (k + 1));
                            System.out.println(tanamans.get(k).toString());
                        }
                    }
                    menanam();
                }
            }
        }
    }

    public static void menanam() {
        System.out.println("Mau menanam apa ?");
        System.out.println("1. Tomat");
        System.out.println("2. Stroberi");
        System.out.println("3. Persik");
        int pilihan = in.nextInt();
        switch (pilihan) {
            case 1:
                tanamans.add(new Tomat());
                System.out.println("Tomat berhasil ditanam.");
                break;
            case 2:
                tanamans.add(new Stroberi());
                System.out.println("Stroberi berhasil ditanam.");
                break;
            case 3:
                tanamans.add(new Persik());
                System.out.println("Persik berhasil ditanam.");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    public static void info() {
        for (int i = 0; i < tanamans.size(); i++) {
            System.out.println("Tanaman " + (i + 1) + ": " + tanamans.get(i).toString());
        }
    }
}