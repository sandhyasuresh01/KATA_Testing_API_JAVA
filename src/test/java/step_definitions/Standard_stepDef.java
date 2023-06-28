package step_definitions;

import io.cucumber.java.en.Given;

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
}
