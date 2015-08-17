package rockup.sort;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import static rockup.sort.AlgorithmTestSupport.*;
public class InsertSortAlgorithmTest {

  private InsertSortAlgorithm<Integer> sorter;

  @Before
  public void setUp(){
    this.sorter = new InsertSortAlgorithm<Integer>();
  }

  @Test
  public void shouldSortAnArray() throws Exception {
    Integer[] elements = toIntegerArray(3, 6, 5, 1, 2, 4);
    sorter.sort(elements);
    assertThat(elements,is(toIntegerArray(1, 2, 3, 4, 5, 6)));
  }

  @Test
  public void shouldSortASortedArray() throws Exception {
    Integer[] elements = toIntegerArray(1, 2, 3, 4, 5, 6);
    sorter.sort(elements);
    assertThat(elements,is(toIntegerArray(1, 2, 3, 4, 5, 6)));
  }

  @Test
  public void shouldSortAReverseSortedArray() throws Exception {
    Integer[] elements = toIntegerArray(6,5,4,3,2,1);
    sorter.sort(elements);
    assertThat(elements,is(toIntegerArray(1, 2, 3, 4, 5, 6)));
  }

  @Test
  public void shouldDoNothingIfArrayIsOfSizeOne() throws Exception {
    Integer[] elements = toIntegerArray(9);
    sorter.sort(elements);
    assertThat(elements,is(toIntegerArray(9)));
  }

  @Test
  public void shouldDoNothingIfArrayIsEmpty() throws Exception {
    Integer[] elements = new Integer[0];
    sorter.sort(elements);
    assertThat(elements,is(new Integer[0]));
  }

  @Test
  public void shouldInsertElementAtIndex(){
    Integer[] elements = toIntegerArray(3, 5, 2, 4);
    sorter.insertElementAt(2,0,elements);
    assertThat(elements, is(toIntegerArray(2, 5, 3, 4)));
  }

  @Test
  public void shouldInsertIfSubArrayIsOfSizeOne(){
    Integer[] elements = toIntegerArray(2, 1);
    sorter.insertElementAt(1,0,elements);
    assertThat(elements,is(toIntegerArray(1, 2)));
  }

  @Test
  public void shouldInsertIfFromIndexIsNotZero(){
    Integer[] elements = toIntegerArray(3, 5, 2, 4);
    sorter.insertElementAt(2,1,elements);
    assertThat(elements, is(toIntegerArray(3, 2, 5, 4)));
  }
}
