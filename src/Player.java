import java.util.ArrayList;

public class Player {

    // Det rum spilleren står i lige nu
    // Feltet er private, så kun Player selv kan ændre det (indkapsling).
    private Room currentRoom;


    // Konstruktør: spilleren får sit startrum med, når den bliver oprettet.
    // Player ved ikke selv, hvilket rum der er startrummet - det bestemmer Map
    public Player(Room startRoom) {
        currentRoom = startRoom;
    }


    // Returnerer navn og beskrivelse af rummet, plus de ting/ items der ligger i det.
    public String look() {
        String text = currentRoom.getName() + "\n" + currentRoom.getDescription();
        ArrayList<Item> items = currentRoom.getItems();
        if (items.size() == 0) {
            text = text + "\nThere is nothing here.";

        } else {
            text = text + "\nHere you see:";
            for (int i = 0; i < items.size(); i++) {
                text = text + "\n- " + items.get(i).getLongName();
            }
        }
        return text;
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
