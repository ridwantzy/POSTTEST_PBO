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

                    Tim timBaru = new Tim(id, namaTim, new ArrayList<>(), new ArrayList<>());

                    System.out.println("--- Data Pelatih ---");
                    System.out.print("Jumlah coaching staff : ");
                    int jumlahPelatih = input.nextInt();
                    input.nextLine();

                    for (int i = 1; i <= jumlahPelatih; i++) {
                        System.out.println("Staf Pelatih ke-" + i);
                        System.out.print("Nama Pelatih : ");
                        String namaPelatih = input.nextLine();
                        System.out.print("Spesialisasi (Misal: Head Coach/Analyst) : ");
                        String spesialisasi = input.nextLine();

                        Pelatih pelatihBaru = new Pelatih(namaPelatih, spesialisasi);
                        timBaru.tambahPeserta(pelatihBaru);
                    }

                    System.out.println("--- Data Pemain ---");
                    System.out.print("Jumlah pemain (5-9) : ");
                    int jumlah = input.nextInt();
                    input.nextLine();

                    if (jumlah < 5 || jumlah > 9) {
                        System.out.println("Jumlah pemain harus antara 5 sampai 9!");
                        break;
                    }

                    for (int i = 1; i <= jumlah; i++) {
                        System.out.println("Pemain ke-" + i);
                        System.out.print("Nama : ");
                        String nama = input.nextLine();
                        System.out.print("Role : ");
                        String role = input.nextLine();

                        Pemain pemainBaru = new Pemain(nama, role);
                        timBaru.tambahPeserta(pemainBaru);
                    }

                    daftarTim.add(timBaru);
                    System.out.println("\nTim " + namaTim + " berhasil ditambahkan Untuk megikuti Tournament MPL!");

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
                            System.out.println("\n--- Manajemen Tim: " + t.getNamaTim() + " ---");
                            System.out.println("1. Ubah Nama Tim");
                            System.out.println("2. Rekrut Pemain Baru (Tambah)");
                            System.out.println("3. Rekrut Coach Baru (Tambah)");
                            System.out.println("4. Kick Pemain (Hapus)");
                            System.out.println("5. Putus Kontrak Coach (Hapus)");
                            System.out.print("Pilih aksi manajemen : ");

                            int aksi = input.nextInt();
                            input.nextLine();

                            switch (aksi) {
                                case 1:
                                    System.out.print("Nama Tim Baru: ");
                                    t.setNamaTim(input.nextLine());
                                    System.out.println("Nama tim berhasil diubah!");
                                    break;

                                case 2:
                                    System.out.print("Nama Pemain Baru: ");
                                    String namaPemain = input.nextLine();
                                    System.out.print("Role: ");
                                    String role = input.nextLine();
                                    t.tambahPeserta(new Pemain(namaPemain, role));
                                    break;

                                case 3:
                                    System.out.print("Nama Coach Baru: ");
                                    String namaCoach = input.nextLine();
                                    System.out.print("Spesialisasi: ");
                                    String spek = input.nextLine();
                                    t.tambahPeserta(new Pelatih(namaCoach, spek));
                                    break;

                                case 4:
                                    System.out.print("Masukkan nama Pemain yang akan di-kick: ");
                                    String namaKickPemain = input.nextLine();
                                    Pemain targetPemain = null;
                                    for (Pemain p : t.getDaftarPemain()) {
                                        if (p.getNama().equalsIgnoreCase(namaKickPemain)) {
                                            targetPemain = p;
                                            break;
                                        }
                                    }
                                    if (targetPemain != null) {
                                        t.hapusPeserta(targetPemain);
                                    } else {
                                        System.out.println("Gagal: Pemain tidak ditemukan di tim ini.");
                                    }
                                    break;

                                case 5:
                                    System.out.print("Masukkan nama Coach yang akan diputus kontraknya: ");
                                    String namaKickCoach = input.nextLine();
                                    Pelatih targetCoach = null;
                                    for (Pelatih pel : t.getDaftarPelatih()) {
                                        if (pel.getNama().equalsIgnoreCase(namaKickCoach)) {
                                            targetCoach = pel;
                                            break;
                                        }
                                    }
                                    if (targetCoach != null) {
                                        t.hapusPeserta(targetCoach);
                                    } else {
                                        System.out.println("Gagal: Coach tidak ditemukan di tim ini.");
                                    }
                                    break;

                                default:
                                    System.out.println("Pilihan aksi tidak valid!");
                            }
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