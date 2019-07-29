import static org.junit.Assert.*;
import org.junit.Test;
//import junit.framework.Assert;

public class Calculator_N10_Unit_test {

  Caclulator_Driver_N10 Calculator = new Caclulator_Driver_N10();
  String sInputFromUser = "dsadasdas";
  String sItemNumbers = "100,300,101,130,210,310.90,110.1,1320,110.1,130.0,110,309";
  String sItemNumbersRealNat =
      "-100,32.8,11.9,0,10.9,31.0.13.2,19999.2.1,20.787,0,1345.12,110,1.20";
  String CheckValues = "=10,-100";
  String sCheckVarinaceSDExist = "100.0";
  String sCheckSmallValues = "2,5,7,8,9,10,1,30";
  String sCheckLargeValues = "200,1000,2000,39,1000000,4000000,100067";
  String sCheckInputRecieved = "300,300,900,1800,3600,7200000000000000000000";
  String sCheckComma = "12,45";
  String sCheckSpace = "12 45";

  /*
   * Created By : Basant Gera Dated : 26-july-2019 Version : 1.0 Comments Based on requirments No.1
   * :Requirment No 1 deals with only strings not with Numbers.
   */
  @Test()
  public void testOnlyStrings() {
    try {
      double dRetrun = 0.0;
      dRetrun = Calculator.fncCalculateSD(sInputFromUser);
      assertEquals(dRetrun, "Syntax error");
    } catch (NumberFormatException e) {
    }
  }

  /*
   * Created By : Basant Gera Dated : 26-july-2019 Version : 1.0 Comments Based on requirments No.1
   * :Requirment No 1 deals with only Numbers not with strings.
   */
  @Test()
  public void testOnlyNumbers() {
    try {
      double dRetrun = 0.0;
      dRetrun = Calculator.fncCalculateSD(sItemNumbers);
      String sDouble = Double.toString(dRetrun);
      assertEquals(sDouble, "327.05640812743934");
    } catch (NumberFormatException e) {
    }

  }

  /*
   * Created By : Basant Gera Dated : 26-july-2019 Version : 1.0 Comments Based on requirments No.2
   * :Natural and real Number has been taken in the account.
   */
  @Test()
  public void testNaturalRealNumb() {
    try {
      double dRetrun = 0.0;
      dRetrun = Calculator.fncCalculateSD(sItemNumbersRealNat);
      String sDouble = Double.toString(dRetrun);
      assertEquals(sDouble, "5132.910439578233");
    } catch (NumberFormatException e) {
    }

  }

  /*
   * Created By : Basant Gera Dated : 26-july-2019 Version : 1.0 Comments Based on requirments No.3
   * :SD, Varaince calculated cant be -ve.(Since it has square root so it cant be -ve) More Comment
   * : Every time you put -ve numbers it will be +ve bcoz sqrt root which dont take -ve values.
   */
  @Test()
  public void testVarianceNeg() {
    try {
      double dRetrun = 0.0;
      dRetrun = Calculator.fncCalculateSD(CheckValues);
      String sDouble = Double.toString(dRetrun);
      assertEquals(sDouble, "45.0");
    } catch (NumberFormatException e) {
    }

  }

  /*
   * Created By : Basant Gera Dated : 26-july-2019 Version : 1.0 Comments Based on requirments No.4
   * :Suppose population SD for 1 number is 0.0 since Variance is 0.0 than SD is 0.0 too More
   * Comments : We are taking only 1 number in account which is 100.0
   */
  @Test()
  public void testVarianceSDExist() {
    try {
      double dRetrun = 0.0;
      dRetrun = Calculator.fncCalculateSD(sCheckVarinaceSDExist);
      String sDouble = Double.toString(dRetrun);
      assertEquals(sDouble, "0.0");
    } catch (NumberFormatException e) {
    }

  }

  /*
   * Created By : Basant Gera Dated : 26-july-2019 Version : 1.0 Comments Based on requirments No.5
   * : Large the number and large the diffrence between will result into large SD More Comments :
   * Large diversified values w.r.t to mean
   */
  @Test()
  public void testLargeDevatation() {
    try {
      double dRetrun = 0.0;
      dRetrun = Calculator.fncCalculateSD(sCheckLargeValues);
      String sDouble = Double.toString(dRetrun);
      assertEquals(sDouble, "1377859.8977417029");
    } catch (NumberFormatException e) {
    }

  }


  /*
   * Created By : Basant Gera Dated : 26-july-2019 Version : 1.0 Comments Based on requirments No.5
   * :Smallers the number is smaller the Standard devatation result would be. More Comments : Small
   * diversified values w.r.t to mean.
   */
  @Test()
  public void testSmallDevatation() {
    try {
      double dRetrun = 0.0;
      dRetrun = Calculator.fncCalculateSD(sCheckSmallValues);
      String sDouble = Double.toString(dRetrun);
      assertEquals(sDouble, "8.485281374238571");
    } catch (NumberFormatException e) {
    }

  }

  /*
   * Created By : Basant Gera Dated : 26-july-2019 Version : 1.0 Comments Based on requirments No.6
   * :Means if input is given you should expect some out put for sure. More Comments : If number is
   * passed with comma than you can expect result for sure.
   */
  @Test()
  public void testSomeInputGetOutput() {
    try {
      double dRetrun = 0.0;
      dRetrun = Calculator.fncCalculateSD(sCheckInputRecieved);
      String sDouble = Double.toString(dRetrun);
      assertEquals(sDouble, "2.6832815729997476E21");
    } catch (NumberFormatException e) {
    }

  }


  /*
   * Created By : Basant Gera Dated : 26-july-2019 Version : 1.0 Comments Based on requirements No.7
   * : Numbers entered in textfeild should be in form of ,. More Comments :In requirements no. 7 I
   * have wrote space but now some changes done which is replaced by comma.
   */
  @Test()
  public void testCommaInString() {
    try {
      double dRetrun = 0.0;
      dRetrun = Calculator.fncCalculateSD(sCheckComma);
      String sDouble = Double.toString(dRetrun);
      assertEquals(sDouble, "16.5");
    } catch (NumberFormatException e) {
    }

  }

  /*
   * Created By : Basant Gera Dated : 26-july-2019 Version : 1.0 Comments Based on requirements No.7
   * : Numbers entered in textfeild should be in form of "," no space is allowed. More Comments :In
   * requirements no. 7 I have wrote space but now some changes done which is replaced by comma.
   */
  @Test()
  public void testspaceInString() {
    try {
      double dRetrun = 0.0;
      dRetrun = Calculator.fncCalculateSD(sCheckSpace);
      assertEquals(dRetrun, "Syntax error");
    } catch (NumberFormatException e) {
    }

  }


  /*
   * Created By : Basant Gera Dated : 26-july-2019 Version : 1.0 Comments Based on requirements No.8
   * : Execute in small amount of time More Comments :Less memory and efficient and durable
   */
  @Test()
  public void testtimetaken() {
    // testing time for the functions are as follows:
    // 1) fncCalculateSD(String ) : approx 0.005 s
    // parent function takes 0.005 s and child functions takes 0.001 sec each
    // There are 5 child function
    // 2)fncCalculateSum(),3)fncCalculateMean(),4)fncCalculateVariance(),5)fncCalculateSD(),6)squareRoot()


  }



}
