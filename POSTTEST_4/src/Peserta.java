public class Peserta {
    protected String nama;

    public Peserta(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Method ini akan di-override (ditimpa) oleh subclass-nya
    public void tampilkan() {
        System.out.print("- " + nama);
    }
}