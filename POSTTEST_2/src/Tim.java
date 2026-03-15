import java.util.ArrayList;

public class Tim {

    private int idTim;
    private String namaTim;
    private ArrayList<Pemain> daftarPemain;

    public Tim(int idTim, String namaTim, ArrayList<Pemain> daftarPemain){
        this.idTim = idTim;
        this.namaTim = namaTim;
        this.daftarPemain = daftarPemain;
    }

    public int getIdTim(){
        return idTim;
    }

    public void setIdTim(int idTim){
        this.idTim = idTim;
    }

    public String getNamaTim(){
        return namaTim;
    }

    public void setNamaTim(String namaTim){
        this.namaTim = namaTim;
    }

    public ArrayList<Pemain> getDaftarPemain(){
        return daftarPemain;
    }

    public void setDaftarPemain(ArrayList<Pemain> daftarPemain){
        this.daftarPemain = daftarPemain;
    }

    public void tampilkanTim(){

        System.out.println("ID Tim : " + idTim);
        System.out.println("Nama Tim : " + namaTim);

        System.out.println("Daftar Pemain :");

        for(Pemain p : daftarPemain){
            p.tampilkan();
        }
    }
}