import org.junit.*;
import static org.junit.Assert.*;

public class PlaceTest {

  @Test
  public void Place_initiatesCorrectly_true() {
    Place testPlace = new Place("St. Louis");
    assertEquals(true, testPlace instanceof Place);
  }

  @Test
  public void getLocation_initiatesWithLocation_String() {
    Place testPlace = new Place("St. Louis");
    assertEquals("St. Louis", testPlace.getLocation());
  }
}
