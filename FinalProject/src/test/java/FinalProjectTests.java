import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class FinalProjectTests {


  public WebDriver driver = null;
  //Creating a new WebDriver variable
  public String MyEmail = "shiranemus4@gmail.com";
  public String MyPassword = "Shiran1234";
  //Creating string variables
  public WebElement EmailAddress;
  public WebElement Password;
  //Creating new WebElement variables





 @BeforeEach
 void GetChromeDriver(){
  System.setProperty("webdriver.chrome.driver","C:\\Users\\shira\\Downloads\\chromedriver_win32\\chromedriver.exe\\");
  //ChromeDriver location on the computer
  driver = new ChromeDriver();
 }

 @AfterEach
 void CloseWindows(){
  driver.quit();
 }


 @Test
 void RegistrationProcessTest(){
  driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
  //Entering the account registration page
  var FirstName = driver.findElement(By.id("input-firstname"));
  FirstName.sendKeys("Shiran");
  //Finding the element by id and writing the first name
  var LastName = driver.findElement(By.id("input-lastname"));
  LastName.sendKeys("Emus");
  //Finding the element by id and writing the last name
  EmailAddress = driver.findElement(By.id("input-email"));
  EmailAddress.sendKeys(MyEmail);
  //Finding the element by id and writing the email address
  var TelephoneNumber = driver.findElement(By.id("input-telephone"));
  TelephoneNumber.sendKeys("0526178457");
  //Finding the element by id and writing the telephone number
  Password = driver.findElement(By.id("input-password"));
  Password.sendKeys(MyPassword);
  //Finding the element by id and writing the password
  var PasswordConfirm= driver.findElement(By.id("input-confirm"));
  PasswordConfirm.sendKeys(MyPassword);
  //Finding the element by id and writing the password confirm
  var UnsubscribeButton= driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input"));
  UnsubscribeButton.click();
  //Finding the element by Xpath and Clicking the unsubscribe button
  var AgreeButton = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
  AgreeButton.click();
  //Finding the element by Xpath and Clicking the agree to the Privacy Policy button
  var ContinueButton= driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
   ContinueButton.click();
  //Finding the element by Xpath and Clicking continue button
  Assertions.assertEquals("http://tutorialsninja.com/demo/index.php?route=account/success" , driver.getCurrentUrl());
  //Checking if this is the correct address by comparing
 }

 @Test
 void TheLoginProcessTest(){
  driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
  //Entering the login page
  EmailAddress= driver.findElement(By.id("input-email"));
  EmailAddress.sendKeys(MyEmail);
  //Finding the element by id and Writing the email
  Password= driver.findElement(By.id("input-password"));
  Password.sendKeys(MyPassword);
  //Finding the element by id and Writing the password
  var LoginButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
  LoginButton.click();
  //Finding the element by Xpath and Clicking the login button
  Assertions.assertEquals("http://tutorialsninja.com/demo/index.php?route=account/account" , driver.getCurrentUrl());
  //Comparing between the expected and the actual urls
 }

 @Test
 void AddToCartProcessTest(){
  driver.get("http://tutorialsninja.com/demo/index.php?route=product/product&product_id=43");
  //Entering the MacBook product page
  var AddToCartButton1= driver.findElement(By.id("button-cart"));
  AddToCartButton1.click();
  //Finding the element by id and Clicking the add to cart button
  driver.get("http://tutorialsninja.com/demo/index.php?route=product/product&product_id=33");
  //Entering the Samsung product page
  var AddToCartButton2= driver.findElement(By.xpath("//*[@id=\"button-cart\"]"));
  AddToCartButton2.click();
  //Clicking the add to cart button again
  var CartButton= driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/i"));
  CartButton.click();
  //Finding the element by Xpath and Clicking the cart button
  var TotalPrice= driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/table/tbody/tr[4]/td[2]")).getText();
  //Finding the total price element by Xpath and taking the text from the current location
  Assertions.assertEquals("$844.00",String.valueOf(TotalPrice));
  //Comparing between the expected and the actual outputs
 }

 @Test
 void ProductReviewProcess(){
  driver.get("http://tutorialsninja.com/demo/index.php?route=product/product&product_id=43");
  //Entering the MacBook product page
  var ReviewButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul[2]/li[3]/a"));
  ReviewButton.click();
  //Finding the element by xpath and Clicking
  var MyName= driver.findElement(By.id("input-name"));
  MyName.sendKeys("Shiran Emus");
  //Finding the element by id and writing the name
  String MyReview = "Nice product nice product nice product nice product nice product nice product nice product nice product nice product nice product";
  //creating a variable with my review
  var MyReviewInput= driver.findElement(By.id("input-review"));
  MyReviewInput.sendKeys(MyReview);
  //Finding the element by id and using the review
  List<WebElement> RatingButtonsList = driver.findElements(By.name("rating"));
  RatingButtonsList.get(2).click();
  //Creating a list of the Checkboxes and clicking the third element
  var ContinueButton= driver.findElement(By.id("button-review"));
  ContinueButton.click();
  //Finding the element by id and clicking
  List<WebElement> RedMessage = driver.findElements(By.cssSelector("#form-review > div.alert.alert-danger.alert-dismissible"));
  Assertions.assertEquals(0,RedMessage.size());
  //Creating a list and checking if it is empty

 }


}
