import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    private String noRekamMedis;
    private List<String> riwayatPenyakit;

    public Patient(String id, String nama, int umur, String telepon, String noRekamMedis) {
        super(id, nama, umur, telepon); // panggil constructor Person
        this.noRekamMedis = noRekamMedis;
        this.riwayatPenyakit = new ArrayList<>();
    }

    public String getNoRekamMedis() {
        return noRekamMedis;
    }

    public List<String> getRiwayat() {
        return riwayatPenyakit;
    }

    public void tambahRiwayat(String penyakit) {
        riwayatPenyakit.add(penyakit);
    }

    // Override method abstract dari Person -> ini POLYMORPHISM
    @Override
    public void displayInfo() {
        System.out.println("=== Data Pasien ===");
        System.out.println("ID           : " + getId());
        System.out.println("Nama         : " + getNama());
        System.out.println("Umur         : " + getUmur());
        System.out.println("No. RM       : " + noRekamMedis);
        System.out.println("Riwayat      : " + (riwayatPenyakit.isEmpty() ? "Belum ada" : riwayatPenyakit));
    }
}