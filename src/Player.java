public class Player {

    // Det rum spilleren står i lige nu
    // Feltet er private, så kun Player selv kan ændre det (indkapsling).
    private Room currentRoom;


    // Konstruktør: spilleren får sit startrum med, når den bliver oprettet.
    // Player ved ikke selv, hvilket rum der er startrummet - det bestemmer Map
    public Player(Room startRoom) {
        currentRoom = startRoom;
    }


    // Returnerer navn og beskrivelse af det rum spilleren står i.
    public String look() {
        return currentRoom.getName() + "\n" + currentRoom.getDescription();
    }


    // Hver metode tjekker om der er et rum i den retning (altså ikke null)
    // Er der et rum, returnerer metoden true hvis ikke bliver den false og spiller flytter ikke.
    // Adventure kan bare kalde player.goNorth() og behøver ikke vide,
    // hvordan rummene hænger sammen (Law of Demeter / lav kobling).
    public boolean goNorth() {
        if (currentRoom.getNorth() != null) {
            currentRoom = currentRoom.getNorth();
            return true;
        }
        return false;

    }

    public boolean goEast() {
        if (currentRoom.getEast() != null) {
            currentRoom = currentRoom.getEast();
            return true;
        }
        return false;
    }

    public boolean goWest() {
        if (currentRoom.getWest() != null) {
            currentRoom = currentRoom.getWest();
            return true;
        }
        return false;
    }


    public boolean goSouth() {
        if (currentRoom.getSouth() != null) {
            currentRoom = currentRoom.getSouth();
            return true;
        }
        return false;
    }
}
