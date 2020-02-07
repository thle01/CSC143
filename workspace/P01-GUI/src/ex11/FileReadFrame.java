package ex11;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FileReadFrame extends JFrame implements ActionListener {
   private JScrollPane scrollPane;       // Container adds scroll bar
   private JTextArea outputArea;         // Holds file output
   private JLabel selectedFileLabel;     // Label for file name
   private JLabel outputLabel;           // Label for file contents
   private JTextField selectedFileField; // Holds name of file
   private JFileChooser fileChooser;     // Enables user to select file
   private JButton openFileButton;       // Trigger file open

   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   FileReadFrame() {
      GridBagConstraints layoutConst = null; // GUI component layout

      // Set frame's title
      setTitle("File reader");

      outputLabel = new JLabel("File contents:");
      selectedFileLabel = new JLabel("Selected file:");

      selectedFileField = new JTextField(20);
      selectedFileField.setEditable(false);
      selectedFileField.setText("...");

      outputArea = new JTextArea(10, 25);
      scrollPane = new JScrollPane(outputArea);
      outputArea.setEditable(false);

      openFileButton = new JButton("Open file");
      openFileButton.addActionListener(this);

      // Create file chooser. It's not added to this frame.
      fileChooser = new JFileChooser();

      // Add components using GridBagLayout
      setLayout(new GridBagLayout());

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      add(openFileButton, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 5, 5, 1);
      layoutConst.anchor = GridBagConstraints.LINE_END;
      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      add(selectedFileLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 1, 5, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 2;
      layoutConst.gridy = 0;
      layoutConst.gridwidth = 2;
      layoutConst.gridheight = 1;
      add(selectedFileField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(5, 10, 0, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 1;
      add(outputLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 2;
      layoutConst.gridheight = 2;
      layoutConst.gridwidth = 4;
      add(scrollPane, layoutConst);
   }

   /* Called when openFileButton is pressed. */
   @Override
   public void actionPerformed(ActionEvent event) {
      FileInputStream fileByteStream = null; // File input stream
      Scanner inFS = null;                   // Scanner object
      String readLine;                       // Input from file
      File readFile = null;                  // Input file
      int fileChooserVal;                    // File chooser

      // Open file chooser dialog and get the file to open
      fileChooserVal = fileChooser.showOpenDialog(this);

      // Check if file was selected
      if (fileChooserVal == JFileChooser.APPROVE_OPTION) {
         readFile = fileChooser.getSelectedFile();

         // Update selected file field
         selectedFileField.setText(readFile.getName());

         // Ensure file is valid
         if (readFile.canRead()) {
            try {
               fileByteStream = new FileInputStream(readFile);
               inFS = new Scanner(fileByteStream);

               // Clear output area
               outputArea.setText(""); 

               // Read until end-of-file
               while (inFS.hasNext()) {
                  readLine = inFS.nextLine();
                  outputArea.append(readLine + "\n");
               }

            } catch (IOException e) {
               outputArea.append("\n\nError occurred while creating file stream! " + e.getMessage());
            }
         }
         else { // Can't read file
            // Show failure dialog
            JOptionPane.showMessageDialog(this, "Can't read file!");
         }
      }
   }

   /* Creates a FileReadFrame and makes it visible */
   public static void main(String[] args) {
      // Creates FileReadFrame and its components
      FileReadFrame myFrame = new FileReadFrame();

      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
   }
}
