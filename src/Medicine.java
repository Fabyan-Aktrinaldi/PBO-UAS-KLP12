public class Medicine {
    private String namaObat;
    private String kode;
    private int stok;
    private double harga;

    public Medicine(String kode, String namaObat, int stok, double harga) {
        this.kode = kode;
        this.namaObat = namaObat;
        this.stok = stok;
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public int getStok() {
        return stok;
    }

    public double getHarga() {
        return harga;
    }

    public void kurangiStok(int jumlah) {
        if (jumlah > stok) {
            System.out.println("Stok " + namaObat + " tidak cukup!");
            return;
        }
        stok -= jumlah;
    }

    public void tambahStok(int jumlah) {
        stok += jumlah;
    }

    @Override
    public String toString() {
        return namaObat + " (Rp" + harga + ") - Stok: " + stok;
    }
}