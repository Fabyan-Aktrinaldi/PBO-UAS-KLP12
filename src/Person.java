public abstract class Person {
    private String id;
    private String nama;
    private int umur;
    private String telepon;

    public Person(String id, String nama, int umur, String telepon) {
        this.id = id;
        this.nama = nama;
        this.umur = umur;
        this.telepon = telepon;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getUmur() {
        return umur;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    // Method abstract - WAJIB di-override sama class turunan (Patient, Doctor)
    public abstract void displayInfo();
}