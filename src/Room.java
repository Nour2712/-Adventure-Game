public class Room {

    //opretter felter:
    private String name;
    private String description;
    private Room north;
    private Room east;
    private Room south;
    private Room west;

    // Konstruktør: opretter et rum med navn og beskrivelse: (naboerne er ikke med her, ved jeg ikke hvorfor faktsik? )
    public Room (String name, String description){
    this.name = name;
    this.description = description;
    }

    // Getters:
    public String getName() {
        return name;
    }

    public String getDescription(){
        return description;
    }

    public Room getNorth() {
        return north;
    }

    public Room getEast() {
        return east;
    }

    public Room getSouth() {
        return south;
    }

    public Room getWest() {
        return west;
    }


    // Setters: bruges til at SÆTTE/ændre værdier (i det her tilfælde bruger vi det til at forbinde rum til hina

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setWest(Room west) {
        this.west = west;
    }
}
