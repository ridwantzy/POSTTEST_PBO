public class Pemain {

    String nama;
    String role;

    Pemain(String nama, String role){
        this.nama = nama;
        this.role = role;
    }

    void tampilkan(){
        System.out.println("- " + nama + " (" + role + ")");
    }
}