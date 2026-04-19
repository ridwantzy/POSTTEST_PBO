public class Pelatih extends Peserta {
    private String spesialisasi;

    public Pelatih(String nama, String spesialisasi) {
        super(nama);
        this.spesialisasi = spesialisasi;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

    @Override
    public void tampilkan() {
        System.out.println("- " + nama + " (Coach Spesialisasi: " + spesialisasi + ")");
    }
}