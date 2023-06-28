package step_definitions;

import API.GetPetAPI;
import dto.Owners;
import dto.PetType;
import dto.Pets;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.minidev.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetPetDetails {
    private static final Logger LOGGER = LogManager.getLogger(GetPetDetails.class);
    final ObjectMapper objectMapper = new ObjectMapper();
    String jsonCreateRequestBody;

    JSONObject ExpectedFinaladdpet;
    //imp
    PetType petTypeobj = null;
    PetType[] petTypeResponseArray;
    Owners[] ownerResponseArray;
    Pets[] petsResponseArray;
    //imp
    @Given("Send GetOwner and request with valid endpoint")
    public void getownerPetDetails() throws IOException, ParserConfigurationException, SAXException, JSONException, JAXBException {

        getOwnerDetails();
        getPetsTypeDetails();
        getPetsDetails();
        //createPetDetails();



    }

    @Then("Create pet details with owner details")
    public void postCreatePetDetails() throws IOException, TransformerException, ParserConfigurationException, SAXException, JSONException {
        try {
            createPetDetails();

        } catch (Exception ex) {
            LOGGER.error("Execution of http method  returned HTTP status code: " + ex.getMessage());
        }
    }

    public void getPetsTypeDetails() throws JAXBException, JSONException, IOException {

        GetPetAPI.getPetsTypedetails();
        petTypeResponseArray = objectMapper.readValue(GetPetAPI.MessageResponse, PetType[].class);
        if (petTypeResponseArray != null && petTypeResponseArray.length > 1) {
            // PetType petTypeobj = null;
            for (int i = 0; i < petTypeResponseArray.length; i++) {
                petTypeobj = petTypeResponseArray[i];
                LOGGER.info("owner object value at [" + i + "] is : " + petTypeobj.toString());
            }
        }
    }

    public void getOwnerDetails() throws JAXBException, JSONException, IOException {

        GetPetAPI.getOwnerdetails();
        ownerResponseArray = objectMapper.readValue(GetPetAPI.MessageResponse, Owners[].class);
        if (ownerResponseArray != null && ownerResponseArray.length > 1) {
            Owners ownerObj;
            for (int i = 0; i < ownerResponseArray.length; i++) {
                ownerObj = ownerResponseArray[i];
                LOGGER.info("owner object value at [" + i + "] is : " + ownerObj.toString());
            }


        }
    }
    public void getPetsDetails() throws JAXBException, JSONException, IOException {
        GetPetAPI.getPets();
        petsResponseArray = objectMapper.readValue(GetPetAPI.MessageResponse, Pets[].class);
        if(petsResponseArray != null && petsResponseArray.length>1) {
            Pets petsObj;
            for (int i = 0; i < petsResponseArray.length; i++) {
                petsObj = petsResponseArray[i];
                LOGGER.info("Pets object value at ["+i+"] is : " + petsObj.toString());
            }
        }
    }
    public void createPetDetails() throws JAXBException, JSONException, IOException {

        petTypeobj.getName();
        System.out.println(petTypeobj.getName());
        jsonCreateRequestBody = templates.MergeFrom.template("templates/CreaterequestPayload.json")
                .withDefaultValuesFrom(templates.FieldValues.in("templates/CreaterequestPayload.properties"))
                .withFieldsFrom(templates.FieldValues.in("templates/CreaterequestPayload.properties"));

        ExpectedFinaladdpet = new Gson().fromJson(jsonCreateRequestBody, JSONObject.class);
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        ExpectedFinaladdpet.remove("type");
        if (petTypeResponseArray != null && petTypeResponseArray.length > 1) {
            // PetType petTypeobj = null;
            for (int i = 0; i < petTypeResponseArray.length; i++) {
                petTypeobj = petTypeResponseArray[i];
                LOGGER.info("owner object value at [" + i + "] is : " + petTypeobj.toString());

                if(petTypeobj.getId()==3){
                    ExpectedFinaladdpet.put("type", petTypeResponseArray[i]);
                    break;
                }
            }

        }
        String finalpayload = gson.toJson(ExpectedFinaladdpet);
        GetPetAPI.createPet(finalpayload);
    }

    @Then("validate 201 response")
    public void validateResponse() throws IOException, TransformerException, ParserConfigurationException, SAXException, JSONException {
        try{
            int Statuscode = GetPetAPI.statusCode;
            assertEquals(201, Statuscode);
            System.out.println("StatusCode from getPetDetails" + Statuscode);
        }
        catch (Exception ex) {
            LOGGER.error("Execution of http method  returned HTTP status code: " + ex.getMessage());
        }

    }
}
