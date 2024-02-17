package api;

import models.LoginRequestModel;
import models.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static specification.Specifications.*;

public class AuthorizationApi {
    public static LoginResponseModel authResponse () {
        LoginRequestModel userData = new LoginRequestModel();
        userData.setUserName("AeroRunner8");
        userData.setPassword("Rock2025lan!");

        return
                given(loginRequest)
                        .body(userData)
                        .when()
                        .post()
                        .then()
                        .log().all()
                        .spec(loginResponse)
                        .extract().as(LoginResponseModel.class);
    };
}
