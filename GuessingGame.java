import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

// declare the class and include implements ActionListener
public class GuessingGame implements ActionListener {
  //instance variables
  JTextField guessField;
  JButton guessButton, playAgainButton;

  //3 labels
  JLabel jlabUserGuess, jlabHighLow, jlabPreviousGuess;

  //random number object and int to store
  Random r = new Random();
  int randomNum;

  //GuessingGame constructor
  GuessingGame() {
    //random object and int
    randomNum = r.nextInt(101);

    // Create a JFrame container
    JFrame frame = new JFrame("Guessing Game"); 
    // Specify FlowLayout 
    frame.setLayout(new FlowLayout()); 
    // Size the frame 
    frame.setSize(240, 120); 
    // Create a text field 
    guessField = new JTextField(10); 
    // Set the action command for the text field 
    guessField.setActionCommand("myTF");
    // add the two buttons
    guessButton = new JButton("Guess");
    playAgainButton = new JButton("Play Again");

    //add action listeners
    guessField.addActionListener(this);
    guessButton.addActionListener(this);
    playAgainButton.addActionListener(this);

    // add/initialize labels
    jlabUserGuess = new JLabel("Enter your guess: ");
    jlabHighLow = new JLabel("");
    jlabPreviousGuess = new JLabel("");

    //add components to the frame
    frame.add(jlabUserGuess);
    frame.add(guessField);
    frame.add(guessButton);
    frame.add(jlabHighLow);
    frame.add(jlabPreviousGuess);
    frame.add(playAgainButton);

    //make frame visible
    frame.setVisible(true);
  }
  
  //handle action events 
  public void actionPerformed(ActionEvent ae) {
    //action for user guessing
    if(ae.getActionCommand().equals("Guess")) {
      int guess = Integer.parseInt(guessField.getText());
      if (guess < randomNum) {
        jlabHighLow.setText("Too low!");
        jlabPreviousGuess.setText("Last guess was " + guess);
      }
      else if (guess > randomNum) {
        jlabHighLow.setText("Too high!");
        jlabPreviousGuess.setText("Last guess was " + guess);
      }
      else {
        jlabHighLow.setText("You got it!");
        jlabPreviousGuess.setText("Last guess was " + guess);
      }
    }
    //action for user wanting to play again
    else if(ae.getActionCommand().equals("Play Again")) {
      randomNum = r.nextInt(101);
      jlabHighLow.setText("");
      jlabPreviousGuess.setText("");
      guessField.setText("");
    }
    //action for hitting enter on the keyboard instead of guess
    else {
      jlabHighLow.setText("You pressed Enter. Please press the Guess Button.");
    }
  }
}