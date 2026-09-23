public class Adventure {
    private Room currentroom; //gemmer det nuværende rum
    private Room previousRoom; //gemmer det forrige rum

    public Adventure(){
        //1. Opret rummene
        Room room1 = new Room("Room 1", "A room with no distinct features, except two doors.");
        Room room2 = new Room("Room 2", "Water drips from the ceilling somewhere in the dark.");
        Room room3 = new Room("Room 3", "A dusty library filled with ancient, forgotten books.");
        Room room4 = new Room("Room 4", "A long, narrow corridor with torches on the walls.");
        Room room5 = new Room("Room 5", "The hidden chamber. Something valuable might be here!");
        Room room6 = new Room("Room 6", "An overgrown greenhouse where strange plants thrive.");
        Room room7 = new Room("Room 7", "A cold cellar smelling of damp earth.");
        Room room8 = new Room("Room 8", "An armory with rusted swords and shields.");
        Room room9 = new Room("Room 9", "A grand balcony overlooking a dark forest.");

        //2. Forbind den øverste række (1, 2, 3)
        room1.setEast(room2);
        room2.setWest(room1);
        room2.setEast(room3);
        room3.setWest(room2);

        //3. Forbind lodret ned til midterste række (1->4, 3->6)
        room1.setSouth(room4);
        room4.setNorth(room1);
        room3.setSouth(room6);
        room6.setNorth(room3);

        //4. Forbind den midtereste række (Room 5 har kun en indgang)

        //Man går East fra Room 4 for at komme ind i Room 5
        room4.setEast(room5);

        //Man går West fra room 5 for at komme tilbage til Room 4
        room5.setWest(room4);

        //5. Forbinder resten af rækkerne (4->7, 6->9 osv. Indtil alle hænger sammen som kortet viser)
        room4.setSouth(room7);
        room7.setNorth(room4);

        room6.setSouth(room9);
        room9.setNorth(room6);

        room7.setEast(room8);
        room8.setWest(room7);
        room8.setEast(room9);
        room9.setWest(room8);


        //Spilleren starter alid i room 1
        currentroom = room1;
    }

    //Giver adgang til at se det rum, spilleren står i
    public Room getCurrentroom() {
        return currentroom;
    }

    //Håndterer bevægelse/korsør. Returnerer true, hvis det lykkedes, og false hvis det er en mur (null)
    public boolean move(String direction){
        Room nextRoom = null;

        //Hvis spilleren vil gå tilbage
        if (direction.equals("back")){
            if (previousRoom != null){
                Room temp = currentroom; //Husk hvor vi står lige nu
                currentroom = previousRoom; //Gå tilbage
                previousRoom = temp; //Nu er det gamle rum det 'forrige'
                return true;
            }
            return false; //Der er ikke noget at gå tilbage til endnu
        }

        //UI med switch i stedet for if-else
        switch (direction){
            case "north", "n" -> nextRoom = currentroom.getNorth();
            case "south", "s" -> nextRoom = currentroom.getSouth();
            case "east", "e" -> nextRoom = currentroom.getEast();
            case "west", "w" -> nextRoom = currentroom.getWest();
            default -> IO.println("Fejlindtastning. Prøv igen!");
        }
        if (nextRoom != null){
            previousRoom = currentroom; //Gem det nuværende rum, før vi flytter os
            currentroom = nextRoom;
            return true; //Spilleren flyttede sig
        } else {
            return false; //Der var en mur (null) - spilleren flytter sig ikke
        }
    }
}
