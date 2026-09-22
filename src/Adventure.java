public class Adventure {

    private Room currentRoom;

    //opretter alle 9 rum:
    public Adventure() {
        Room room1 = new Room("Room 1", "A plain room with only two doors ");
        Room room2 = new Room("Room 2", "An ordinary room with two doors ");
        Room room3 = new Room("Room 3", "A quiet room in the corner");
        Room room4 = new Room("Room 4", "A small room with three doors");
        Room room5 = new Room("Room 5", "The middle room. It only has one door");
        Room room6 = new Room("Room 6", "A room with three doors");
        Room room7 = new Room("Room 7", "A room in the corner with two doors");
        Room room8 = new Room("Room 8", "A room with three doors");
        Room room9 = new Room("Room 9", "The last room, with two doors");
        currentRoom = room1;

        // East/West forbindelser
        room1.setEast(room2);
        room2.setWest(room1);

        room2.setEast(room3);
        room3.setWest(room2);

        room4.setEast(room5);
        room5.setWest(room4);

        room5.setEast(room6);
        room6.setWest(room5);

        room7.setEast(room8);
        room8.setWest(room7);

        room8.setEast(room9);
        room9.setWest(room8);

        // North/South forbindelser
        room1.setSouth(room4);
        room4.setNorth(room1);

        room2.setSouth(room5);
        room5.setNorth(room2);

        room3.setSouth(room6);
        room6.setNorth(room3);

        room4.setSouth(room7);
        room7.setNorth(room4);

        room5.setSouth(room8);
        room8.setNorth(room5);

        room6.setSouth(room9);
        room9.setNorth(room6);

    }


    public String look() {
        return currentRoom.getName() + "\n" + currentRoom.getDescription();
    }
}
