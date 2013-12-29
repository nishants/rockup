package rockup.sort;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static rockup.sort.AlgorithmTestSupport.*;

public class BubbleSortAlgorithmTest {

  private BubbleSortAlgorithm sorter;

  @Before
  public void setUp(){
    this.sorter = new BubbleSortAlgorithm();
  }
  @Test
  public void shouldMoveLargestElementToIndex(){
    Integer[] elements = toIntegerArray(5, 3, 2, 6);

    sorter.moveLargestElementToIndex(2, elements);

    assertThat(elements,is(toIntegerArray(3,2,5,6)));
  }

  @Test
  public void shouldSortAGivenArray(){
    Integer[] array = toIntegerArray(9,3,8,1,5,4,2,7,6);
    sorter.sort(array);

    assertThat(array, is(toIntegerArray(1, 2, 3, 4, 5, 6, 7, 8, 9)));
  }

  @Test
  public void shouldDoNothingForEmptyArray(){
    Integer[] emptyArray = new Integer[0];
    sorter.sort(emptyArray);

    assertThat(emptyArray,is(new Integer[0]));
  }

}
