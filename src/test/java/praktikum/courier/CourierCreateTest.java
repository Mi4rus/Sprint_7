package praktikum.courier;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

public class CourierCreateTest {
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
    @DisplayName("Создание курьера")
    public void successCreateCourierTest(){
    var courier = Courier.randomCourier();
        ValidatableResponse createResponse = client.createCourier(courier);
        check.checkCreated(createResponse);

        //Авторизация с созданным курьером
        var creds = CourierCredentionals.fromCourier(courier);
        ValidatableResponse loginResponse = client.loginCourier(creds);
        courierId = check.checkLoggedIn(loginResponse);
    }

    @Test
    @DisplayName("Нельзя создать двух одинаковых курьеров")
    public void failedDuplicateCreateCourierTest(){
        var courier1 = Courier.randomCourier();
        var courier2 = courier1;
        ValidatableResponse createResponse1 = client.createCourier(courier1);
        check.checkCreated(createResponse1);

        var creds = CourierCredentionals.fromCourier(courier1);
        ValidatableResponse createResponse2 = client.createCourier(courier2);
        check.checkDuplicateError(createResponse2);
    }

    @Test
    @DisplayName("Нельзя создать курьера с пустым логином")
    public void failedBadRequestWithEmptyLoginCreateCourierTest(){
        var courier = Courier.courierWithEmptyLogin();
        ValidatableResponse createResponse = client.createCourier(courier);
        check.checkBadRequestCreate(createResponse);
    }

    @Test
    @DisplayName("Нельзя создать курьера без логина")
    public void failedBadRequestWithoutLoginCreateCourierTest(){
    var courier = Courier.courierWithoutLogin();
        ValidatableResponse createResponse = client.createCourier(courier);
        check.checkBadRequestCreate(createResponse);
    }

    @Test
    @DisplayName("Нельзя создать курьера с пустым паролем")
    public void failedBadRequestWithEmptyPasswordCreateCourierTest(){
        var courier = Courier.courierWithEmptyPassword();
        ValidatableResponse createResponse = client.createCourier(courier);
        check.checkBadRequestCreate(createResponse);
    }

    @Test
    @DisplayName("Нельзя создать курьера без пароля")
    public void failedBadRequestWithoutPasswordCreateCourierTest(){
        var courier = Courier.courierWithoutPassword();
        ValidatableResponse createResponse = client.createCourier(courier);
        check.checkBadRequestCreate(createResponse);
    }

    @Test
    @DisplayName("Нельзя создать курьера с пустым именем")
    public void failedBadRequestWithEmptyFirstNameCreateCourierTest(){
        var courier = Courier.courierWithEmptyFirstName();
        ValidatableResponse createResponse = client.createCourier(courier);
        check.checkBadRequestCreate(createResponse);
    }

    @Test
    @DisplayName("Нельзя создать курьера без имени")
    public void failedBadRequestWithoutFirstNameCreateCourierTest(){
        var courier = Courier.courierWithoutFirstName();
        ValidatableResponse createResponse = client.createCourier(courier);
        check.checkBadRequestCreate(createResponse);
    }
}
