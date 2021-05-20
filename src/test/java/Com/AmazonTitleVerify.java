package Com;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonTitleVerify {
    BasePage basePage = new BasePage();
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("http://amazon.com");
    }


    @Test
    public  void titleTest(){
    String actualTitle = BasePage.getAmazonTitle();
    String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
     Assert.assertEquals(expectedTitle,actualTitle);

    }

    @Test
    public void primeVideoTest(){
        String actualPrimeVideoTitle = BasePage.PrimeVideoTitle();
        String expectedPrimeVideoTitle = "Prime Video";
        Assert.assertEquals(actualPrimeVideoTitle,expectedPrimeVideoTitle);

    }


    @Test
    public void searchVerification(){
        BasePage.typeOnSearchBox();

    }

    @Test
    public void productNameTest(){
        BasePage.typeOnSearchBox();
        List <String> actualProductNames = BasePage.getProductNames();
        String terminator = "Terminator";
       for (String productName : actualProductNames){
           Assert.assertTrue(productName.toLowerCase().contains(terminator.toLowerCase()));
          System.out.println(productName.toLowerCase());
       }
        System.out.println( actualProductNames.size());


    }


    @AfterMethod
    public void tearDown(){
        Driver.getDriver().close();
    }

}
