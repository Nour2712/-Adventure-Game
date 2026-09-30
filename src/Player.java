import java.util.ArrayList;

public class Player {
    private Room currentroom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int health = 100;


    public Player(Room startRoom){
        this.currentroom = startRoom;
    }

    //health getter og setter metode

    public int getHealth() {
        return health;
    }

    //ekstra metode bare hvis man skal sætte health
    public void setHealth(int health) {
        this.health = health;
    }

    public EatResult eat(String itemName) {
        Item foundItem = null;

        //Led først i dit inventory
        for (Item item : inventory) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                foundItem = item;
                break;
            }
        }

        //Hvis det ikke ligger i inventory, så led i det nuværende rum
        if (foundItem == null) {
            foundItem = currentroom.findItems(itemName); //Bruger søgemetode fra Room klassen
        }


        //Udfald 1: Tingen slet ikke findes hverken som Food-objektet eller bare objekt
        if (foundItem == null) {
            return EatResult.NOT_FOUND;
        }
        //Udfald 2 og 3: Tingen findes! nu tjekker vi, om det food

        // Hvis foundItem er en food, så gem variablen 'foodToEat' med det samme i stedet for at bruge casting - Food foodToEat = (Food) foundItem;
        if (foundItem instanceof Food foodToEat) {

            //Spilleren spiser maden og får health/mister health
            //Udfald 3: Tingen findes og er mad

            //+= bruges til at lægge til, så f.eks. 100 + 10 = 110 - health stiger
            //110 + (-50) = 110-50 = 60 - health falder
            this.health += foodToEat.getHealthPoints();

            //Fjern maden fra inventory og currentroom
            if (inventory.contains(foodToEat)) {
                inventory.remove(foodToEat); //fjerner maden fra inventory
            } else {
                currentroom.removeItem(foodToEat); //fjerner fra Currentroom
            }
            return EatResult.EATEN;

        } else {
            //Udfald 2: Tingen findes, men er ikke et Food-objekt
            return EatResult.NOT_FOOD;
        }
    }







    //Item-metoder og inventory metoder

    //Søgemetode i spillerens inventory
    public Item findItemsInInventory(String itemName){
        for (Item item : inventory){
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null; //Itemet blev ikke fundet i inventory
    }


    //Denne søgemetode inkluderer currentRoom med itemsøgning
    public Item findItemsAnywhere(String itemName){
        for (Item item : inventory){
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return currentroom.findItems(itemName);
    }

    public Item takeItem(String itemName){
        Item item = currentroom.findItems(itemName);
        if (item != null){
            currentroom.removeItem(item); //fjernet fra rummet / currentroom
            inventory.add(item); //blev tilføjet til spillerens inventory
        }
        return item; //returnerer objektet eller null
    }


    public Item dropItem(String itemName){
        Item item = findItemsInInventory(itemName);
        if (item != null){
            inventory.remove(item); //Fjern fra spillerens inventory
            currentroom.addItem(item); //Tilføjet/droppet til rummet / currentroom
        }
        return item; //returnerer objektet / null
    }


    public ArrayList<Item> getInventory(){
        return inventory;
    }


    //Room og move
    public Room getCurrentroom(){
        return currentroom;
    }

    public String getCurrentRoomName(){
        return currentroom.getName();
    }

    public String getCurrentRoomDescription(){
        return currentroom.getDescription();
    }

    //Håndterer bevægelse/korsør. Returnerer true, hvis det lykkedes, og false hvis det er en mur (null)
    public boolean move(String direction){
        Room nextRoom = null;

        //Modtager kun de fulde retninger fra UI/Controller
        switch (direction){
            case "north", "n" -> nextRoom = currentroom.getNorth();
            case "south", "s" -> nextRoom = currentroom.getSouth();
            case "east", "e" -> nextRoom = currentroom.getEast();
            case "west", "w" -> nextRoom = currentroom.getWest();
        }

        if (nextRoom != null){
            currentroom = nextRoom; //Husk hvor vi står lige nu
            return true; //flytning lykkedes
        }
        return false; //Der er ikke noget at gå tilbage til endnu /blindgyde
    }

}
