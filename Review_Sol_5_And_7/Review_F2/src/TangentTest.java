import static org.junit.Assert.*;
import org.junit.Test;

public class TangentTest {

  /* Test the angle in Quadrant 1
   * Angle less than 90
   * */
  @Test
  public void testAngleInQ1() {
    Tangent tan = new Tangent(40);

    // assert the value equality
    assertEquals(tan.getValue(),0.8390038123135642,0.0);
  }

  /* Test the angle in Quadrant 2
   * Angle between : 90 & 180
   * */
  @Test
  public  void testAngleInQ2() {
    Tangent tan = new Tangent(110);

    // assert the value equality
    assertEquals(tan.getValue(),-2.7477177891011286,0.0);
  }

  /* Test the angle in Quadrant 3
  * Angle between : 180 & 270
  * */
  @Test
  public void testAngleInQ3() {
    Tangent tan = new Tangent(194);

    // assert the value equality
    assertEquals(tan.getValue(),0.24932545686957802,0.0);
  }

  /* Test the angle in Quadrant 4
   * Angle between : 270 & 360
   * */
  @Test
  public void testAngleInQ4() {
    Tangent tan = new Tangent(289);

    // assert the value equality
    assertEquals(tan.getValue(), -2.9043973661178435,0.0);
  }

  /* Test a negative angle
   * */
  @Test
  public void testNegativeAngle() {
    Tangent tan = new Tangent(-165);

    // assert the value equality
    assertEquals(tan.getValue(), 0.2679450486272898,0.0);
  }

  @Test
  public void getValue() {}
}


