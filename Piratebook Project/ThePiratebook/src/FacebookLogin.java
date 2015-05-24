import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import java.io.File;
import java.util.List;

public class FacebookLogin {

    public static void main(String[] args) throws Exception {

        /* turn off annoying htmlunit warnings */
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);
        java.util.logging.Logger.getLogger("org.apache").setLevel(java.util.logging.Level.OFF);

        String email = "swage@cock.li"; // String for storing user's email //
        String pass = "password101"; // String for storing user's pass //
        String profileurl = ""; // Used for storing the user's profile URL //
        String filePart = "test"; // Used for storing the message that's sent //

        // First we make a new webclient for doing all this crap
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_31);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setTimeout(1000);

        // Grab the login page
        HtmlPage loginPage = webClient.getPage("https://www.facebook.com/login.php");

        List<HtmlForm> loginForms; // Initialize an array to store login forms //
        loginForms = loginPage.getForms(); /* This is a ghetto way of getting the login form,
         * because HtmlUnit doesn't support grabbing by id */

        HtmlForm login = loginForms.get(0);

        HtmlSubmitInput loginButton = login.getInputByName("login"); // Find the login button //
        HtmlTextInput emailField = login.getInputByName("email"); // Get the field for submitting email //
        HtmlPasswordInput passwordField = login.getInputByName("pass"); // Get the field for submitting password //

        // Set the values of the username and password //
        emailField.setValueAttribute(email);
        passwordField.setValueAttribute(pass);

        // Now submit the form by clicking the button and get back the newsfeed. //
        HtmlPage newsfeed = loginButton.click();

        // Now we're going to grab the current user's profile URL to get their messages with themself
        List<DomElement> links = newsfeed.getElementsByTagName("a");
        for (DomElement element : links) {
            if (element.getAttribute("class").equals("fbxWelcomeBoxName")) {
                profileurl = element.getAttribute("href");
            }
        }

        profileurl = profileurl.replace("https://www.facebook.com/", "");

        System.out.println(profileurl);

        HtmlPage messagePage = webClient.getPage("https://www.facebook.com/messages/" + profileurl);

        sendFile(messagePage, new File("memes.jpg"));
    }

    private static void sendMessage(HtmlPage messagePage, String message) throws Exception {
        System.out.println("Sent a message");
        //messagePage.getElementByName("message_body").setAttribute("value", message);
        messagePage.executeJavaScript("document.getElementsByName('message_body')[0].value = '" + message + "'").getJavaScriptResult();

        messagePage.executeJavaScript("document.getElementsByClassName('_5f0v')[3].click()");

        Thread.sleep(10000);
    }

    private static void sendMessages(HtmlPage messagePage, String[] messages) throws Exception {
        for (String s : messages) {
            sendMessage(messagePage, s);
        }
    }

    private static void sendFile(HtmlPage messagePage, File file) throws Exception {
        String[] strings = base64Functions.encodeAndSplit.intoStrings(file);
        sendMessage(messagePage, "BEGIN FILE " + file.getName() + " " + strings.length + " messages incoming");
        sendMessages(messagePage, strings);
        sendMessage(messagePage, "END FILE " + file.getName());
    }
}
