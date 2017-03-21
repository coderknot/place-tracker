import org.junit.*;
import static org.junit.Assert.*;

public class PlaceTest {

  @Test
  public void Place_initiatesCorrectly_true() {
    Place testPlace = new Place();
    assertEquals(true, testPlace instanceof Place);
  }
}
