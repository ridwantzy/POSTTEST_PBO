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

    public void tampilkan() {
        System.out.print("- " + nama);
    }
}