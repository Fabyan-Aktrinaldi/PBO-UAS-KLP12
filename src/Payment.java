public class Payment {
    private Appointment appointment;
    private double totalTagihan;
    private String metodeBayar;
    private String status; // "Belum Bayar", "Lunas"

    public Payment(Appointment appointment, String metodeBayar) {
        this.appointment = appointment;
        this.metodeBayar = metodeBayar;
        this.totalTagihan = hitungTagihan();
        this.status = "Belum Bayar";
    }

    public double hitungTagihan() {
        // Tagihan dasar diambil dari tarif dokter pada appointment terkait
        return appointment.getDoctor().getTarif();
    }

    public void proses() {
        status = "Lunas";
        System.out.println("Pembayaran sebesar Rp" + totalTagihan + " berhasil diproses.");
    }

    public void cetakStruk() {
        System.out.println("======= STRUK PEMBAYARAN =======");
        System.out.println("Pasien   : " + appointment.getPatient().getNama());
        System.out.println("Dokter   : Dr. " + appointment.getDoctor().getNama());
        System.out.println("Tanggal  : " + appointment.getTanggal());
        System.out.println("Metode   : " + metodeBayar);
        System.out.println("Total    : Rp" + totalTagihan);
        System.out.println("Status   : " + status);
        System.out.println("=================================");
    }

    public String getStatus() {
        return status;
    }
}