import java.util.ArrayList;

public class Tim implements AktivitasEsport {
    private int idTim;
    private String namaTim;
    private ArrayList<Pelatih> daftarPelatih;
    private ArrayList<Pemain> daftarPemain;

    public Tim(int idTim, String namaTim, ArrayList<Pelatih> daftarPelatih, ArrayList<Pemain> daftarPemain) {
        this.idTim = idTim;
        this.namaTim = namaTim;
        this.daftarPelatih = daftarPelatih;
        this.daftarPemain = daftarPemain;
    }

    public int getIdTim() { return idTim; }
    public void setIdTim(int idTim) { this.idTim = idTim; }

    public String getNamaTim() { return namaTim; }
    public void setNamaTim(String namaTim) { this.namaTim = namaTim; }

    public ArrayList<Pelatih> getDaftarPelatih() { return daftarPelatih; }
    public void setDaftarPelatih(ArrayList<Pelatih> daftarPelatih) { this.daftarPelatih = daftarPelatih; }

    public ArrayList<Pemain> getDaftarPemain() { return daftarPemain; }
    public void setDaftarPemain(ArrayList<Pemain> daftarPemain) { this.daftarPemain = daftarPemain; }

    public void tambahPeserta(Pemain pemainBaru) {
        this.daftarPemain.add(pemainBaru);
        System.out.println("-> [Sistem] Pemain " + pemainBaru.getNama() + " (" + pemainBaru.getRole() + ") resmi bergabung dengan tim " + this.namaTim);
    }

    public void tambahPeserta(Pelatih pelatihBaru) {
        this.daftarPelatih.add(pelatihBaru);
        System.out.println("-> [Sistem] Coach " + pelatihBaru.getNama() + " (Spesialis: " + pelatihBaru.getSpesialisasi() + ") resmi direkrut oleh tim " + this.namaTim);
    }

    public void hapusPeserta(Pemain pemainKeluar) {
        if (this.daftarPemain.remove(pemainKeluar)) {
            System.out.println("-> [Sistem] WARNING: Pemain " + pemainKeluar.getNama() + " (" + pemainKeluar.getRole() + ") telah dikeluarkan dari tim " + this.namaTim);
        } else {
            System.out.println("-> [Sistem] Gagal: Pemain tidak ditemukan.");
        }
    }

    public void hapusPeserta(Pelatih pelatihKeluar) {
        if (this.daftarPelatih.remove(pelatihKeluar)) {
            System.out.println("-> [Sistem] WARNING: Kontrak Coach " + pelatihKeluar.getNama() + " telah diputus oleh tim " + this.namaTim);
        } else {
            System.out.println("-> [Sistem] Gagal: Coach tidak ditemukan.");
        }
    }

    public void tampilkanTim() {
        System.out.println("ID Tim    : " + idTim);
        System.out.println("Nama Tim  : " + namaTim);

        System.out.println("Daftar Coaching Staff :");
        if (daftarPelatih.isEmpty()) {
            System.out.println("- Tidak ada coaching staff");
        } else {
            for (Pelatih pelatih : daftarPelatih) {
                pelatih.tampilkan();
            }
        }

        System.out.println("Daftar Pemain :");
        for (Pemain p : daftarPemain) {
            p.tampilkan();
        }
    }

    @Override
    public void persiapan() {
        System.out.println("Tim " + namaTim + " sedang melakukan briefing dan pemanasan device serta melakukan tes ping.");
    }

    @Override
    public void bertanding() {
        System.out.println("Tim " + namaTim + " sedang bertanding di Land of Dawn untuk memperebutkan poin!");
    }
}