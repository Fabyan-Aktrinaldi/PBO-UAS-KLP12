import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
    private String spesialisasi;
    private List<String> jadwalPraktek;
    private double tarif;

    public Doctor(String id, String nama, int umur, String telepon, String spesialisasi, double tarif) {
        super(id, nama, umur, telepon); // panggil constructor Person
        this.spesialisasi = spesialisasi;
        this.tarif = tarif;
        this.jadwalPraktek = new ArrayList<>();
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public List<String> getJadwal() {
        return jadwalPraktek;
    }

    public void tambahJadwal(String jadwal) {
        jadwalPraktek.add(jadwal);
    }

    public double getTarif() {
        return tarif;
    }

    // Override method abstract dari Person -> POLYMORPHISM
    @Override
    public void displayInfo() {
        System.out.println("=== Data Dokter ===");
        System.out.println("ID           : " + getId());
        System.out.println("Nama         : Dr. " + getNama());
        System.out.println("Umur         : " + getUmur());
        System.out.println("Spesialisasi : " + spesialisasi);
        System.out.println("Tarif        : Rp" + tarif);
        System.out.println("Jadwal       : " + (jadwalPraktek.isEmpty() ? "Belum ada" : jadwalPraktek));
    }
}