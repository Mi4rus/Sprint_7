package praktikum.courier;

import java.time.LocalDateTime;

public class CourierCredentionals {
    private final String login;
    private final String password;

    public CourierCredentionals(String login, String password){

        this.login = login;
        this.password = password;

    }

     public static CourierCredentionals fromCourier(Courier courier) {
        var creds = new CourierCredentionals(courier.getLogin(), courier.getPassword());
        return creds;
     }

     public static CourierCredentionals fromNonExistentCourier(Courier courier) {
         var creds = new CourierCredentionals(courier.getLogin() + LocalDateTime.now(), courier.getPassword()+LocalDateTime.now());
         return creds;
     }

     public String getLogin() {
         return login;
     }

     public String getPassword() {
         return password;
     }


 }


