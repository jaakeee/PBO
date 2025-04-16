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
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "ID: " + id + " | Nama: " + name + " | Ukuran: " + size + " | Harga: " + price;
    }

    public void setPrice(double price, double discount) {
        this.price = price - (price * discount);
    }
}
