package API;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.json.JSONException;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class GetPetAPI {
    static Response response;
    private static ObjectMapper mapper = new ObjectMapper();

    public static int statusCode;
    public static String MessageResponse;

    @Step("Send  Get request")
    public static Response getPetsTypedetails() throws IOException, JSONException, JAXBException {
        response = RestAssured.given().relaxedHTTPSValidation()
                .when()
                .get("http://localhost:9966/petclinic/api/pets/pettypes")
                .then()
                .extract().response();
        System.out.println(response.statusCode());
        System.out.println("Response:  " + response.getBody().asString());
        statusCode = response.statusCode();
        MessageResponse = response.getBody().asString();
        return response;
    }

    public static Response getOwnerdetails() throws IOException, JSONException, JAXBException {
        response = RestAssured.given().relaxedHTTPSValidation()
                .when()
                .get("http://localhost:9966/petclinic/api/owners")
                .then()
                .extract().response();
        System.out.println(response.statusCode());
        System.out.println("Response:  " + response.getBody().asString());
        statusCode=response.statusCode();
        MessageResponse = response.getBody().asString();
        return response;
    }

    public static Response getPets() throws IOException, JSONException, JAXBException {
        response = RestAssured.given().relaxedHTTPSValidation()
                .when()
                .get("http://localhost:9966/petclinic/api/pets")
                .then()
                .extract().response();
        System.out.println(response.statusCode());
        System.out.println("Response:  " + response.getBody().asString());
        statusCode=response.statusCode();
        MessageResponse = response.getBody().asString();
        return response;
    }

    public static Response createPet(String json) throws IOException, JSONException, JAXBException {
        response = RestAssured.given().relaxedHTTPSValidation()
                .header("content-type", "accept: application/json")
                .body(json)
                .contentType(ContentType.JSON)
                .when()
                .post("http://localhost:9966/petclinic/api/pets");
        statusCode = response.statusCode();
        MessageResponse = response.getBody().asString();
        return response;
    }
}