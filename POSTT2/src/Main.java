import model.Costume;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Costume> costumeList = new ArrayList<>();
    private static int idCounter = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== RENTAL COSTUME ===");
            System.out.println("1. Tambah Costume");
            System.out.println("2. Lihat Daftar Costume");
            System.out.println("3. Edit Costume");
            System.out.println("4. Hapus Costume");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            
            int pilihan;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
                continue;
            }

            switch (pilihan) {
                case 1:
                    tambahCostume();
                    break;
                case 2:
                    lihatCostume();
                    break;
                case 3:
                    editCostume();
                    break;
                case 4:
                    hapusCostume();
                    break;
                case 5:
                    System.out.println("Terima kasih! Program berakhir.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid! Coba lagi.");
            }
        }
    }

    private static void tambahCostume() {
        System.out.println("\n=== Tambah Costume ===");
        System.out.print("Nama Costume: ");
        String name = scanner.nextLine();
        System.out.print("Ukuran Costume: ");
        String size = scanner.nextLine();
        System.out.print("Harga Costume: ");

        double price;
        try {
            price = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Harga harus berupa angka!");
            return;
        }

        Costume costume = new Costume(idCounter++, name, size, price);
        costumeList.add(costume);
        System.out.println("Costume berhasil ditambahkan!");
    }

    private static void lihatCostume() {
        System.out.println("\n=== Daftar Costume ===");
        if (costumeList.isEmpty()) {
            System.out.println("Belum ada costume yang tersedia.");
            return;
        }

        for (Costume costume : costumeList) {
            System.out.println(costume);
        }
    }

    private static void editCostume() {
        System.out.println("\n=== Edit Costume ===");
        System.out.print("Masukkan ID Costume yang ingin diubah: ");

        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID harus berupa angka!");
            return;
        }

        for (Costume costume : costumeList) {
            if (costume.getId() == id) {
                System.out.print("Nama baru (kosongkan jika tidak ingin mengubah): ");
                String name = scanner.nextLine();
                if (!name.isEmpty()) costume.setName(name);

                System.out.print("Ukuran baru (kosongkan jika tidak ingin mengubah): ");
                String size = scanner.nextLine();
                if (!size.isEmpty()) costume.setSize(size);

                System.out.print("Harga baru (kosongkan jika tidak ingin mengubah): ");
                String priceInput = scanner.nextLine();
                if (!priceInput.isEmpty()) {
                    try {
                        costume.setPrice(Double.parseDouble(priceInput));
                    } catch (NumberFormatException e) {
                        System.out.println("Harga harus berupa angka!");
                        return;
                    }
                }

                System.out.println("Costume berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Costume dengan ID tersebut tidak ditemukan.");
    }

    private static void hapusCostume() {
        System.out.println("\n=== Hapus Costume ===");
        System.out.print("Masukkan ID Costume yang ingin dihapus: ");

        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID harus berupa angka!");
            return;
        }

        for (Costume costume : costumeList) {
            if (costume.getId() == id) {
                costumeList.remove(costume);
                System.out.println("Costume berhasil dihapus!");
                return;
            }
        }
        System.out.println("Costume dengan ID tersebut tidak ditemukan.");
    }
}

