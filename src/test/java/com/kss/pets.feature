Feature: Pets APIs

  Scenario: Add new Pets with owner details and pet's category
    Given Send GetOwner and request with valid endpoint
    Then Create pet details with owner details
    Then validate 201 response