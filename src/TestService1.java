import java.util.Date;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;

@WebService(targetNamespace = "http://testws1/")
@SOAPBinding(style=Style.RPC)

//Building Service
//Server has to be running for stubs: & "C:\Program Files\Java\jdk1.8.0_202\bin\wsimport.exe" -keep -p testws1 "http://localhost:8765/DateReverse?wsdl"


public class TestService1 {

  private Building[] buildings = {
          new Building("Main Building"),
          new Building("Not Main Building")
  };

  private Building getBuilding(int id) {
    if(id >= 0 && id <= buildings.length) {
      return buildings[id];
    }
    return null;
  }

  //addRoom
  @WebMethod
  public void addRoom(@WebParam(name = "buildingId") int buildingId, @WebParam(name = "name") String name, @WebParam(name = "floor") String floor, @WebParam(name = "size") int size){
    //add room to building and return true or false if added or not
    boolean added = getBuilding(buildingId).addRoom(new Room(name, floor, size));

    if(added){System.out.println("Room " + name + " has been added");}
    else if(!added){System.out.println("Room " + name + " has not been added");}
  }

  //searchRoom
  @WebMethod
  public Room searchRoom(@WebParam(name = "buildingId") int buildingId, @WebParam(name = "roomName") String roomName) {
    Room r = getBuilding(buildingId).searchRoom(roomName);

    //check if room has been found. If the room has not been found it will be empty and have the attributes "-", "-", 0 for Name, Floor and Size
    if(!(r.getName().equals("-"))){
      System.out.println("Room " + r.getName() + " has been found");
      return r;
    }

    System.out.println("Room " + roomName + " has not been found");
    return new Room("-", "-", 0);
  }

  //returnRooms
  @WebMethod
  public Room[] getRooms(@WebParam(name = "buildingId") int buildingId){
    System.out.println("Rooms requested");
    Room[] rooms = getBuilding(buildingId).getRooms();

    return rooms;
  }

  //changeSize
  @WebMethod
  public void changeSize(@WebParam(name = "buildingId") int buildingId, @WebParam(name = "roomName") String  roomName, @WebParam(name = "size") int size){
    Room r = getBuilding(buildingId).searchRoom(roomName);
    int oldSize = r.getSize();

    //check if the room has been found/existing and then change size
    //if a room has not been found the return object of searchRoom() is a Room object with the attributes "-", "-", 0 for Name, Floor and Size
    if(!(r.getName().equals("-"))){
      getBuilding(buildingId).searchRoom(roomName).setSize(size);
      System.out.println("Room " + roomName + " has been changed from " + oldSize + " to " + getBuilding(buildingId).searchRoom(roomName).getSize());
    }

    else if((r.getName().equals("-"))){System.out.println("Room does not exist or could not be found");}
  }

}
