import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Room {
    private String name;
    private String floor;
    private int size;

    public Room(String name, String floor, int size){
        super();
        this.name = name;
        this.floor = floor;
        this.size = size;
    }

    public String getName() {return name;}
    public String getFloor() {return floor;}
    public int getSize() {return size;}
    public void setSize(int s) {size=s;}
}