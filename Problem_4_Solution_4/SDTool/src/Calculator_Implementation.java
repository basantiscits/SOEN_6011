
public class Calculator_Implementation {

  /*
   * Author : Basant Gera Date Created :26-July-2019 Version : 1.0
   */
  public double fncCalculateSD(double Variance) {
    double SD = 0.0;
    if (Variance == 0.0) {
      SD = 0.0;
    } else {
      SD = squareRoot(Variance);
    }
    return SD;
  }

  /*
   * Author : Basant Gera Date Created :26-July-2019 Version : 1.0
   */
  public double fncCalculateMean(double sCalculateSum, int iLength) {
    // TODO Auto-generated method stub
    double Mean = sCalculateSum / iLength;
    return Mean;
  }

  /*
   * Author : Basant Gera Date Created :26-July-2019 Version : 1.0
   */
  public double fncCalculateVariance(String[] sArray, double sCalculateMean, int iLength,
      String sType) {
    // TODO Auto-generated method stub
    double Variance = 0.0;
    for (int i = 0; i < sArray.length; i++) {
      double number = Double.parseDouble(sArray[i]) - sCalculateMean;
      number = number * number;
      Variance += number;
    }
    if (sType.equals("pop")) {
      Variance = Variance / iLength;
    }
    if (sType.equals("sam")) {
      int iLengthAgain = iLength - 1;
      Variance = Variance / iLengthAgain;
    }

    return Variance;
    // return Variance/iLength;
  }

  /*
   * Author : Basant Gera Date Created :26-July-2019 Version : 1.0
   */
  public double fncCalculateSum(String[] sArray, int iLength) {
    // TODO Auto-generated method stub
    double sum = 0.0;
    for (int i = 0; i < sArray.length; i++) {
      sum += Double.parseDouble(sArray[i]);
    }
    return sum;
  }

  /*
   * Author : Basant Gera Date Created :26-July-2019 Version : 1.0
   */
  public static double squareRoot(double number) {
    double t;
    double squareRoot = number / 2;
    do {
      t = squareRoot;
      squareRoot = (t + (number / t)) / 2;
    } while ((t - squareRoot) != 0);

    return t;
  }

}
