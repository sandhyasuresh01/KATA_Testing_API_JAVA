package API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.json.JSONException;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class GetVetAPI {
    public static Response response;

    public static int statusCode;
    public static String MessageResponse;
    @Step("Send  Get specialties request")
    public static Response details() throws IOException, JSONException, JAXBException {
        response = RestAssured.given().relaxedHTTPSValidation()
                .when()
                .get("http://localhost:9966/petclinic/api/specialties")
                .then()
                .extract().response();
        System.out.println(response.statusCode());
        System.out.println("Response:  " + response.getBody().asString());
        statusCode = response.statusCode();
        MessageResponse = response.getBody().asString();
        return response;
    }
    @Step("Send  Get Vet request")
    public static Response vetDetails() throws IOException, JSONException, JAXBException {
        response = RestAssured.given().relaxedHTTPSValidation()
                .when()
                .get("http://localhost:9966/petclinic/api/vets")
                .then()
                .extract().response();
        System.out.println(response.statusCode());
        System.out.println("Response:  " + response.getBody().asString());
        statusCode = response.statusCode();
        MessageResponse = response.getBody().asString();
        return response;
    }
    @Step("Send  Post Vet request")
    public static Response CreatevetDetails(String json) throws IOException, JSONException, JAXBException {
        response = RestAssured.given().relaxedHTTPSValidation()
                .header("content-type", "accept: application/json")
                .body(json)
                .contentType(ContentType.JSON)
                .when()
                .post("http://localhost:9966/petclinic/api/vets");
        statusCode = response.statusCode();
        MessageResponse = response.getBody().asString();
        return response;
    }
    @Step("Send  get Vet request count details")
    public static Response getVetDetailsCount() throws IOException, JSONException, JAXBException {
        response = RestAssured.given().relaxedHTTPSValidation()
                .when()
                .get("http://localhost:9966/petclinic/api/vets")
                .then()
                .extract().response();
        System.out.println(response.statusCode());
        System.out.println("Response:  " + response.getBody().asString());
        statusCode = response.statusCode();
        MessageResponse = response.getBody().asString();
        return response;
    }
}
