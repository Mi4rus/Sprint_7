package praktikum.courier;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

public class CourierLoginTest  {
    private CourierClient client = new CourierClient();
    private CourierChecks check = new CourierChecks();
    int courierId;

    @After
    public void deleteCourier(){
        if (courierId != 0) {
            ValidatableResponse response = client.delete(courierId);
            check.deleted(response);
        }
    }

    @Test
    @DisplayName("Авторизация курьера")
    public void successLoginCourierTest(){
        var courier = Courier.randomCourier();
        ValidatableResponse createResponse = client.createCourier(courier);
        check.checkCreated(createResponse);

        var creds = CourierCredentionals.fromCourier(courier);
        ValidatableResponse loginResponse = client.loginCourier(creds);
        courierId = check.checkLoggedIn(loginResponse);
    }
    @Test
    @DisplayName("Нельзя авторизоваться без логина")
    public void failedBadRequestWithoutLoginLoginTest(){
        var courier = Courier.courierWithoutLogin();

        var creds = CourierCredentionals.fromCourier(courier);
        ValidatableResponse loginResponse = client.loginCourier(creds);
        check.checkBadRequestLogin(loginResponse);
    }

    @Test
    @DisplayName("Нельзя авторизоваться без пароля")
    public void failedBadRequestWithoutPasswordLoginTest(){
        var courier = Courier.courierWithoutPassword();

        var creds = CourierCredentionals.fromCourier(courier);
        ValidatableResponse loginResponse = client.loginCourier(creds);
        check.checkBadRequestLogin(loginResponse);
    }

    @Test
    @DisplayName("Нельзя авторизоваться с пустым логином")
    public void failedBadRequestWithEmptyLoginLoginTest(){
        var courier = Courier.courierWithEmptyLogin();

        var creds = CourierCredentionals.fromCourier(courier);
        ValidatableResponse loginResponse = client.loginCourier(creds);
        check.checkBadRequestLogin(loginResponse);
    }

    @Test
    @DisplayName("Нельзя авторизоваться с пустым паролем")
    public void failedBadRequestWithEmptyPasswordLoginTest(){
        var courier = Courier.courierWithEmptyPassword();

        var creds = CourierCredentionals.fromCourier(courier);
        ValidatableResponse loginResponse = client.loginCourier(creds);
        check.checkBadRequestLogin(loginResponse);
    }

    @Test
    @DisplayName("Нельзя авторизоваться с несуществующей парой логин-пароль")
    public void failedNotFoundWithNonExistentData(){
        var courier = Courier.randomCourier();

        ValidatableResponse createResponse = client.createCourier(courier);
        check.checkCreated(createResponse);

        var creds = CourierCredentionals.fromNonExistentCourier(courier);
        ValidatableResponse loginResponse = client.loginCourier(creds);
        check.checkNotFoundLogin(loginResponse);

    }
}
