public class UserInterface { // Userinterface står for al kommunikation med brugeren.

    // Userinterface kender kun Adventure (controlleren) - ikke Player, Map eller Room (lav kobling)
    private Adventure adventure;

    // Konstruktør: opretter spillet.
    public UserInterface() {
        adventure = new Adventure();
    }


    // Starter spillet og kører, indtil brugeren skriver "exit".
    public void start() {

        boolean playing = true;

        // Velkomsttekst
        IO.println("Welcome to Adventure time");
        IO.println("Can you find your way around the caves of Ooo, maybe there is a hidden treasure?");
        IO.println("You can traverse around the cave and use different commands, for example 'help'");


        // Spil-løkken: læser en kommando, udfører den og starter forfra.
        while (playing) {
            String kommando = IO.readln("> ");

            switch (kommando) {
                case "exit" -> {
                    IO.println("Goodbye!");
                    playing = false;
                }
                case "look" -> {
                    IO.println(adventure.look());//kalder look metoden fra vores adventure klasse
                }

                case "help" -> {
                    IO.println("To move in a direction you have 4 options:");
                    IO.println("n or north" + ", e or east" + ", s or south" + ", w or west");
                    IO.println("look = information about your current whereabouts");
                    IO.println("exit = quit the game ");
                }

                // Her oversættes både "n" og "north" til goNorth()
                // Metoderne returnerer true, hvis spilleren flyttede sig, ellers false.
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

                case "s", "south" -> {
                    if (adventure.goSouth()) {
                        IO.println("You moved south");
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

            }
        }
    }
}


