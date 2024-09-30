package praktikum.courier;

import java.time.LocalDateTime;

public class Courier {
    private String login;
    private String password;
    private String firstName;

    public Courier(String password, String firstName){
        this.password = password;
        this.firstName = firstName;
    }

    public Courier(String login, String password, String firstName){

        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

     public static Courier randomCourier() {
        return new Courier("login" + LocalDateTime.now(), "password123221", "Arutio");
    }

    public static Courier courierWithEmptyLogin(){
        return new Courier("","password123221", "Arutio");
    }
    public static Courier courierWithoutLogin(){
        return new Courier("password123221", "Arutio");
    }
    public static Courier courierWithEmptyPassword(){
        return new Courier("login" + LocalDateTime.now(), "", "Arutio");

    }
    public static Courier courierWithoutPassword(){
        return new Courier("login" + LocalDateTime.now(),  null,"Arutio");

    }
    public static Courier courierWithEmptyFirstName() {
        return new Courier("login" + LocalDateTime.now(), "password123221", "");
    }
    public static Courier courierWithoutFirstName() {
        return new Courier("login" + LocalDateTime.now(), "password123221", null);
    }

     public String getLogin() {
         return login;
     }

     public String getPassword() {
         return password;
     }

     public String getFirstName() {
         return firstName;
     }
 }


