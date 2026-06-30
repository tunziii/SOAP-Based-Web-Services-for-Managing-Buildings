import testws1.*;
import testws1.Room;

//Building Client
public class TestService1Client {
    public static void main(String args[]) {
        TestService1Service service = new TestService1Service();
        testws1.TestService1 stub = service.getTestService1Port();
        //Main Building id = 0, Not Main Building id = 1

        stub.addRoom(0, "a100", "OG", 10);
        stub.addRoom(0, "a101", "OG", 15);

        stub.addRoom(1, "b100", "OG", 10);
        stub.addRoom(1, "b101", "OG", 15);


        Room a100 = stub.searchRoom(0, "a100");
        Room a101 = stub.searchRoom(0, "a103"); //not found

        Room b101 = stub.searchRoom(1, "b101");
        Room b103 = stub.searchRoom(1, "b103"); //not found


        stub.changeSize(0, "a100", 15);
        stub.changeSize(0, "a101", 20);

        stub.changeSize(1, "b100", 30);
        stub.changeSize(1, "b101", 35);


        RoomArray rooms0 = stub.getRooms(0);
        RoomArray rooms1 = stub.getRooms(1);

        System.out.println("Total size \n");
        //calculate room size
        int totalSize0 = 0;
        int totalSize1 = 0;

        for(Room room : rooms0.getItem()){
            if(room != null){totalSize0 += room.getSize();}
        }
        System.out.println("Total Size of Rooms in Main Building: " + totalSize0);

        for(Room room : rooms1.getItem()){
            if(room != null){totalSize1 += room.getSize();}
        }
        System.out.println("Total Size of Rooms in Main Building: " + totalSize1);
    }
}

