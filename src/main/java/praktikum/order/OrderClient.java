package praktikum.order;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import praktikum.Client;


public class OrderClient extends Client {
    private static final String ORDER_CREATE_PATH = "orders";

    @Step("Создать заказ")
    public ValidatableResponse createOrder(Order order){
        return spec()
                .body(order)
                .when()
                .post(ORDER_CREATE_PATH)
                .then().log().all();
    }

    @Step("Получить список заказов с ограничением в 2 заказа и для 1 станции")
    public ValidatableResponse getOrders(){
        return spec()
                .when()
                .queryParam("limit",2)
                .queryParam("nearestStation", 1)
                .get(ORDER_CREATE_PATH)
                .then().log().all();
    }

}
