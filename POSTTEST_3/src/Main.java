import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Tim> daftarTim = new ArrayList<>();
        int menu;

        while (true) {
            System.out.println("\n===== Manajemen Tim Turnamen MOBILE LEGENDS =====");
            System.out.println("1. Tambah Tim");
            System.out.println("2. Lihat Data Tim");
            System.out.println("3. Edit Data Tim");
            System.out.println("4. Hapus Data Tim");
            System.out.println("5. Exit");
            System.out.print("Pilih menu : ");

            menu = input.nextInt();
            input.nextLine();

            switch (menu) {
                case 1:
                    System.out.print("ID Tim : ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Nama Tim : ");
                    String namaTim = input.nextLine();

                    System.out.println("--- Data Pelatih ---");
                    System.out.print("Jumlah coaching staff : ");
                    int jumlahPelatih = input.nextInt();
                    input.nextLine();

                    ArrayList<Pelatih> daftarPelatih = new ArrayList<>();
                    for (int i = 1; i <= jumlahPelatih; i++) {
                        System.out.println("Staf Pelatih ke-" + i);
                        System.out.print("Nama Pelatih : ");
                        String namaPelatih = input.nextLine();
                        System.out.print("Spesialisasi (Misal: Head Coach/Analyst) : ");
                        String spesialisasi = input.nextLine();

                        Pelatih pelatihBaru = new Pelatih(namaPelatih, spesialisasi);
                        daftarPelatih.add(pelatihBaru);
                    }

                    System.out.println("--- Data Pemain ---");
                    System.out.print("Jumlah pemain (5-9) : ");
                    int jumlah = input.nextInt();
                    input.nextLine();

                    if (jumlah < 5 || jumlah > 9) {
                        System.out.println("Jumlah pemain harus antara 5 sampai 9!");
                        break;
                    }

                    ArrayList<Pemain> daftarPemain = new ArrayList<>();
                    for (int i = 1; i <= jumlah; i++) {
                        System.out.println("Pemain ke-" + i);
                        System.out.print("Nama : ");
                        String nama = input.nextLine();
                        System.out.print("Role : ");
                        String role = input.nextLine();

                        Pemain pemainBaru = new Pemain(nama, role);
                        daftarPemain.add(pemainBaru);
                    }

                    Tim timBaru = new Tim(id, namaTim, daftarPelatih, daftarPemain);
                    daftarTim.add(timBaru);

                    System.out.println("Tim berhasil ditambahkan!");
                    break;

                case 2:
                    if (daftarTim.isEmpty()) {
                        System.out.println("Belum ada data tim");
                    } else {
                        for (Tim t : daftarTim) {
                            t.tampilkanTim();
                            System.out.println("---------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Masukkan ID Tim yang ingin diedit : ");
                    int idEdit = input.nextInt();
                    input.nextLine();

                    boolean isFoundEdit = false;
                    for (Tim t : daftarTim) {
                        if (t.getIdTim() == idEdit) {
                            isFoundEdit = true;
                            System.out.print("Nama Tim Baru : ");
                            t.setNamaTim(input.nextLine());

                            System.out.println("--- Data Pelatih Baru ---");
                            System.out.print("Jumlah coaching staff baru : ");
                            int jumlahPelatihBaru = input.nextInt();
                            input.nextLine();

                            ArrayList<Pelatih> pelatihBaru = new ArrayList<>();
                            for (int i = 1; i <= jumlahPelatihBaru; i++) {
                                System.out.println("Staf Pelatih ke-" + i);
                                System.out.print("Nama Pelatih : ");
                                String namaPelatihBaru = input.nextLine();
                                System.out.print("Spesialisasi (Misal: Head Coach/Analyst) : ");
                                String spesialisasiBaru = input.nextLine();

                                pelatihBaru.add(new Pelatih(namaPelatihBaru, spesialisasiBaru));
                            }
                            t.setDaftarPelatih(pelatihBaru);

                            System.out.println("--- Data Pemain Baru ---");
                            System.out.print("Jumlah pemain baru (5-9) : ");
                            int jumlahBaru = input.nextInt();
                            input.nextLine();

                            if (jumlahBaru < 5 || jumlahBaru > 9) {
                                System.out.println("Jumlah pemain harus antara 5 sampai 9!");
                                break;
                            }

                            ArrayList<Pemain> pemainBaru = new ArrayList<>();
                            for (int i = 1; i <= jumlahBaru; i++) {
                                System.out.println("Pemain ke-" + i);
                                System.out.print("Nama Pemain : ");
                                String nama = input.nextLine();
                                System.out.print("Role : ");
                                String role = input.nextLine();
                                Pemain p = new Pemain(nama, role);
                                pemainBaru.add(p);
                            }

                            t.setDaftarPemain(pemainBaru);

                            System.out.println("Data tim berhasil diperbarui!");
                            break;
                        }
                    }
                    if (!isFoundEdit) {
                        System.out.println("ID Tim tidak ditemukan!");
                    }
                    break;

                case 4:
                    System.out.print("Masukkan ID Tim yang ingin dihapus : ");
                    int idHapus = input.nextInt();
                    input.nextLine();

                    boolean isFoundDelete = false;
                    for (int i = 0; i < daftarTim.size(); i++) {
                        if (daftarTim.get(i).getIdTim() == idHapus) {
                            daftarTim.remove(i);
                            System.out.println("Tim berhasil dihapus!");
                            isFoundDelete = true;
                            break;
                        }
                    }
                    if (!isFoundDelete) {
                        System.out.println("ID Tim tidak ditemukan!");
                    }
                    break;

                case 5:
                    System.out.println("Program selesai. GGWP!");
                    return;

                default:
                    System.out.println("Menu tidak tersedia!");
            }
        }
    }
}