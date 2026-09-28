import java.util.ArrayList;

public class UI {
    Adventure game = new Adventure();
    boolean running = true;

    public void startGame() {
        //Velkomstbesked og beskrivelse af start-rummet
        IO.println("Welcome to the Adventure Game!");
        IO.println("Commands: go north/south/east/west (or just n/s/e/w), look, help, inventory, take <item>, drop <item>, exit.");
        IO.println("----------------------------------------------------------------------------");
        printRoomInfo();

        while (running) {
            //Vis et simpelt prompt-tegn og læs input fra brugeren i små bogstaver.
            String input = IO.readln("> ").toLowerCase().trim();


            //Tjek for intenting. Hvis bruger bare trykker Enter
            if (input.isEmpty()) {
                IO.println("You must type a command! Type 'help' for list of commands.");
                continue; //Springer resten af koden over og starter forfra i løkken
            }

            //Hvis spilleren skriver f.eks. 'go east', fjerner vi 'go ' så der står 'east'
            if (input.startsWith("go ")) {
                input = input.substring(3).trim();
            }
            //Håndtering af kommandoer
            switch (input) {
                case "take", "t" -> IO.println("What do you want to take? (e.g., 'take lamp')");
                case "drop", "d" -> IO.println("What do you want to drop? (e.g., 'drop lamp')");
                case "look" -> printRoomInfo();
                case "inventory", "inv" -> printInventory();
                case "help" -> printHelp();
                case "exit" -> {
                    IO.println("Game Over.");
                    running = false;
                }

                //Retninger
                case "north", "n" -> handleMove("north");
                case "south", "s" -> handleMove("south");
                case "east", "e" -> handleMove("east");
                case "west", "w" -> handleMove("west");

                //Skraldspand: Alt andet sendes herned til tjek
                default -> handleComplexCommands(input);
            }
        }
    }


    private void handleMove(String direction){
        boolean success = game.movePlayer(direction);
        if (success) {
            printRoomInfo();
        } else {
            IO.println("Ouch! You hit a wall. You cannot go that way");
        }
    }
    private void handleTake(String itemName){
        Item takenItem = game.takeItem(itemName);
        if (takenItem != null){
            IO.println("You have taken the " + takenItem.getDescription());
        } else {
            IO.println("There is nothing like " + itemName + " to take around here.");
        }
    }


    private void handleDrop(String itemName){
        Item droppedItem = game.dropItem(itemName);
        if (droppedItem != null){
            IO.println("You have dropped the " + droppedItem.getDescription());
        } else {
            IO.println("You don't have anything like " + itemName + " in your inventory.");
        }
    }

    private void printInventory(){
        ArrayList<Item> inventory = game.getPlayerInventory();
        if (inventory.isEmpty()){
            IO.println("You are not carrying anything right now.");
        } else {
            IO.println("You are carrying: ");
            for (Item item : inventory){
                IO.println("- " + item.getDescription());
            }
        }
        IO.println(" ");
    }

    private void printHelp(){
        IO.println("\n--- (Help Menu) ---");
        IO.println("Move: 'south', 'north', 'west', 'east'");
        IO.println("Look: See the room description and items again");
        IO.println("Take/Drop: 'take lamp, 'drop book'");
        IO.println("Inventory: Type 'inventory' or 'inv' to see your items.");
        IO.println("Exit: Quit the game.");
    }

    private void printRoomInfo() {
        IO.println("You are in " + game.getCurrentRoomName());
        IO.println(game.getCurrentRoomDescription());

        //Vis item i rummet
        ArrayList<Item> roomItems = game.getCurrentRoomItems();
        if (!roomItems.isEmpty()){
            IO.print("Here you see: ");
            for (int i = 0; i < roomItems.size(); i++){
                IO.print(roomItems.get(i).getDescription());

                //hvis der er mere end et item i rummet
                if (i < roomItems.size() -1){
                    //Hvis vi står ved det næstsidste item, sætter vi ", and" inden det sidste
                    if (i == roomItems.size() - 2) {
                        IO.print(", and ");
                    } else {
                        IO.println(", "); //Ellers sætter vi bare almindelig komma
                    }
                }
            }
            IO.println("");
        }
    }

    private void handleComplexCommands(String input) {
        //Håndtering af input som "take lamp" eller "drop <item>"
        if (input.startsWith("take ") || input.startsWith("t ")) {
            String itemName = parseItemName(input);
            handleTake(itemName);
        } else if (input.startsWith("drop ") || input.startsWith("d ")) {
            String itemName = parseItemName(input);
            handleDrop(itemName);
        } else {
            IO.println("Unknown command. Type 'help' for a lists of commands.");
        }
    }


    //Klipper bare alt efter det første mellemrum af
private String parseItemName(String input) {
    return input.substring(input.indexOf(" ")).trim();
    }
}


