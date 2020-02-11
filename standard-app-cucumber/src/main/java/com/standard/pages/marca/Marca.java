package com.standard.pages.marca;

import com.standard.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Marca extends BasePage {

    private @FindBy(xpath = "//*[@ng-reflect-name='nome']") WebElement textField_Nome;
    private @FindBy(xpath = "//*[@ng-reflect-name='descricao']") WebElement textArea_Descricao;
    private @FindBy(xpath = "//*[@class='btn btn-secondary']") WebElement button_Cadastrar;
    private @FindBy(xpath = "//*[@ng-reflect-ng-class='[object Object]']") WebElement messsage_Sucesso;

    public Marca() {
        super();
    }

    public Marca getMarcaPage(String url) {
        driver.get(url);
        return new Marca();
    }

    public Marca setNome(String nome) {
        sendKeysToWebElement(textField_Nome, nome);
        return new Marca();
    }

    public Marca setDescricao(String descricao) {
        sendKeysToWebElement(textArea_Descricao, descricao);
        return new Marca();
    }

    public String getMessageSuccess() {
        return messsage_Sucesso.getText();
    }

    public Marca clickOnCadastrarButton() {
        waitAndClickElement(button_Cadastrar);
        return new Marca();
    }

}
