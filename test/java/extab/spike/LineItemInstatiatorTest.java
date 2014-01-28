package extab.spike;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LineItemInstatiatorTest {

  private LineItemInstatiator instatiator;

  @Before
  public void setUp() throws Exception {
    instatiator = new LineItemInstatiator();
  }

  @Test
  public void shouldCreateLineItemWithValues(){
    Map<Integer, List<String>> rowValues = new HashMap<Integer, List<String>>();
    List<String> itemOne = new ArrayList();
    itemOne.add(0, "program#1");

    List<String> itemTwo = new ArrayList();
    itemTwo.add(0, "program#2");

    rowValues.put(0, itemOne);
    rowValues.put(1, itemTwo);

    List<LineItem> createdItems = instatiator.createLineItems(rowValues);

    LineItem lineItemOne = createdItems.get(0);
    LineItem lineItemTwo = createdItems.get(1);

    assertThat(lineItemOne.getProgramId(), is("program#1"));
    assertThat(lineItemTwo.getProgramId(), is("program#2"));
  }
}
