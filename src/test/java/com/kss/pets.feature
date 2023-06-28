Feature: Pets APIs

  @get_pets
  Scenario: Get all the PETS
    When I want to know all the pets in the clinic
    Then I should receive 13 pets

  Scenario: Add new Pets with owner details and pet's category
    Given Send GetOwner and request with valid endpoint
    Then Create pet details with owner details
    Then validate 201 response