package model;

public class AnimeCostume extends Costume {
    private String characterName;
    private String animeTitle;

    public AnimeCostume(int id, String name, String size, double price, String characterName, String animeTitle) {
        super(id, name, size, price);
        this.characterName = characterName;
        this.animeTitle = animeTitle;
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getAnimeTitle() {
        return animeTitle;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public void setAnimeTitle(String animeTitle) {
        this.animeTitle = animeTitle;
    }

    @Override
    public String getCostumeInfo() {
        return "Karakter: " + characterName + ", Anime: " + animeTitle;
    }
}
