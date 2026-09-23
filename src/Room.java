public class Room {
    private String name;
    private String description;
    private Room north;
    private Room east;
    private Room south;
    private Room west;

    public Room(String name, String description){
        this.name = name;
        this.description = description;
        //Javas standardværdi for objekter er automatisk 'null',
        //så alle fire retninger starter med at være tomme.
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    //North
    public void setNorth(Room room){
        this.north = room;
    }

    public Room getNorth(){
        return north;
    }

    //South
    public void setSouth(Room room){
        this.south = room;
    }

    public Room getSouth(){
        return south;
    }

    //East
    public void setEast(Room room){
        this.east = room;
    }

    public Room getEast(){
        return east;
    }

    //West
    public void setWest(Room room){
        this.west = room;
    }

    public Room getWest(){
        return west;
    }

}
