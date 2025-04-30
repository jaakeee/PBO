package model;

public class AnimeCostume extends Costume implements Deskripsi {
    private String characterName;
    private String animeTitle;

    public AnimeCostume(int id, String name, String size, double price, String characterName, String animeTitle) {
        super(id, name, size, price);
        this.characterName = characterName;
        this.animeTitle = animeTitle;
    }

    public String getCharacterName() { return characterName; }
    public void setCharacterName(String characterName) { this.characterName = characterName; }

    public String getAnimeTitle() { return animeTitle; }
    public void setAnimeTitle(String animeTitle) { this.animeTitle = animeTitle; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Karakter: " + characterName);
        System.out.println("Anime: " + animeTitle);
    }

    @Override
    public String toString() {
        return super.toString() + ", Karakter: " + characterName + ", Anime: " + animeTitle;
    }

    @Override
    public void tampilkanDeskripsi() {
        System.out.println("Costume karakter anime: " + getName());
    }

    @Override
    public void tampilkanAsal() {
        System.out.println("Asal anime: " + animeTitle);
    }
}
