import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

/**
 * Class to contain everything relating to a file upload.
 * This includes gui elements such as JLabels
 *
 * @author Deliquescence <Deliquescence1@gmail.com>
 */
public class Uploadable implements Runnable {

    private final Piratebook piratebook;

    private final File file;
    private final JLabel nameLabel;

    private final int length;
    private final JProgressBar progressBar;

    private final JLabel sizeLabel;
    private final String owner;
    private final JLabel ownerLabel;

    private final String[] messages;

    /**
     * Make a new uploadable to send something to facebook
     *
     * @param parent the {@link Piratebook} this was made from
     * @param file The file of the upload
     * @param owner The upload owner
     *
     * @throws IOException
     */
    public Uploadable(Piratebook parent, File file, String owner) throws IOException {
        this.piratebook = parent; //Used to get webLogin, to send messages
        this.file = file;
        this.owner = owner;
        this.messages = base64Functions.encodeAndSplit.intoStrings(this.file);
        this.length = messages.length;
        //this.size = size;

        //Create gui elements
        this.nameLabel = new JLabel(this.getFile().getName());
        this.progressBar = new JProgressBar(0, this.getLengthWithTags());
        this.sizeLabel = new JLabel(Integer.toString(this.getLength()));
        this.ownerLabel = new JLabel(this.getOwner());

        //Set properties
        this.nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.sizeLabel.setHorizontalAlignment(SwingConstants.CENTER);//This doesnt work atm because the label width needs to be adjusted i think
        this.ownerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //Make visible
        this.nameLabel.setVisible(true);
        this.progressBar.setVisible(true);
        this.ownerLabel.setVisible(true);
    }

    /**
     * Start uploading
     */
    @Override
    public void run() {
        piratebook.webLogin.setSending(true);

        piratebook.webLogin.sendMessage("BEGIN FILE " + this.getName() + " " + this.getLength() + " messages incoming"); //Start tag
        this.increaseProgress();

        for (String m : this.getMessages()) { //Data messages
            piratebook.webLogin.sendMessage(m);
            this.increaseProgress();
        }

        piratebook.webLogin.sendMessage("END FILE " + this.getName()); //End tag
        this.increaseProgress();

        piratebook.webLogin.setSending(false);
        piratebook.finishUpload(this);
    }

    /**
     * Increase the progressbar by one
     */
    private void increaseProgress() {
        int i = this.getProgressBar().getValue() + 1; //Number completed

        this.getProgressBar().setValue(i);
        this.getProgressBar().setString(i + " / " + this.getLengthWithTags());
        this.getProgressBar().getParent().repaint();
    }

    /**
     * @return the messages
     */
    public String[] getMessages() {
        return messages;
    }

    /**
     * @return The name of the upload
     */
    public String getName() {
        return this.getFile().getName();
    }

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @return the nameLabel
     */
    public JLabel getNameLabel() {
        return nameLabel;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @return the length, including start and end tags.
     */
    public int getLengthWithTags() {
        return length + 2;
    }

    /**
     * @return the progressBar
     */
    public JProgressBar getProgressBar() {
        return progressBar;
    }

    /**
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @return the ownerLabel
     */
    public JLabel getOwnerLabel() {
        return ownerLabel;
    }

    /**
     * @return the sizeLabel
     */
    public JLabel getSizeLabel() {
        return sizeLabel;
    }

}
