import java.util.ArrayList;
import java.util.List;

public class Prescription {
    private List<Medicine> listObat;
    private Doctor dokterPembuat;

    public Prescription(Doctor dokterPembuat) {
        this.dokterPembuat = dokterPembuat;
        this.listObat = new ArrayList<>(); // Composition: list ini "milik" Prescription sepenuhnya
    }

    public void tambahObat(Medicine obat) {
        listObat.add(obat);
        System.out.println(obat.getNamaObat() + " ditambahkan ke resep.");
    }

    public void hapusObat(String kodeObat) {
        listObat.removeIf(m -> m.getKode().equals(kodeObat));
    }

    public List<Medicine> getListObat() {
        return listObat;
    }

    public double hitungTotal() {
        double total = 0;
        for (Medicine m : listObat) {
            total += m.getHarga();
        }
        return total;
    }

    public void displayResep() {
        System.out.println("=== Resep dari Dr. " + dokterPembuat.getNama() + " ===");
        if (listObat.isEmpty()) {
            System.out.println("Belum ada obat dalam resep.");
        } else {
            for (Medicine m : listObat) {
                System.out.println("- " + m);
            }
        }
        System.out.println("Total: Rp" + hitungTotal());
    }
}