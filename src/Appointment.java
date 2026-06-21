public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String tanggal;
    private String status; // "Menunggu", "Selesai", "Batal"

    public Appointment(Patient patient, Doctor doctor, String tanggal) {
        this.patient = patient;
        this.doctor = doctor;
        this.tanggal = tanggal;
        this.status = "Menunggu"; // status awal saat janji dibuat
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void konfirmasi() {
        status = "Selesai";
        System.out.println("Appointment " + patient.getNama() + " dengan Dr. " + doctor.getNama() + " telah selesai.");
    }

    public void batalkan() {
        status = "Batal";
        System.out.println("Appointment " + patient.getNama() + " dibatalkan.");
    }

    public void displayDetail() {
        System.out.println("=== Detail Appointment ===");
        System.out.println("Pasien   : " + patient.getNama());
        System.out.println("Dokter   : Dr. " + doctor.getNama() + " (" + doctor.getSpesialisasi() + ")");
        System.out.println("Tanggal  : " + tanggal);
        System.out.println("Status   : " + status);
    }
}