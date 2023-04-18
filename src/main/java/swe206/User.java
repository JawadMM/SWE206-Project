package swe206;

public abstract class User {
  private int id;
  private String username;
  private String password;
  private String userStatus;
  

  private static int counter;

  private final String[] status = {"Signed In", "Signed Out"};


  protected User(String username, String password) {

    counter += 1;
    this.userStatus = status[1];
    this.id = counter;
    this.username = username;
    this.password = password;
  }

  public String getName() {
    return username;
  }

  public String getpasswoed() {
    return password;
  }

  public String getstatus() {
    return userStatus;
  }

  public int getID() {
    return id;
  }

  public void logIn() {
    this.userStatus = status[0];
  }

  // public static void main(String[] args) {

  //   User user = new User("a", "b");
  //   User user1 = new User("a", "b");
  //   User user2 = new User("a", "b");
  //   User user3 = new User("a", "b");
  //   System.out.println(user3.id);
  // }
}
