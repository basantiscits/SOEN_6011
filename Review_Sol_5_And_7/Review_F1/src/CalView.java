import javax.swing.*;
import java.awt.*;

public class CalView extends JFrame {

  private JPanel panel = new JPanel();
  private TextField text = new TextField();
  private JLabel answer = new JLabel();
  private JButton button = new JButton("calculate");

  public CalView(String name) {
    super(name);
    setSize(600, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    initial();
  }

  public void initial() {
    add(panel);
    panel.add(text);
    panel.add(button);
    panel.add(answer);
  }

  public TextField getText() {
    return text;
  }

  public JButton getButton() {
    return button;
  }

  public JLabel getAnswer() {
    return answer;
  }

  public JPanel getPanel() {
    return panel;
  }
}
