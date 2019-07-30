import java.awt.Color;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {

  static JLabel resultValue;
  static JTextField xValueInput;
  static JFrame tangentFrame;
  static JButton computeButton;
  static JLabel tanxLabel;
  static JLabel degreeLabel;

  public static void main(String[] args) {
    /* Consume the input and start process  */
    Scanner input = new Scanner(System.in);

    try {
      tangentFrame = new JFrame("Tangent Calculator");
      computeButton = new JButton("Compute");
      computeButton.setBounds(100, 100, 140, 40);

      degreeLabel = new JLabel();
      degreeLabel.setText("Enter value in degrees.");
      degreeLabel.setBounds(100, 170, 200, 200);
      degreeLabel.setForeground(Color.red);

      tanxLabel = new JLabel();
      tanxLabel.setText("tan(x)");
      tanxLabel.setBounds(15, 15, 105, 105);

      resultValue = new JLabel();
      resultValue.setBounds(10, 110, 200, 100);

      xValueInput = new JTextField();
      xValueInput.setBounds(110, 50, 130, 30);
      computeButton.addActionListener(new Main());

      tangentFrame.add(resultValue);
      tangentFrame.add(xValueInput);
      tangentFrame.add(tanxLabel);
      tangentFrame.add(computeButton);
      tangentFrame.add(degreeLabel);
      tangentFrame.setSize(350, 320);
      tangentFrame.setLayout(null);
      tangentFrame.setVisible(true);
      tangentFrame.setResizable(false);
      tangentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    } catch (Exception e) {
      System.out.println("Error processing the request");
    }
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    String s = actionEvent.getActionCommand();
    if (s.equals("Compute")) {

      if (xValueInput.getText().length() > 0) {
        // userInput is in degrees
        try{
          double inputParsed = Double.parseDouble(xValueInput.getText());
          Tangent tanx = new Tangent(inputParsed);
          double result = tanx.getValue();

          resultValue.setText(String.valueOf(result));
          xValueInput.setText("  ");
        }catch(NumberFormatException e){
          resultValue.setText("Please enter a valid numeric.");
          xValueInput.setText("  ");
        }
      }
    }
  }
}
