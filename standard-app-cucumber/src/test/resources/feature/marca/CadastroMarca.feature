Feature: Marca

  Scenario Outline: User insert a new Marca using correct values
    Given User navigates to standard website "<url>"
    And User enters a valid nome "<nome>"
    And User enters a valid descricao "<descricao>"
    When User clicks on button
    Then User should be taken to the list page with successful "<message>"
    Examples:
      | url                                   | nome      |  descricao      | message                 |
      | http://localhost:4200/marca/cadastrar |marcaName  |  marcaDescricao | Registrado com sucesso! |