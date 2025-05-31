package dll;

import java.util.Scanner;

public class DLLMain16 {
    public static void main(String[] args) {
        DoubleLinkedList16 list = new DoubleLinkedList16();
        Scanner scan = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu Double Linked List Mahasiswa");
            System.out.println("1.  Tambah di awal");
            System.out.println("2.  Tambah di akhir");
            System.out.println("3.  Hapus di awal");
            System.out.println("4.  Hapus di akhir");
            System.out.println("5.  Tampilkan data");
            System.out.println("6.  Sisipkan setelah NIM tertentu");
            System.out.println("7.  Cari Mahasiswa berdasarkan NIM");
            System.out.println("8.  Tambah node pada indeks tertentu");
            System.out.println("9.  Hapus node setelah indeks tertentu");
            System.out.println("10. Hapus berdasarkan indeks");
            System.out.println("11. Tampilkan data pertama");
            System.out.println("12. Tampilkan data terakhir");
            System.out.println("13. Tampilkan data pada indeks tertentu");
            System.out.println("14. Tampilkan jumlah data (size)");
            System.out.println("0.  Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan) {
                case 1 -> {
                    Mahasiswa16 mhs = inputMahasiswa(scan);
                    list.addFirst(mhs);
                }
                case 2 -> {
                    Mahasiswa16 mhs = inputMahasiswa(scan);
                    list.addLast(mhs);
                }
                case 3 -> list.removeFirst();
                case 4 -> list.removeLast();
                case 5 -> list.print();
                case 6 -> {
                    System.out.print("Masukkan NIM yang ingin disisipkan setelahnya: ");
                    String keyNIM = scan.nextLine();
                    Mahasiswa16 mhs = inputMahasiswa(scan);
                    list.insertAfter(keyNIM, mhs);
                }
                case 7 -> {
                    System.out.println("Masukkan NIM yang dicari: ");
                    String nim = scan.nextLine();
                    Node16 found = list.search(nim);
                    if (found != null) {
                        System.out.println("Data ditemukan:");
                        found.data.tampil();
                    } else {
                        System.out.println("Data tidak ditemukan.");
                    }
                }
                case 8 -> {
                    System.out.println("Masukkan indeks (mulai dari 0): ");
                    int index = scan.nextInt();
                    scan.nextLine();
                    Mahasiswa16 mhs = inputMahasiswa(scan);
                    list.add(index, mhs);
                }
                  case 9 -> { 
                    System.out.println("Masukkan NIM sebelum data yang ingin dihapus : ");
                    String keyNim = scan.nextLine();
                    list.removeAfter(keyNim);
                }
                case 10 -> {
                    System.out.print("Masukkan indeks yang ingin dihapus: ");
                    int index = scan.nextInt();
                    scan.nextLine();
                    list.remove(index);
                }

                case 11 -> list.getFirst();
                case 12 -> list.getLast();
                case 13 -> {
                    System.out.print("Masukkan indeks yang ingin dilihat: ");
                    int idx = scan.nextInt();
                    scan.nextLine();
                    list.getIndex(idx);
                }
                case 14 -> {
                    int jumlah = list.size();
                    System.out.println("Jumlah data dalam list saat ini: " + jumlah);
                }

                case 0 -> System.out.println("Keluar dari program!");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }

    public static Mahasiswa16 inputMahasiswa(Scanner scan) {
        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = scan.nextLine();
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = scan.nextLine();
        System.out.print("Masukkan Jurusan Mahasiswa: ");
        String jurusan = scan.nextLine();
        System.out.print("Masukkan Angkatan Mahasiswa: ");
        int angkatan = scan.nextInt();
        scan.nextLine();

        return new Mahasiswa16(nim, nama, jurusan, angkatan);
    }
}
