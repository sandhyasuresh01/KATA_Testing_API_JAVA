package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Standard_stepDef {

    private static String resource;

    @Given("^the resource of the API is \"([^\"]*)\"$")
    public void theResourceOfTheGetOneEmployeeAPIIs(String resource)  {
        Standard_stepDef.resource = resource;
        System.out.printf("Resource : %s%n", Standard_stepDef.resource);
    }

    public static String getResource() {
        return resource;
    }

    public static void setResource(String resource) {
        Standard_stepDef.resource = resource;
    }

//    @Then("^the response code should be \"([^\"]*)\"$")
//    public void theResponseCodeShouldBe(String responseCode)  {
//        System.out.println("Returned response code : " + SupportFunctions.getResponseCode());
//        Assert.assertEquals("Response code not as expected | ",
//                responseCode,
//                SupportFunctions.getResponseCode()
//        );
//    }
}
