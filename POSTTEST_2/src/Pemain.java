public class Pemain {

    private String nama;
    private String role;

    public Pemain(String nama, String role){
        this.nama = nama;
        this.role = role;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getRole(){
        return role;
    }

    public void setRole(String role){
        this.role = role;
    }

    public void tampilkan(){
        System.out.println("- " + nama + " (" + role + ")");
    }
}