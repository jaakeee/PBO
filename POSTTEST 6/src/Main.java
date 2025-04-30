import model.Costume;
import model.AnimeCostume;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Costume> costumeList = new ArrayList<>();
    private static int idCounter = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== RENTAL COSTUME ANIME ===");
            System.out.println("1. Tambah Costume Anime");
            System.out.println("2. Lihat Daftar Costume");
            System.out.println("3. Edit Costume");
            System.out.println("4. Hapus Costume");
            System.out.println("5. Total Costume");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
                continue;
            }

            switch (pilihan) {
                case 1 -> tambahCostume();
                case 2 -> lihatCostume();
                case 3 -> editCostume();
                case 4 -> hapusCostume();
                case 5 -> tampilkanJumlahCostume();
                case 6 -> {
                    System.out.println("Arigatou~ Program selesai ");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid! Coba lagi.");
            }
        }
    }

    public static void tampilkanJumlahCostume() {
        System.out.println("Total costume saat ini: " + costumeList.size());
    }

    private static void tambahCostume() {
        System.out.println("\n=== Tambah Costume Anime ===");
        System.out.print("Nama Costume: ");
        String name = scanner.nextLine();
        System.out.print("Ukuran Costume: ");
        String size = scanner.nextLine();

        double price;
        try {
            System.out.print("Harga Costume: ");
            price = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Harga harus berupa angka!");
            return;
        }

        System.out.print("Nama Karakter Anime: ");
        String character = scanner.nextLine();
        System.out.print("Judul Anime: ");
        String anime = scanner.nextLine();

        Costume costume = new AnimeCostume(idCounter++, name, size, price, character, anime);
        costumeList.add(costume);
        System.out.println("Costume anime berhasil ditambahkan!");
    }

    private static void lihatCostume() {
        System.out.println("\n=== Daftar Costume Anime ===");
        if (costumeList.isEmpty()) {
            System.out.println("Belum ada costume anime.");
            return;
        }

        for (Costume costume : costumeList) {
            costume.displayInfo();
            System.out.println("-----");
        }
    }

    private static void editCostume() {
        System.out.println("\n=== Edit Costume ===");
        System.out.print("Masukkan ID Costume: ");
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

                if (costume instanceof AnimeCostume animeCostume) {
                    System.out.print("Karakter baru (kosongkan jika tidak ingin mengubah): ");
                    String charName = scanner.nextLine();
                    if (!charName.isEmpty()) animeCostume.setCharacterName(charName);

                    System.out.print("Judul anime baru (kosongkan jika tidak ingin mengubah): ");
                    String animeTitle = scanner.nextLine();
                    if (!animeTitle.isEmpty()) animeCostume.setAnimeTitle(animeTitle);
                }

                System.out.println("Costume berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Costume dengan ID tersebut tidak ditemukan.");
    }

    private static void hapusCostume() {
        System.out.println("\n=== Hapus Costume ===");
        System.out.print("Masukkan ID Costume: ");
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
