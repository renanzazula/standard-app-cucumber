package com.standard.steps.marca;


import com.standard.factory.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CadastrarMarcaSteps extends DriverFactory {

    @Given("User navigates to standard website {string}")
    public void user_navigates_to_standard_website(String url) {
        marca.getMarcaPage(url);
    }

    @And("User enters a valid nome {string}")
    public void userEntersAValidNome(String nome) {
        marca.setNome(nome);
    }

    @And("User enters a valid descricao {string}")
    public void user_enters_a_valid_descricao(String descricao) {
        marca.setDescricao(descricao);
    }

    @When("User clicks on button")
    public void userClicksOnButton() {
        marca.clickOnCadastrarButton();
    }

    @Then("User should be taken to the list page with successful {string}")
    public void user_should_be_taken_to_the_list_page_with_successful_on(String message) {
        Assert.fail("error");
        Assert.assertEquals(message.toLowerCase().replaceAll("//s", ""), marca.getMessageSuccess().toLowerCase().replaceAll("//s", ""));
    }

}
