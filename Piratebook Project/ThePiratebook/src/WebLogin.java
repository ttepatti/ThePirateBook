import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Deliquescence <Deliquescence1@gmail.com>
 */
public class WebLogin implements Runnable {

    private boolean loggedIn;
    private boolean doneLoggingIn = false;
    private boolean sending = false;

    private final String email;//swage@cock.li
    private final String password;//password101

    private HtmlPage messagePage;
    private WebClient webClient;
    private String profileUrl;

    public WebLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void run() {
        Logger log = java.util.logging.Logger.getLogger("FacebookLogin");

        /* turn off annoying htmlunit warnings */
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);
        java.util.logging.Logger.getLogger("org.apache").setLevel(java.util.logging.Level.OFF);

        profileUrl = null; // Used for storing the user's profile URL //
        String filePart = "test"; // Used for storing the message that's sent //

        // First we make a new webclient for doing all this crap
        webClient = new WebClient(BrowserVersion.FIREFOX_31);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        // webClient.getOptions().setTimeout(1000);
        log.log(Level.FINE, "WebClient Created");

        // Grab the login page
        HtmlPage loginPage = null;
        try {
            loginPage = webClient.getPage("https://www.facebook.com/login.php");
        } catch (IOException | FailingHttpStatusCodeException ex) {
            Logger.getLogger(WebLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        log.log(Level.FINE, "login page got");

        List<HtmlForm> loginForms; // Initialize an array to store login forms //
        loginForms = loginPage.getForms(); /* This is a ghetto way of getting the login form, because HtmlUnit doesn't support grabbing by id */

        HtmlForm login = loginForms.get(0);

        HtmlSubmitInput loginButton = login.getInputByName("login"); // Find the login button //
        HtmlTextInput emailField = login.getInputByName("email"); // Get the field for submitting email //
        HtmlPasswordInput passwordField = login.getInputByName("pass"); // Get the field for submitting password //

        // Set the values of the username and password //
        emailField.setValueAttribute(this.email);
        passwordField.setValueAttribute(this.password);

        // Now submit the form by clicking the button and get back the newsfeed. //
        HtmlPage newsfeed = null;
        try {
            newsfeed = loginButton.click();
        } catch (IOException ex) {
            Logger.getLogger(WebLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        log.log(Level.FINE, "loginButton.click()");

        // Now we're going to grab the current user's profile URL to get their messages with themself
        List<DomElement> links = newsfeed.getElementsByTagName("a");
        for (DomElement element : links) {
            if (element.getAttribute("class").equals("fbxWelcomeBoxName")) {
                profileUrl = element.getAttribute("href");
            }
        }

        try { //if profileUrl is null pointer, we have not logged in
            profileUrl = profileUrl.replace("https://www.facebook.com/", "");
            log.log(Level.INFO, "profileurl = {0}", profileUrl);

            messagePage = webClient.getPage("https://www.facebook.com/messages/" + profileUrl);
        } catch (NullPointerException ex) {
            this.loggedIn = false;
            this.doneLoggingIn = true;
            return;
        } catch (IOException | FailingHttpStatusCodeException ex) {
            Logger.getLogger(WebLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.loggedIn = profileUrl != null;
        this.doneLoggingIn = true;
    }

    private void sendMessage(String message) throws Exception {
        System.out.println("Sent a message");
        //messagePage.getElementByName("message_body").setAttribute("value", message);
        this.messagePage.executeJavaScript("document.getElementsByName('message_body')[0].value = '" + message + "'").getJavaScriptResult();

        this.messagePage.executeJavaScript("document.getElementsByClassName('_5f0v')[3].click()");

        Thread.sleep(10000);
    }

    private void sendMessages(String[] messages) throws Exception {
        for (String s : messages) {
            sendMessage(s);
        }
    }

    public void sendFile(File file) throws Exception {
        this.sending = true;
        String[] strings = base64Functions.encodeAndSplit.intoStrings(file);

        sendMessage("BEGIN FILE " + file.getName() + " " + strings.length + " messages incoming");
        sendMessages(strings);
        sendMessage("END FILE " + file.getName());

        this.sending = false;
    }

    public void setMessagePage(String profileUrl) throws IOException {
        messagePage = webClient.getPage("https://www.facebook.com/messages/" + profileUrl);
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    public boolean isLoggingIn() {
        return !this.doneLoggingIn;
    }
}
