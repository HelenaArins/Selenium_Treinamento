package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static utils.Tools.waitBy;

import java.util.List;

public class GooglePage {
	private WebDriver driver;
	
	@FindBy(how = How.NAME, using= "q")
	private WebElement searchInput;
	
	@FindBy(how = How.NAME, using= "btnK")
	private WebElement searchBTN;

	@FindBy(how = How.XPATH, using = "//a[@href='https://thedogfatherbrasil.com.br/']/h3")
	private WebElement elementTest;
	
	@FindBy(how = How.CLASS_NAME, using = "produtos-info__box")
	private List<WebElement> dogValores; 
	
	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public GooglePage acessGoogle() {
		driver.get("https://www.google.com");	
		return this;
	}
	
	public GooglePage dogFather() {
		driver.get("https://thedogfatherbrasil.com.br/cardapio-the-dogfather/");
		return this;
	}
	
	public GooglePage typeTextToSearch(String text) {
		waitBy(searchInput, driver).sendKeys(text);
		return this;
	}
	
	public GooglePage clickSearchButton() {
		waitBy(searchBTN, driver).click();
		return this;
		}
	
	public String getResult() {
		return waitBy(elementTest, driver).getText();	
	}	
	
	public String getTtestList(String comparacao) {
		for(WebElement p:dogValores) {
			String produto = p.findElement(By.className("produtos-info__peso")).getText();
			String preco = p.findElement(By.className("produtos-info__preco")).getText();
			String result = produto+ " " + preco;
			if(result.equals(comparacao)) {
				return result;
			}
		}
		return "";
	}
}
