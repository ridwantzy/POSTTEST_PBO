public class Pemain extends Peserta {
    private String role;

    public Pemain(String nama, String role) {
        super(nama);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public void tampilkan() {
        System.out.println("- " + nama + " (Player Role: " + role + ")");
    }
}