package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProdutoPage {

	private WebDriver driver;

	private By nomeProduto = By.cssSelector("h1[itemprop=\"name\"]");

	private By precoProduto = By.cssSelector("span[itemprop=\"price\"]");

	private By tamanhoProduto = By.id("group_1");
	
	private By inputCorPreta = By.xpath("//*[@id=\"group_2\"]/li[2]/label/input");
	
	private By quantidadeProduto = By.id("quantity_wanted");
	
	private By  botaoAddToCart = By.className("add-to-cart");

	public ProdutoPage(WebDriver driver) {

		this.driver = driver;
	}

	public String obterNomeProduto() {

		return driver.findElement(nomeProduto).getText();

	}

	public String obterPrecoProduto() {

		return driver.findElement(precoProduto).getText();

	}

	public void selecionarOpcaoDropDown(String opcao) {
		encontrarDropdownSize().selectByVisibleText(opcao);
	}
	
	public List<String> obterOpcoesSelecionadas() {
		List<WebElement> elementosSelecionados = 
		encontrarDropdownSize().getAllSelectedOptions();

		List<String> listaOpcoesSelecionadas = new ArrayList();
		for (WebElement elemento : elementosSelecionados) {
			listaOpcoesSelecionadas.add(elemento.getText());
		}
		return listaOpcoesSelecionadas;
	}

	public Select encontrarDropdownSize() {
		return new Select(driver.findElement(tamanhoProduto));
	}
	
	public void selecionareCorPreta() {
		driver.findElement(inputCorPreta).click();
	}
	
	public void alterarQuantidade(int quantidade) {
		driver.findElement(quantidadeProduto).clear();
		driver.findElement(quantidadeProduto).sendKeys(Integer.toString(quantidade));
	}
	
	public ModalProdutoPage clicarBotaoAddToCart() {
		driver.findElement(botaoAddToCart).click();
		return new ModalProdutoPage(driver);
	}

}
