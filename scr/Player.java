import java.util.ArrayList;

public class Player {
    private Room currentroom;
    private ArrayList<Item> inventory = new ArrayList<>();


    public Player(Room startRoom){
        this.currentroom = startRoom;
    }


    //Item-metoder

    //Søgemetode i spillerens inventory
    public Item findItemsInInventory(String itemName){
        for (Item item : inventory){
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null; //Itemet blev ikke fundet i inventory
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
