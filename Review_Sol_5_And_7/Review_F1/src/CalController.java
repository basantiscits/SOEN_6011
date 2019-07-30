import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalController {
  private CalView view;

  public CalController() {
    view = new CalView("calculator");
    view.setVisible(true);
  }

  public static void main(String[] args) {
    CalController controller = new CalController();
    controller.initial(controller);
  }

  public CalView getView() {
    return view;
  }

  public void initial(CalController controller) {
    controller
        .getView()
        .getButton()
        .addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                String strnum = controller.getView().getText().getText();
                calculate(strnum, controller);
              }
            });
  }

  public void calculate(String strnum,CalController controller){
    try {
      double number = Double.valueOf(strnum);
      if (number > 1 || number < -1) {
        throw new RuntimeException("value must be in domain");
      }
      double res = arrcos(number);
      controller.getView().getAnswer().setText(String.valueOf(res));
    } catch (NumberFormatException exception) {
      controller.getView().getAnswer().setText("not a number");
    } catch (RuntimeException re) {
      controller.getView().getAnswer().setText(re.getMessage());
    }
  }

  public double arrcos(double number) {
    double negate = number < 0 ? 1 : 0;
    number = number > 0 ? number : -number;
    double ret = -0.0187293;
    ret = ret * number;
    ret = ret + 0.074261;
    ret = ret * number;
    ret = ret - 0.2121144;
    ret = ret * number;
    ret = ret + 1.5707288;
    ret = ret * sqrt(1.0 - number);
    ret = ret - 2 * negate * ret;
    return negate * 3.14159265358979 + ret;
  }

  public double sqrt(double x) {
    if (x == 0) return 0;
    double last = 0.0;
    double res = 1.0;
    while (res != last) {
      last = res;
      res = (res + x / res) / 2;
    }
    return res;
  }
}
