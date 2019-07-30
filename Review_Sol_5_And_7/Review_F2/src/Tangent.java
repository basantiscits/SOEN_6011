
import java.lang.*;

public class Tangent {
  double userInput;
  boolean resultNegative;
  boolean calculateReciprocal;
  boolean inputNegative;
  double result;

  public Tangent(double userInput) {
    this.userInput = userInput;
    this.resultNegative = false;
    this.calculateReciprocal = false;
    this.inputNegative = false;
    this.process();
  }

  /* Use the userInput value as 'x' for tan(x)*/
  public void process() {
    try {
      checkNegative();
      reduceAngle();
      reduceLessThan45();
      this.result = this.refineResult(trigonometricIdentity());
    } catch (Exception e) {
      // error
    }
  }

  private void checkNegative() {
    if (this.userInput < 0) {
      this.userInput = Math.abs(this.userInput);
      inputNegative = true;
    }
  }

  private double refineResult(double result) {
    if (this.calculateReciprocal) {
      result = 1 / result;
    }

    if (this.resultNegative) {
      result = -result;
    }

    if (this.inputNegative) {
      result = -result;
    }
    return result;
  }

  private double trigonometricIdentity() {
    double result = 0;
    if (this.userInput < 22.5) {
      result = calculatePolynomial();
    } else {
      /* use the formula = (2 * tan(x / 2)) / (1 - tan2(x/2)) - step 4 */
      Tangent tanxBy2Object = new Tangent(this.userInput / 2);
      double tanxBy2 = tanxBy2Object.getValue();
      result = (2 * tanxBy2) / (1 - Math.pow(tanxBy2, 2));
    }
    return result;
  }

  // use the polynomial formula
  private double calculatePolynomial() {
    this.userInput = degreeToRadian(this.userInput);
    return (this.userInput)
        + (Math.pow(this.userInput, 3) / 3)
        + ((2 * Math.pow(this.userInput, 5)) / 15)
        + ((2 * Math.pow(this.userInput, 7)) / 315);
  }

  private double degreeToRadian(double degree) {
    return degree * (Math.PI / 180);
  }

  private void reduceLessThan45() {
    if (this.userInput > 45 && this.userInput < 90) {
      this.userInput = 90 - this.userInput;
      this.calculateReciprocal = true;
    }
  }

  // return if the result has to be negative
  private boolean getQuadrant() {
    double value = Math.abs(this.userInput);
    if (value < 90) {
      return false;
    }

    // Q2
    if (value < 180 && value > 90) {
      return true;
    }

    // Q3
    if (value < 270 && value > 180) {
      return false;
    }

    if (value < 360 && value > 270) {
      return true;
    }
    return false;
  }

  private void reduceAngle() {
    double x = this.userInput;

    if (this.userInput > 360) {
      reduceLessThan360();
    }

    if (this.userInput < 180 && this.userInput > 90) {
      x = -this.userInput + 180;
      this.resultNegative = true;
    }

    /* x value is greater than 180 -- reduce it */
    if (this.userInput < 270 && this.userInput > 180) {
      // use 180 + y = x
      x = this.userInput - 180;
    }

    if (this.userInput < 360 && this.userInput > 270) {
      // use 360 - y = x
      x = 360 - this.userInput;
      this.resultNegative = true;
    }

    this.userInput = x;
  }

  @SuppressWarnings("checkstyle:WhitespaceAround")
  private void reduceLessThan360() {
    if (this.userInput > 360) {
      this.userInput = this.userInput - 360;
      reduceLessThan360();
    }
    return;
  }

  double getValue() {
    return this.result;
  }
}
