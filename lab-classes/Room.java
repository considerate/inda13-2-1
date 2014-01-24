public class Room {
  private String name;
  private String location;

  public Room(String name, String location) {
    this.name = name;
    this.location = location;
  }

  public String getInfo() {
    return this.name + ", in " + this.location;
  }
}