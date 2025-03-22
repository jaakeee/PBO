package model;

public class Costume {
    private int id;
    private String name;
    private String size;
    private double price;

    public Costume(int id, String name, String size, double price) {
        this.id = id;
        this.name = name;
        this.size = size;
        setPrice(price); // Menggunakan setter untuk validasi harga
    }

    // Getter dan Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public double getPrice() { return price; }
    
    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Harga tidak boleh negatif! Mengatur harga ke 0.");
            this.price = 0;
        } else {
            this.price = price;
        }
    }

    // Metode protected (hanya bisa diakses oleh subclass)
    protected void displayInfo() {
        System.out.println("ID: " + id + ", Nama: " + name + ", Ukuran: " + size + ", Harga: Rp" + String.format("%.2f", price));
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nama: " + name + ", Ukuran: " + size + ", Harga: Rp" + String.format("%.2f", price);
    }
}
