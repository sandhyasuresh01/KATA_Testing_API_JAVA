Feature: Create VetDetails for each specialities details
        Scenario: TC01_ Create VetDetails
        Given Valid specialities exists and Perform Vet request with all info
        Then Validate 201 OK in response
        Then Validate Vet for each speciality
