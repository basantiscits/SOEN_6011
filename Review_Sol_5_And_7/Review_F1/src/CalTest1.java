import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalTest1 {
  private final CalController tested = new CalController();

  @Test
  public void testRelativeError() {
    assertEquals(0.0, tested.arrcos(1.0));
    assertTrue(Math.abs(tested.arrcos(-1.0) -3.14)<0.1);
    assertTrue(Math.abs(tested.arrcos(0.0) - 1.57 )<0.1);
  }
  @Test
  public void testErrorMessage1(){
    String oracle = "value must be in domain";
    tested.calculate("2", tested);
    String message=tested.getView().getAnswer().getText();
    assertEquals(oracle, message);
  }

  @Test
  public void testErrorMessage2(){
    String oracle = "not a number";
    tested.calculate("dwqdqw", tested);
    String message=tested.getView().getAnswer().getText();
    assertEquals(oracle, message);
  }

  @Test
  public void testAccros() {
    assertEquals(0.0, tested.arrcos(1.0));
  }

  @Test(timeout = 60)
  public void testTime() {
    assertEquals(0.0, tested.arrcos(1.0));
  }

}
