void main() {
    Adventure adventure = new Adventure(); //kalder konstruktøren i vores Adventure-klasse.
    boolean playing = true;

    while (playing) {
        String kommando = IO.readln("> ");

        switch (kommando) {
            case "exit" -> {
                IO.println("Goodbye!");
                playing = false;
            }
            case "look" -> {
                IO.println(adventure.look()); //kalder look metoden fra vores adventure klasse
            }
            case "help" -> {
                // TODO: skal senere vise en liste over kommandoer
                IO.println("her er en liste over kommandoer...");
            }
            case "go north" -> {
                // TODO: skal senere flytte spilleren
                IO.println("going north");
            }
            case "go east" -> {
                IO.println("going east");
            }
            case "go south" -> {
                IO.println("going south");
            }
            case "go west" -> {
                IO.println("going west");
            }
            default -> IO.println("You cannot go that way");
        }
    }
}