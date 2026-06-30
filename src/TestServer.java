import jakarta.xml.ws.Endpoint;

public class TestServer {
  public static void main (String args[]) {
    TestService1 server = new TestService1();
    Endpoint endpoint =
      Endpoint.publish("http://localhost:8765/DateReverse", server);
    System.out.println ("The Server is running");
  }
}