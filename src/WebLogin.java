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
 * This class is used for the actual web authentication for logging into Facebook
 * 
 * @author Deliquescence <Deliquescence1@gmail.com>
 * 		   Tim Tepatti <tim@tepatti.com>
 */
public class WebLogin implements Runnable {

    private boolean loggedIn = false;
    private boolean doneLoggingIn = false;
    private boolean sending = false;

    private final String email;
    private final String password;

    private HtmlPage messagePage;
    private WebClient webClient;
    private String profileUrl = null; // Used for storing the user's profile URL

    /**
     * Create a new WebLogin to interface with Facebook
     *
     * @param email 	The user's email
     * @param password 	The user's password
     */
    public WebLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Run this WebLogin. This attempts to login to facebook using the constructed credentials.
     * Boolean variables are set according to the success or failure of the attempt.
     */
    @Override
    public void run() {
        Logger log = java.util.logging.Logger.getLogger("FacebookLogin");

        // Turn off annoying htmlunit warnings
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);
        java.util.logging.Logger.getLogger("org.apache").setLevel(java.util.logging.Level.OFF);

        // First we make a new webclient for doing all this crap
        webClient = new WebClient(BrowserVersion.FIREFOX_31);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        // webClient.getOptions().setTimeout(1000);
        log.log(Level.FINE, "WebClient Created");

        // Grab the login page
        HtmlPage loginPage = null;
        try {
            loginPage = webClient.getPage("https://www.facebook.com/login.php");
            log.log(Level.FINE, "login page got");
        } catch (IOException | FailingHttpStatusCodeException ex) {
            Logger.getLogger(WebLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<HtmlForm> loginForms; // Initialize an array to store login forms
        loginForms = loginPage.getForms(); // This is a ghetto way of getting the login form, because HtmlUnit doesn't support grabbing by id

        HtmlForm login = loginForms.get(0);

        HtmlSubmitInput loginButton = login.getInputByName("login"); // Find the login button
        HtmlTextInput emailField = login.getInputByName("email"); // Get the field for submitting email
        HtmlPasswordInput passwordField = login.getInputByName("pass"); // Get the field for submitting password

        // Set the values of the username and password
        emailField.setValueAttribute(this.email);
        passwordField.setValueAttribute(this.password);

        // Now submit the form by clicking the login button and return to the newsfeed
        HtmlPage newsfeed = null;
        try {
            newsfeed = loginButton.click();
            log.log(Level.FINE, "loginButton.click()");
        } catch (IOException ex) {
            Logger.getLogger(WebLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Now we're going to grab the current user's profile URL to fetch messages sent to themselves
        try {
            List<DomElement> links = newsfeed.getElementsByTagName("a");
            for (DomElement element : links) {
                if (element.getAttribute("class").equals("fbxWelcomeBoxName")) {
                    profileUrl = element.getAttribute("href");
                }
            }

            profileUrl = profileUrl.replace("https://www.facebook.com/", ""); // Clean up profile URL
            log.log(Level.INFO, "profileurl = {0}", profileUrl);

            messagePage = webClient.getPage("https://www.facebook.com/messages/" + profileUrl);
        } catch (NullPointerException ex) { // if profileUrl is null pointer, we have not logged in
            this.loggedIn = false;
            this.doneLoggingIn = true;
            return;
        } catch (IOException | FailingHttpStatusCodeException ex) {
            Logger.getLogger(WebLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.loggedIn = profileUrl != null;
        this.doneLoggingIn = true;
    }

    /**
     * Used to send one message to the facebook chat
     *
     * @param message The message to send
     */
    public void sendMessage(String message) {
        System.out.println("Sent a message");

        this.messagePage.executeJavaScript("document.getElementsByName('message_body')[0].value = '" + message + "'").getJavaScriptResult(); //Set message text
        this.messagePage.executeJavaScript("document.getElementsByClassName('_5f0v')[3].click()"); // Click send button

        try {
            Thread.sleep(10000); // Messages drop if we dont sleep
        } catch (InterruptedException ex) {
            Logger.getLogger(WebLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Used to send multiple message at once to the facebook chat
     *
     * @param messages an array of messages to send
     */
    private void sendMessages(String[] messages) {
        for (String s : messages) {
            sendMessage(s);
        }
    }

    /**
     * Send a file to the facebook chat. Automatically encodes to base64 and splits the message into the required pieces, sending multiple messages
     *
     * @param file The file to send to facebook chat
     *
     * @throws java.io.IOException
     *
     * @deprecated Use Uploadable.run() instead.
     */
    @Deprecated
    public void sendFile(File file) throws IOException {
        this.sending = true;
        String[] strings = base64Functions.encodeAndSplit.intoStrings(file);

        sendMessage("BEGIN FILE " + file.getName() + " " + strings.length + " messages incoming");
        sendMessages(strings);
        sendMessage("END FILE " + file.getName());

        this.sending = false;
    }

    /**
     * Set the page for messages. Used to change the chat that things are sent to.
     * Fails if messages are being sent, since we dont want to randomly switch chats in the middle of a file.
     *
     * @param profileUrl the new url for the chat
     *
     * @return If it changed (didn't fail because we were sending)
     *
     * @throws IOException
     */
    public boolean setMessagePage(String profileUrl) {
        if (!sending) {
            try {
                messagePage = webClient.getPage("https://www.facebook.com/messages/" + profileUrl);
            } catch (IOException | FailingHttpStatusCodeException ex) {
                Logger.getLogger(WebLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get the current profile url that messages are sent to
     *
     * @return the current chat url
     */
    public String getProfileUrl() {
        return profileUrl;
    }

    /**
     * Is the user successfully logged in?
     *
     * @return whether the login was completed successfully
     */
    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    /**
     * Are we currently logging in?
     *
     * @return whether the login is still being processed
     */
    public boolean isLoggingIn() {
        return !this.doneLoggingIn;
    }

    /**
     * Are we currently sending messages/files?
     *
     * @return whether data is being sent.
     */
    public boolean isSending() {
        return this.sending;
    }

    /**
     * @param b Sending or not
     */
    public void setSending(boolean b) {
        this.sending = b;
    }
}
