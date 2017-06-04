package com.pack.common.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

private WebDriver driver;

private By headerPageText = By.cssSelector(".lato-light");
private By createAccountLink = By.partialLinkText("Zarejestruj");
private By emailTextBox = By.id("login");
private By passwordTextBox = By.id("password");
private By loginBtn = By.xpath("//button[@type='submit' and contains(., 'Zaloguj')]");
private By errorMsgTxt = By.cssSelector(".alert");
	
	public SignInPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getSignInPageTitle() {
		String pageTitle = driver.getTitle();
		System.out.print("Page title for sign in " + pageTitle );
		return pageTitle;
	}
	
	public boolean verifySignInPageTitle() {
		String expectedTitle = "odchudzanie, dieta odchudzająca, diety, fitness – Vitalia.pl";
		return getSignInPageTitle().contains(expectedTitle);
	}
	
	public boolean verifySignInPageText() {
		WebElement element = driver.findElement(headerPageText);
		String pageText = element.getText();
		System.out.print("Sign in page text: "+pageText);
		String expectedPageText = "Zaloguj się";
		return pageText.contains(expectedPageText);
	}
		public CreateAccountPage clickonCreateAnAccount() {
			WebElement element=driver.findElement(createAccountLink);
			if(element.isDisplayed()||element.isEnabled())
				element.click();
			return new CreateAccountPage(driver);
	}
		
		public boolean verifySignIn() {
			enterUserName("test");
			enterPassword("pass");
			clickOnSignIn();
			return getErrorMessage().contains("Nieudana autoryzacja");
		}
		
		public void enterUserName(String userName) {
			WebElement emailTxtBox = driver.findElement(emailTextBox);
			if(emailTxtBox.isDisplayed())
				emailTxtBox.sendKeys(userName);
		}
		
		public void enterPassword(String password) {
			WebElement passwordTxtBox = driver.findElement(passwordTextBox);
			if(passwordTxtBox.isDisplayed())
				passwordTxtBox.sendKeys(password);
		}
		
		public void clickOnSignIn() {
			WebElement signInBtn = driver.findElement(loginBtn);
			if(signInBtn.isDisplayed())
				signInBtn.click();
		}
		
		public String getErrorMessage() {
			String strErrorMsg = null;
			WebElement errorMsg = driver.findElement(errorMsgTxt);
			if(errorMsg.isDisplayed()&&errorMsg.isEnabled())
				strErrorMsg = errorMsg.getText();
			return strErrorMsg;
		}
}