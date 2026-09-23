public class Userinterface {

    private Adventure adventure; //kalder konstruktøren i vores Adventure-klasse.

    public Userinterface() {
        adventure = new Adventure();
    }

    public void start() {

        boolean playing = true;

        IO.println("Welcome to Adventure time");
        IO.println("Can you find your way around the caves of Ooo, maybe there is a hidden treasure?");
        IO.println("You can traverse around the cave and use different commands, for example 'help'");

        while (playing) {
            String kommando = IO.readln("> ");

            switch (kommando) {
                case "exit" -> {
                    IO.println("Goodbye!");
                    playing = false;
                }
                case "look" -> {
                    Room currentRoom = adventure.getCurrentRoom();//kalder look metoden fra vores adventure klasse

                IO.print(currentRoom.getName());
                IO.print(currentRoom.getDescription());
                }

                case "help" -> {
                    IO.println("To move in a direction you have 4 options:");
                    IO.println("n or north" + ", e or east" + ", s or south" + ", w or west");
                    IO.println("look = information about your current whereabouts");
                    IO.println("exit = quit the game ");
                }

                case "n", "north" -> {
                    if (adventure.goNorth()) {
                        IO.println("You moved north");
                    } else {
                        IO.println("You cannot go that way");
                    }
                }
                case "e", "east" -> {
                    if (adventure.goEast()) {
                        IO.println("You moved east");
                    } else {
                        IO.println("You cannot go that way");
                    }
                }
                case "w", "west" -> {
                    if (adventure.goWest()) {
                        IO.println("You moved west");
                    } else {
                        IO.println("You cannot go that way");
                    }
                }
                case "s", "south" -> {
                    if (adventure.goSouth()) {
                        IO.println("You moved south");
                    } else {
                        IO.println("You cannot go that way");
                    }
                }
            }
        }
    }
}
