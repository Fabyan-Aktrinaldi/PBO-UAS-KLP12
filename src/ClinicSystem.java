import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClinicSystem {
    private List<Patient> daftarPasien;
    private List<Doctor> daftarDokter;
    private List<Appointment> daftarJanji;
    private Scanner scanner;

    public ClinicSystem() {
        daftarPasien = new ArrayList<>();
        daftarDokter = new ArrayList<>();
        daftarJanji = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        seedData(); // isi data contoh biar pas demo langsung ada isinya
        menuUtama();
    }

    // Data contoh supaya saat demo tidak perlu input manual dari nol
    private void seedData() {
        Doctor d1 = new Doctor("D01", "Andi Saputra", 40, "0811111111", "Umum", 50000);
        Doctor d2 = new Doctor("D02", "Siti Aminah", 38, "0822222222", "Anak", 75000);
        daftarDokter.add(d1);
        daftarDokter.add(d2);

        Patient p1 = new Patient("P01", "Budi Santoso", 25, "0833333333", "RM001");
        daftarPasien.add(p1);
    }

    public void menuUtama() {
        int pilihan;
        do {
            System.out.println("\n===== SISTEM MANAJEMEN KLINIK =====");
            System.out.println("1. Registrasi Pasien");
            System.out.println("2. Lihat Daftar Pasien");
            System.out.println("3. Lihat Daftar Dokter");
            System.out.println("4. Buat Janji Konsultasi");
            System.out.println("5. Lihat Daftar Janji");
            System.out.println("6. Proses Resep & Pembayaran (Demo)");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = Integer.parseInt(scanner.nextLine());

            switch (pilihan) {
                case 1 -> registrasiPasien();
                case 2 -> lihatPasien();
                case 3 -> lihatDokter();
                case 4 -> buatJanji();
                case 5 -> lihatJanji();
                case 6 -> prosesResepDanPembayaran();
                case 0 -> System.out.println("Terima kasih telah menggunakan Sistem Manajemen Klinik.");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    public void registrasiPasien() {
        System.out.print("ID Pasien: ");
        String id = scanner.nextLine();
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Umur: ");
        int umur = Integer.parseInt(scanner.nextLine());
        System.out.print("Telepon: ");
        String telepon = scanner.nextLine();
        System.out.print("No. Rekam Medis: ");
        String noRM = scanner.nextLine();

        Patient pasienBaru = new Patient(id, nama, umur, telepon, noRM);
        daftarPasien.add(pasienBaru);
        System.out.println("Pasien berhasil didaftarkan!");
    }

    public void lihatPasien() {
        if (daftarPasien.isEmpty()) {
            System.out.println("Belum ada pasien terdaftar.");
            return;
        }
        for (Patient p : daftarPasien) {
            p.displayInfo();
            System.out.println("--------------------");
        }
    }

    public void lihatDokter() {
        for (Doctor d : daftarDokter) {
            d.displayInfo();
            System.out.println("--------------------");
        }
    }

public void buatJanji() {
    if (daftarPasien.isEmpty() || daftarDokter.isEmpty()) {
        System.out.println("Data pasien/dokter belum tersedia.");
        return;
    }

    lihatPasien();
    System.out.println("(Index pasien yang valid: 0 sampai " + (daftarPasien.size() - 1) + ")");
    System.out.print("Pilih index pasien: ");
    int idxP = Integer.parseInt(scanner.nextLine());
    if (idxP < 0 || idxP >= daftarPasien.size()) {
        System.out.println("Index pasien tidak valid. Kembali ke menu utama.");
        return;
    }

    lihatDokter();
    System.out.println("(Index dokter yang valid: 0 sampai " + (daftarDokter.size() - 1) + ")");
    System.out.print("Pilih index dokter: ");
    int idxD = Integer.parseInt(scanner.nextLine());
    if (idxD < 0 || idxD >= daftarDokter.size()) {
        System.out.println("Index dokter tidak valid. Kembali ke menu utama.");
        return;
    }

    System.out.print("Tanggal konsultasi (contoh: 22-06-2026): ");
    String tanggal = scanner.nextLine();

    Appointment janji = new Appointment(daftarPasien.get(idxP), daftarDokter.get(idxD), tanggal);
    daftarJanji.add(janji);
    System.out.println("Janji konsultasi berhasil dibuat!");
}
    
    public void lihatJanji() {
        if (daftarJanji.isEmpty()) {
            System.out.println("Belum ada janji konsultasi.");
            return;
        }
        for (Appointment a : daftarJanji) {
            a.displayDetail();
            System.out.println("--------------------");
        }
    }

    // Method demo yang merangkai Prescription, Medicine, dan Payment sekaligus
    public void prosesResepDanPembayaran() {
        if (daftarJanji.isEmpty()) {
            System.out.println("Belum ada janji konsultasi. Buat janji dulu (menu 4).");
            return;
        }

        Appointment janji = daftarJanji.get(daftarJanji.size() - 1); // ambil janji terakhir
        janji.konfirmasi();

        Prescription resep = new Prescription(janji.getDoctor());
        resep.tambahObat(new Medicine("M01", "Paracetamol", 100, 5000));
        resep.tambahObat(new Medicine("M02", "Vitamin C", 50, 10000));
        resep.displayResep();

        Payment pembayaran = new Payment(janji, "Tunai");
        pembayaran.proses();
        pembayaran.cetakStruk();
    }
}