package praktikum.courier;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import java.util.Map;

public class CourierClient extends praktikum.Client {

    private static final String COURIER_CREATE_PATH = "courier";

    @Step("Создать курьера")
    public ValidatableResponse createCourier(Courier courier) {
        return spec()
                .body(courier)
                .when()
                .post(COURIER_CREATE_PATH)
                .then().log().all();
    }
    @Step("Залогиниться курьером")
    public ValidatableResponse loginCourier(CourierCredentionals creds) {
        return spec()
                .body(creds)
                .when()
                .post(COURIER_CREATE_PATH + "/login")
                .then().log().all();
    }
    @Step("Удалить курьера")
    public ValidatableResponse delete(int id){
        return spec()
                .body(Map.of("id",id))
                .when()
                .delete(COURIER_CREATE_PATH + "/" + id)
                .then().log().all();
    }

}
