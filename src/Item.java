public class Item { //Item er en ting, spilleren kan samle op og lægge fra sig.

    // Det korte navn bruges, når spilleren skriver fx "take lamp".
    // Det lange navn bruges, når spillet skriver fx "You have taken a shiny brass lamp".
    private String shortName;
    private String longName;

    // Konstruktør: det korte navn kommer først, fx new Item("lamp", "a shiny brass lamp")
    public Item(String shortName, String longName) {
        this.shortName = shortName;
        this.longName = longName;
    }

    //getters
    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }

}
