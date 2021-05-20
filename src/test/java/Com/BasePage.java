package Com;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public  class BasePage {

    BasePage(){PageFactory.initElements(Driver.getDriver(),this);}


        @FindBy(xpath = "//i[@class= 'hm-icon nav-sprite']")
        private static WebElement menuButton;

        @FindBy(xpath = "//a[@class= 'hmenu-item' and @data-menu-id='2']")
        private static WebElement primeVideoButton;

        @FindBy(xpath = "//a[@href='/gp/video/getstarted?ref_=nav_em__aiv_gs_0_2_2_9']")
        private static WebElement getStartedButton;

        @FindBy(id ="twotabsearchtextbox")
         private static WebElement searchTextBox;

        @FindBy(xpath = "//span[@class= 'a-size-medium a-color-base a-text-normal']")
        private static List <WebElement> productNames;





    public static String getAmazonTitle(){ return Driver.getDriver().getTitle();}
    public static String PrimeVideoTitle(){
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        menuButton.click();
        primeVideoButton.click();
        getStartedButton.click();
        return Driver.getDriver().getTitle();
    }
    public static void typeOnSearchBox(){
        searchTextBox.sendKeys("Terminator", Keys.ENTER);

    }

    public static List<String> getProductNames(){
        ArrayList <String> list = new ArrayList<>();
        for (WebElement productName: productNames){
            list.add(productName.getText());
        }
       return list;

    }








}
