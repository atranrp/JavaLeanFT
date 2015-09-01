

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import com.hp.lft.sdk.*;
import unittesting.*;
import com.hp.lft.sdk.web.*;
import com.hp.lft.report.*;


public class LeanFtTest extends UnitTestClassBase {

	@BeforeClass
	public static void beforeClass() throws Exception {
		globalSetup(LeanFtTest.class);
	}

	@AfterClass
	public static void afterClass() throws Exception {
		globalTearDown();
	}

	@Test
    public void verify_linkNavigatesToAboutTravelSite() throws Exception {
        //Launch the Chrome browser.
        Browser browser = BrowserFactory.launch(BrowserType.CHROME);

         // Use try-catch to add a warning to the run report if the assert validation fails.      
        try{
            // Navigate to the New Tours website.  
            browser.navigate("http://newtours.demoaut.com/");
            
            Reporter.reportEvent("newtours.demoaut.com/",browser.getURL());
            //Click on useredit field

            browser.describe(EditField.class, new EditFieldDescription.Builder()
            		.type("text").tagName("INPUT").name("userName").build()).setValue("tutorial");
            
            browser.describe(EditField.class, new EditFieldDescription.Builder()
            		.type("password").tagName("INPUT").name("password").build()).setValue("tutorial");
            
            browser.describe(Image.class, new ImageDescription.Builder()
            		.alt("Sign-In").type(com.hp.lft.sdk.web.ImageType.BUTTON).tagName("INPUT").build()).click();
            
            // Wait for the browser to complete the navigation.
            browser.sync();
            
            // Enclosing the assert method in a try-catch statement ensures the application 
            // does not throw a runtime error if the Assert returns false. 
            
            // Verify that the correct Web page opens.
           
          //  assertEquals("http://businesstravel.about.com/?PM=78_101_T&cob=home", browser.getURL());
           
        }
        catch(AssertionError e){
            // Adds a step to the results report on failure.
            Reporter.reportEvent("Verify_AboutOpensCorrectly","Failed during validation",Status.Failed, e);
            throw e;
        }
        finally{
          //  browser.close();
        }
    } 
}



 