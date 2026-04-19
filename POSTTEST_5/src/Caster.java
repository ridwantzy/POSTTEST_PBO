public class Caster implements AktivitasEsport {
    private String namaCaster;

    public Caster(String namaCaster) {
        this.namaCaster = namaCaster;
    }

    public String getNamaCaster() {
        return namaCaster;
    }

    @Override
    public void persiapan() {
        System.out.println("🎙️ Caster " + namaCaster + " sedang tes mic (Cek 1, 2, 3) dan membaca statistik tim di meja panelis.");
    }

    @Override
    public void bertanding() {
        System.out.println("🎙️ Caster " + namaCaster + " mulai memandu jalannya pertandingan dengan heboh!");
    }
}