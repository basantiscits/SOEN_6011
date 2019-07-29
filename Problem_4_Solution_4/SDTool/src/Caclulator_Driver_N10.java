import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

/*
 * Author : Basant Gera Date Created :26-July-2019 Version : 1.0
 */
public class Caclulator_Driver_N10 extends JFrame implements ActionListener {
  private static final int FrameWidth = 600;
  private static final int FrameHeight = 300;
  private static final int Frame_X = 500;
  private static final int Frame_Y = 500;
  private JPanel buttonPanelForWindow;
  private JPanel inputOutputPanelForWindow;
  private JTextField infoTextFeild;
  private boolean boolEditable = true;
  private static JRadioButton popSDButton;
  private static JRadioButton samSDButton;
  static Calculator_Implementation imp = new Calculator_Implementation();

  /*
   * Author : Basant Gera Date Created :26-July-2019 Version : 1.0
   */
  public Caclulator_Driver_N10() {
    JLabel l1;
    Container contentPane = getContentPane();
    contentPane.setLayout(new FlowLayout());
    buttonPanelForWindow = new JPanel();
    popSDButton = new JRadioButton("Population Standard Devatation", true);
    samSDButton = new JRadioButton("Sample Standard Devatation", false);
    ButtonGroup bgroup = new ButtonGroup();
    bgroup.add(popSDButton);
    bgroup.add(samSDButton);
    contentPane.add(popSDButton);
    contentPane.add(samSDButton);
    buttonPanelForWindow.setLayout(new GridLayout(4, 4, 5, 5));
    buttonPanelForWindow.setBorder(new EmptyBorder(10, 10, 10, 10));
    inputOutputPanelForWindow = new JPanel();
    inputOutputPanelForWindow.setLayout(new FlowLayout());
    inputOutputPanelForWindow.setBorder(new EmptyBorder(10, 10, 10, 10));
    setTitle("SD Calculator : N10");
    setSize(FrameWidth, FrameHeight);
    setResizable(false);
    setLocation(Frame_X, Frame_Y);
    l1 = new JLabel("Enter numbers separated by comma   : ", SwingConstants.CENTER);
    inputOutputPanelForWindow.add(l1);
    infoTextFeild = new JTextField();
    infoTextFeild.setFont(new Font("SansSerif", Font.PLAIN, 16));
    infoTextFeild.setBackground(Color.white);
    infoTextFeild.setBorder(BorderFactory.createLineBorder(Color.black));
    infoTextFeild.setPreferredSize(new Dimension(270, 35));
    infoTextFeild.addActionListener(this);
    inputOutputPanelForWindow.add(infoTextFeild);
    contentPane.add(inputOutputPanelForWindow);
    String ButtonsCalc[] =
        {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "=", "Clear"};
    for (String StrButtons : ButtonsCalc) {
      JButton button = new JButton(StrButtons);
      button.addActionListener(this);
      buttonPanelForWindow.add(button);
    }
    contentPane.add(buttonPanelForWindow);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  /*
   * Author : Basant Gera Date Created :26-July-2019 Version : 1.0
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Caclulator_Driver_N10 calculator = new Caclulator_Driver_N10();
    calculator.setVisible(true);
  }

  /*
   * Author : Basant Gera Date Created :26-July-2019 Version : 1.0
   */
  @Override
  public void actionPerformed(ActionEvent event) {
    // TODO Auto-generated method stub
    try {
      if (event.getSource() instanceof JButton) {
        JButton clickedButton = (JButton) event.getSource();
        if (clickedButton.getText().equals("Clear")) {
          infoTextFeild.setText("");
        }

        if (clickedButton.getText().equals("=")) {
          addOutputFromUser();
        } else {
          addInputFromUser(clickedButton.getText());
        }
      } else {
        addOutputFromUser();
      }
    } catch (Exception e) {
      infoTextFeild.setText("Syntax error");
    }
  }

  /*
   * Author : Basant Gera Date Created :26-July-2019 Version : 1.0
   */
  public void addOutputFromUser() {
    // TODO Auto-generated method stub
    try {
      String stext = "";
      String simpleText = "";
      simpleText = infoTextFeild.getText();
      if (simpleText.equals(null) || (simpleText.equals(""))) {
        infoTextFeild.setText("Syntax error");
      } else {
        double IResultSD = fncCalculateSD(infoTextFeild.getText());
        if (IResultSD == 0.101) {
          stext = "undefined";
        } else {
          stext = String.valueOf(IResultSD);
        }

        if (stext.equals("undefined")) {
          infoTextFeild.setText("undefined");
        } else {
          infoTextFeild.setText((stext).toString());
        }

      }
    } catch (Exception e) {
      infoTextFeild.setText("Syntax error");
    }
    boolEditable = false;

  }

  /*
   * Author : Basant Gera Date Created :26-July-2019 Version : 1.0
   */
  public double fncCalculateSD(String text) {
    // TODO Auto-generated method stub
    double iReturn = 0;

    double sum = 0.0;
    double mean = 0.0;
    double variance = 0.0;
    double standardDevatation = 0.0;
    String sInputFromUser = text;
    String[] sArray = sInputFromUser.split(",");
    int iLength = sArray.length;

    sum = fncSumofFrequencies(sArray, iLength);
    System.out.println("Sum of the data set you entered is  :" + sum);

    mean = fncMeanofFrequencies(sum, iLength);
    System.out.println("Mean of the data set you entered is  :" + mean);

    variance = fncVarianceofFrequencies(sArray, mean, iLength);
    System.out.println("Variance of the data set you entered is  :" + variance);

    if (variance == 0.101) {
      iReturn = 0.101;
    } else {
      standardDevatation = fncStandardDevatationofFrequencies(variance);
      System.out
          .println("Standard Devatation of the data set you entered is  :" + standardDevatation);
      iReturn = standardDevatation;
    }
    System.out.println("\n");
    return iReturn;

  }

  /*
   * Author : Basant Gera Date Created :26-July-2019 Version : 1.0
   */
  public void addInputFromUser(String line) {
    try {
      if (boolEditable) {
        if (line.equals("Clear")) {
          line = "";
        } else {
          line = line;
        }
        infoTextFeild.setText(infoTextFeild.getText() + line);
      } else {
        if (line.equals("Clear")) {
          line = "";
        } else {
          line = line;
        }
        infoTextFeild.setText(line);
        boolEditable = true;
      }
    } catch (Exception e) {
      infoTextFeild.setText("Syntax error");
    }

  }

  /*
   * Author : Basant Gera Date Created :26-July-2019 Version : 1.0
   */
  static double fncStandardDevatationofFrequencies(double variance) {
    // TODO Auto-generated method stub
    double sReturn = 0.0;
    sReturn = imp.fncCalculateSD(variance);
    return sReturn;
  }

  /*
   * Author : Basant Gera Date Created :26-July-2019 Version : 1.0
   */
  public static double fncVarianceofFrequencies(String[] sArray, double mean, int iLength) {
    // TODO Auto-generated method stub
    double sReturn = 0.0;
    boolean popSelected = popSDButton.isSelected();
    boolean samSelected = samSDButton.isSelected();
    String Stype = "";



    if (popSelected) {
      Stype = "pop";
    }

    if (samSelected) {
      Stype = "sam";
    }
    if ((Stype.equals("sam")) && (iLength == 1)) {
      // Stype="sam";
      sReturn = 0.101;
    } else {
      sReturn = imp.fncCalculateVariance(sArray, mean, iLength, Stype);
    }
    return sReturn;
  }

  /*
   * Author : Basant Gera Date Created :26-July-2019 Version : 1.0
   */
  public static double fncMeanofFrequencies(double sum, int iLength) {
    // TODO Auto-generated method stub
    double sReturn = 0.0;
    sReturn = imp.fncCalculateMean(sum, iLength);
    return sReturn;
  }

  /*
   * Author : Basant Gera Date Created :26-July-2019 Version : 1.0
   */
  public static double fncSumofFrequencies(String[] sArray, int iLength) {
    // TODO Auto-generated method stub
    double sReturn = 0.0;
    sReturn = imp.fncCalculateSum(sArray, iLength);
    return sReturn;
  }
}


