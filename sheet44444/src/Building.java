import java.util.Objects;

public class Building{
    private String name;
    private int id;
    private Room[] rooms;

    public Building(String name){
        super();
        this.name = name;
        rooms = new Room[20];
    };

    public Room searchRoom(String roomName){

        boolean found = false;
        Room emptyRoom = new Room("-", "-", 0);
        for(Room r : rooms){
            if(r != null && roomName.equals(r.getName())){
                //System.out.println("Room " + roomName + " has been found");
                return r;
            }
        }
        //System.out.println("Room " + roomName + " could not be found");
        return emptyRoom;
    }

    public Boolean addRoom(Room r){
        boolean added = false;

        for(int i = 0; i < rooms.length; i++){
            if(rooms[i] == null){
                rooms[i] = r;
                //System.out.println("Room " + rooms[i].getName() + " added!");
                return true;
            }
        }

        return false;
    }

    public int size(){
        int i = 0;
        for(Room r : rooms){
            if(r != null){i += r.getSize();}
        }
        return i;
    }

    public String getName() {return name;}
    public void setName(String nameBuilding) {name = nameBuilding;}
    public Room[] getRooms() {return rooms;}
    public int getId() {return id;}
}

