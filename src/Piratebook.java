/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Sizes: jpanel1: 620,277
 *
 */
public class Piratebook extends javax.swing.JFrame {

    public final WebLogin webLogin;

    /**
     * Create a new Piratebook GUI. The WebLogin is used for interfacing with facebook
     *
     * Creates new form Piratebook
     *
     * @param wl The WebLogin being used for this sessions connection with facebook
     */
    public Piratebook(WebLogin wl) {
        initComponents();
        this.webLogin = wl;
        profileURLtextField.setText(webLogin.getProfileUrl());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked") //
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        mainPanel = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        progressPanel = new javax.swing.JPanel();
        fileNamePanel = new javax.swing.JPanel();
        sizePanel = new javax.swing.JPanel();
        fileNameTitleLabel = new javax.swing.JLabel();
        progressTitleLabel = new javax.swing.JLabel();
        ownerTitleLabel = new javax.swing.JLabel();
        sizeTitleLabel = new javax.swing.JLabel();
        speedtitleLabel = new javax.swing.JLabel();
        speedPanel = new javax.swing.JPanel();
        ownerPanel = new javax.swing.JPanel();
        UploadButton = new javax.swing.JButton();
        fileField = new javax.swing.JTextField();
        profileURLtextField = new javax.swing.JTextField();
        profileUrlButton = new javax.swing.JButton();
        mainTitleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(63, 92, 148));
        mainPanel.setName("Backg"); // NOI18N

        infoPanel.setBackground(new java.awt.Color(63, 92, 148));
        infoPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(6, 6, 6, 6, new java.awt.Color(245, 120, 0)));

        jSeparator1.setBackground(new java.awt.Color(245, 120, 0));
        jSeparator1.setForeground(new java.awt.Color(245, 120, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setBackground(new java.awt.Color(245, 120, 0));
        jSeparator2.setForeground(new java.awt.Color(245, 120, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setBackground(new java.awt.Color(245, 120, 0));
        jSeparator3.setForeground(new java.awt.Color(245, 120, 0));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator4.setBackground(new java.awt.Color(245, 120, 0));
        jSeparator4.setForeground(new java.awt.Color(245, 120, 0));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        progressPanel.setLayout(new javax.swing.BoxLayout(progressPanel, javax.swing.BoxLayout.Y_AXIS));

        fileNamePanel.setLayout(new javax.swing.BoxLayout(fileNamePanel, javax.swing.BoxLayout.Y_AXIS));

        sizePanel.setLayout(new javax.swing.BoxLayout(sizePanel, javax.swing.BoxLayout.Y_AXIS));

        fileNameTitleLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        fileNameTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        fileNameTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fileNameTitleLabel.setLabelFor(fileNamePanel);
        fileNameTitleLabel.setText("File Name");

        progressTitleLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        progressTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        progressTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        progressTitleLabel.setLabelFor(progressPanel);
        progressTitleLabel.setText("Progress");

        ownerTitleLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        ownerTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        ownerTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ownerTitleLabel.setText("Owner");

        sizeTitleLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        sizeTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        sizeTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sizeTitleLabel.setLabelFor(sizePanel);
        sizeTitleLabel.setText("Size");

        speedtitleLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        speedtitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        speedtitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        speedtitleLabel.setLabelFor(speedPanel);
        speedtitleLabel.setText("Speed");

        javax.swing.GroupLayout speedPanelLayout = new javax.swing.GroupLayout(speedPanel);
        speedPanel.setLayout(speedPanelLayout);
        speedPanelLayout.setHorizontalGroup(
            speedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        speedPanelLayout.setVerticalGroup(
            speedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        ownerPanel.setLayout(new javax.swing.BoxLayout(ownerPanel, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fileNameTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(fileNamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(progressTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(progressPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ownerTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(ownerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sizePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sizeTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(speedtitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(speedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(fileNameTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileNamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(sizeTitleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sizePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(progressTitleLabel)
                            .addComponent(ownerTitleLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(progressPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ownerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(speedtitleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(speedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
        );

        UploadButton.setBackground(new java.awt.Color(245, 120, 0));
        UploadButton.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        UploadButton.setText("Upload New File");
        UploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadButtonActionPerformed(evt);
            }
        });

        fileField.setEditable(false);

        profileURLtextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileURLtextFieldActionPerformed(evt);
            }
        });

        profileUrlButton.setText("Set profile URL");
        profileUrlButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileUrlButtonActionPerformed(evt);
            }
        });

        mainTitleLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        mainTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        mainTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainTitleLabel.setText("the Piratebook");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(UploadButton)
                                .addGap(10, 10, 10)
                                .addComponent(fileField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(352, 352, 352)
                                .addComponent(profileURLtextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(profileUrlButton))
                            .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(mainTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profileURLtextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profileUrlButton)
                    .addComponent(UploadButton))
                .addGap(18, 18, 18)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void profileUrlButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileUrlButtonActionPerformed
        if (webLogin.setMessagePage(profileURLtextField.getText())) {
            JOptionPane.showMessageDialog(this, "Updated profile successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Cannot change profile while uploading!");
        }
    }//GEN-LAST:event_profileUrlButtonActionPerformed

    private void profileURLtextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileURLtextFieldActionPerformed

    }//GEN-LAST:event_profileURLtextFieldActionPerformed

    private void UploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadButtonActionPerformed
        if (webLogin.isSending()) { //Check if something is already going on
            JOptionPane.showMessageDialog(this, "Cannot yet upload multiple files concurrently");//todo add concurrency, or maybe a queue
            return;
        }
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(this);
        File f = chooser.getSelectedFile();
        if (f == null) { //User closed chooser without selecting
            return;
        }

        fileField.setText(f.getName()); //Set file name display

        try {
            Uploadable u = addUpload(f, webLogin.getProfileUrl());
            new Thread(u, "uploadThread").start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_UploadButtonActionPerformed

    /**
     * Add a file to upload
     *
     * @param file The file to upload
     * @param owner The owner of the upload
     *
     * @return The {@link Uploadable} representing this upload
     *
     * @throws IOException
     */
    private Uploadable addUpload(File file, String owner) throws IOException {
        Uploadable up = new Uploadable(this, file, owner);

        addToPanel(fileNamePanel, up.getNameLabel());
        addToPanel(progressPanel, up.getProgressBar());
        addToPanel(ownerPanel, up.getOwnerLabel());
        addToPanel(sizePanel, up.getSizeLabel());

        return up;
    }

    /**
     * Helper method mostly used to add an uploadables components to the panels
     *
     * @param panel The {@link JPanel} to add to
     * @param add What to add
     */
    private void addToPanel(JPanel panel, JComponent add) {
        panel.add(add);
        panel.repaint();
        panel.revalidate();
    }

    /**
     * Remove the labels and progress bar from an uploadable
     *
     * @param u The {@link Uploadable} to remove
     */
    private void removeUpload(Uploadable u) {
        fileNamePanel.remove(u.getNameLabel());
        progressPanel.remove(u.getProgressBar());
        ownerPanel.remove(u.getOwnerLabel());
        sizePanel.remove(u.getSizeLabel());
    }

    /**
     * Finish an upload, informing the user
     *
     * @param u The {@link Uploadable} to finish
     */
    public void finishUpload(Uploadable u) {
        JOptionPane.showMessageDialog(this, "Upload Finished");
        //removeUpload(u);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Piratebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Piratebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Piratebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Piratebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UploadButton;
    private javax.swing.JTextField fileField;
    private javax.swing.JPanel fileNamePanel;
    private javax.swing.JLabel fileNameTitleLabel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel mainTitleLabel;
    private javax.swing.JPanel ownerPanel;
    private javax.swing.JLabel ownerTitleLabel;
    private javax.swing.JTextField profileURLtextField;
    private javax.swing.JButton profileUrlButton;
    private javax.swing.JPanel progressPanel;
    private javax.swing.JLabel progressTitleLabel;
    private javax.swing.JPanel sizePanel;
    private javax.swing.JLabel sizeTitleLabel;
    private javax.swing.JPanel speedPanel;
    private javax.swing.JLabel speedtitleLabel;
    // End of variables declaration//GEN-END:variables
    private ArrayList<javax.swing.JTextField> allNames;
}
