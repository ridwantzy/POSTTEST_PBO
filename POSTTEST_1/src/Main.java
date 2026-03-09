import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Tim> daftarTim = new ArrayList<>();

        int menu;

        while(true){
            System.out.println("\n===== Manajemen Tim Turnamen MOBILE LEGENDS =====");
            System.out.println("1. Tambah Tim");
            System.out.println("2. Lihat Data Tim");
            System.out.println("3. Edit Data Tim");
            System.out.println("4. Hapus Data Tim");
            System.out.println("5. Exit");

            System.out.print("Pilih menu : ");
            menu = input.nextInt();
            input.nextLine();

            switch(menu){
                case 1:
                    System.out.print("ID Tim : ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Nama Tim : ");
                    String namaTim = input.nextLine();

                    System.out.print("Jumlah pemain (5-9) : ");
                    int jumlah = input.nextInt();
                    input.nextLine();

                    if(jumlah < 5 || jumlah > 9){
                        System.out.println("Jumlah pemain harus antara 5 sampai 9!");
                        break;
                    }

                    ArrayList<Pemain> daftarPemain = new ArrayList<>();

                    for(int i=1; i<=jumlah; i++){
                        System.out.println("Pemain ke-" + i);

                        System.out.print("Nama : ");
                        String nama = input.nextLine();

                        System.out.print("Role : ");
                        String role = input.nextLine();

                        Pemain pemainBaru = new Pemain(nama, role);
                        daftarPemain.add(pemainBaru);
                    }

                    Tim timBaru = new Tim(id, namaTim, daftarPemain);
                    daftarTim.add(timBaru);

                    System.out.println("Tim berhasil ditambahkan");
                    break;

                case 2:
                    if(daftarTim.isEmpty()){
                        System.out.println("Belum ada data tim");
                    }else{
                        for(Tim t : daftarTim){
                            t.tampilkanTim();
                            System.out.println("---------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Masukkan ID Tim yang ingin diedit : ");
                    int idEdit = input.nextInt();
                    input.nextLine();

                    for (Tim t : daftarTim) {
                        if (t.idTim == idEdit) {
                            System.out.print("Nama Tim Baru : ");
                            t.namaTim = input.nextLine();

                            System.out.print("Jumlah pemain baru (5-9) : ");
                            int jumlahBaru = input.nextInt();
                            input.nextLine();

                            if (jumlahBaru < 5 || jumlahBaru > 9) {
                                System.out.println("Jumlah pemain harus antara 5 sampai 9");
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

                            t.daftarPemain = pemainBaru;

                            System.out.println("Data tim berhasil diperbarui");
                            break;
                        }
                        if(t == daftarTim.get(daftarTim.size()-1)){
                            System.out.println("ID Tim tidak ditemukan");
                        }
                    }
                    break;

                case 4:
                    System.out.print("Masukkan ID Tim yang ingin dihapus : ");
                    int idHapus = input.nextInt();
                    input.nextLine();

                    for(int i=0;i<daftarTim.size();i++){
                        if(daftarTim.get(i).idTim == idHapus){
                            daftarTim.remove(i);
                            System.out.println("Tim berhasil dihapus");
                            break;
                        }
                        if(i == daftarTim.size()-1){
                            System.out.println("ID Tim tidak ditemukan");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Program selesai");
                    return;

                default:
                    System.out.println("Menu tidak tersedia");
            }
        }
    }
}