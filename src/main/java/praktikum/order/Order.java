package praktikum.order;

public class Order {
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private String[] color;

    public Order(String firstName, String lastName, String address,
                 String metroStation, String phone, int rentTime,
                 String deliveryDate, String comment, String[] color){
        this.firstName = firstName;
        this.lastName = lastName;
        this. address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color=color;
    }

public static Order orderWithoutColor(){
    return new Order("Тест","Тестович", "Ленина, 55",
            "Фили", "+7(956)821-33-77", 20,
            "2024-09-10","Тестовый коммент", new String[]{});
}
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getMetroStation() {
        return metroStation;
    }

    public String getPhone() {
        return phone;
    }

    public int getRentTime() {
        return rentTime;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getComment() {
        return comment;
    }

    public String[] getColor() {
        return color;
    }
    public void setColor(String[] color) {
        this.color = color;
    }
}
