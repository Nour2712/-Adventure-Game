// Adventure er controlleren: den starter spillet og sender beskeder videre
// fra Userinterface til Player. Den er "single point of entry" for Userinterface.
public class Adventure {

    // Spilleren, som holder styr på, hvor man er.
    private Player player;

    // Konstruktør: bygger kortet og placerer spilleren i startrummet.
    public Adventure() {
        Map map = new Map();
        player = new Player(map.getStartRoom());
    }

    // Beder spilleren om at kigge rundt og sender teksten videre.
    public String look() {
        return player.look();
    }

    // Beder spilleren om at gå. Adventure tjekker ikke selv noget,
    // den sender bare svaret (true/false) videre (Law of Demeter).
    public boolean goNorth() {
        return player.goNorth();
    }

    public boolean goEast() {
        return player.goEast();
    }

    public boolean goSouth() {
        return player.goSouth();
    }

    public boolean goWest() {
        return player.goWest();
    }
}
