void main() {
    Adventure game = new Adventure();
    boolean running = true;

    //Velkomstbesked og beskrivelse af start-rummet
    IO.println("Welcome to the Adventure Game!");
    IO.println("Commands: go north/south/east/west (or just n/s/e/w), look, help, back, exit.");
    IO.println("----------------------------------------------------------------------------");
    IO.println("You are in " + game.getCurrentroom().getName());
    IO.println(game.getCurrentroom().getDescription());

    while (running){
        //Vis et simpelt prompt-tegn og læs input fra brugeren i små bogstaver.
        String input = IO.readln("> ").toLowerCase().trim();

        //Hvis spilleren skriver f.eks. 'go east', fjerner vi 'go ' så der står 'east'
        if (input.startsWith("go  ")){
            input = input.substring(3).trim();
        }

        //Håndtering af kommandoer
        switch (input){
            case "exit" -> {
                IO.println("The game has been stopped.");
                running = false;
            }
            case "help" -> IO.println("Commands: go north/south/east/west (or just n/s/e/w), look, help, back, exit.");

            case "look" -> {
                IO.println("You are in " + game.getCurrentroom().getName());
                IO.println(game.getCurrentroom().getDescription());
            }
            case "north", "n", "south", "s", "east", "e", "west", "w", "back" -> {
                //Forsøg at flytte spilleren ved at kalde vores move metode i Adventure klassen
                boolean success = game.move(input);
                if (success){
                    //Hvis spilleren brugte back-funktionen, giv en særlig besked
                    if (input.equals("back")) {
                        IO.println("You moved back to " + game.getCurrentroom().getName());
                    } else {
                        IO.println("You are in " + game.getCurrentroom().getName());
                    }
                    IO.println(game.getCurrentroom().getDescription());
                } else {
                    // Hvis man trykker back som det allerførste i spillet i room 1, har man ikke et forrige rum
                    if (input.equals("back")){
                        IO.println("You haven't moved anywhere yet, so you cannot go back!");
                    } else {
                        IO.println("You cannot go that way");
                    }
                }
            }
            default -> IO.println("Unknown command. Type 'help' for at list of commands.");
        }
    }
}