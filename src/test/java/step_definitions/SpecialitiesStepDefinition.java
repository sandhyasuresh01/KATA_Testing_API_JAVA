package step_definitions;

import API.GetVetAPI;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.var;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.junit.Assert;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SpecialitiesStepDefinition {
    private static final Logger LOGGER = LogManager.getLogger(GetPetDetails.class);
    private static ObjectMapper mapper = new ObjectMapper();
    String specialitiesStore;
    JSONObject specialitiesData=new JSONObject();
    String jsonRequestBody;
    String jsonRequestBodyFinal;
    JSONObject ExpectedResult1;
    @Given("Valid specialities exists and Perform Vet request with all info")
    public void getspecialitiesDetails() throws IOException, JSONException, JAXBException {
        jsonRequestBody = templates.MergeFrom.template("templates/PetrequestPayload.json")
                .withDefaultValuesFrom(templates.FieldValues.in("templates/PetrequestPayload.properties"))
                .withFieldsFrom(templates.FieldValues.in("templates/PetrequestPayload.properties"));
        GetVetAPI.details();
        try{
            int Statuscode = GetVetAPI.statusCode;
            assertEquals(200, Statuscode);
            System.out.println("StatusCode from getPetDetails" + Statuscode);
            specialitiesStore = GetVetAPI.MessageResponse;
        }
        catch (Exception ex) {
            LOGGER.error("Execution of http method  returned HTTP status code: " + ex.getMessage());
        }

        JsonParser parserobj = new JsonParser();
        JsonElement jsonEleObject = parserobj.parse(specialitiesStore);
        for (int i = 0; i < jsonEleObject.getAsJsonArray().size(); i++) {
            var id_Key = jsonEleObject.getAsJsonArray().get(i).getAsJsonObject().get("id");
            var name_Key = jsonEleObject.getAsJsonArray().get(i).getAsJsonObject().get("name");
            specialitiesData.put("id", id_Key);
            specialitiesData.put("name", name_Key);
        }
        ExpectedResult1 = new Gson().fromJson(jsonRequestBody, JSONObject.class);
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(specialitiesData);
        Object[] array = jsonArray.toArray();
        for(int i = 0; i < jsonEleObject.getAsJsonArray().size(); i++){
            ExpectedResult1.remove("id");
            ExpectedResult1.put("id",i);
            ExpectedResult1.remove("firstName");
            ExpectedResult1.put("firstName","firstName"+i);
            ExpectedResult1.remove("lastName");
            ExpectedResult1.put("lastName","lastName"+i);
        }

        System.out.println("Array specialitiesData:\n" + Arrays.stream(array).toArray());
        ExpectedResult1.remove("specialties");
        ExpectedResult1.put("specialties", Arrays.stream(array).toArray());
        String ExpectedResponse = gson.toJson(ExpectedResult1);
        GetVetAPI.CreatevetDetails(ExpectedResponse);
    }

    @Then("Validate 201 OK in response")
    public void validateResponse() throws IOException, TransformerException, ParserConfigurationException, SAXException, JSONException {
        try{
            int Statuscode = GetVetAPI.statusCode;
            assertEquals(201, Statuscode);
            System.out.println("StatusCode from getPetDetails" + Statuscode);
            specialitiesStore = GetVetAPI.MessageResponse;
        }
        catch (Exception ex) {
            LOGGER.error("Execution of http method  returned HTTP status code: " + ex.getMessage());
        }

    }
    @Then("Validate Vet for each speciality")
    public void validateVetspecialityResponse() throws IOException, TransformerException, ParserConfigurationException, SAXException, JSONException, JAXBException {

        GetVetAPI.getVetDetailsCount();
        org.json.JSONArray jsonArray = new org.json.JSONArray(GetVetAPI.MessageResponse);
        System.out.println(jsonArray);
        int amountOfPets = jsonArray.length();
        Assert.assertNotEquals("the amount of Vets is amountOfPets  | ",11,amountOfPets);
    }
}
