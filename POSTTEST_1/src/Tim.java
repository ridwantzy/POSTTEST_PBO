import java.util.ArrayList;

public class Tim {

    int idTim;
    String namaTim;
    ArrayList<Pemain> daftarPemain;

    Tim(int idTim, String namaTim, ArrayList<Pemain> daftarPemain){
        this.idTim = idTim;
        this.namaTim = namaTim;
        this.daftarPemain = daftarPemain;
    }

    void tampilkanTim(){

        System.out.println("ID Tim : " + idTim);
        System.out.println("Nama Tim : " + namaTim);

        System.out.println("Daftar Pemain :");

        for(Pemain p : daftarPemain){
            p.tampilkan();
        }
    }
}