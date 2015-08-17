package rockup.sort;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static rockup.sort.AlgorithmTestSupport.toIntegerArray;

public class MergeSortAlgorithmTest {

  private MergeSortAlgorithm sorter;

  @Before
  public void setUp(){
    this.sorter = new MergeSortAlgorithm();
  }

  @Test
  public void shouldMergeSortedSubArrays(){
    Integer[] array = toIntegerArray(1,3,5,7,2,4,6);
    sorter.mergeSortedSubArray(0,6,array);

    assertThat(array,is(toIntegerArray(1,2,3,4,5,6,7)));
  }

  @Test
  public void shouldMergeSortedSubArrays2(){
    Integer[] array = toIntegerArray(9,-3,1,3,5,7,2,4,6,-1,-2);
    sorter.mergeSortedSubArray(2,8,array);

    assertThat(array,is(toIntegerArray(9,-3,1,2,3,4,5,6,7,-1,-2)));
  }

  @Test
  public void shouldMergeSortedSubArraysWhenLaterIsSmaller(){
    Integer[] array = toIntegerArray(9,-3,4,5,6,7,1,2,3,-1,-2);
    sorter.mergeSortedSubArray(2,8,array);

    assertThat(array,is(toIntegerArray(9,-3,1,2,3,4,5,6,7,-1,-2)));
  }

  @Test
  public void shouldInsertElementFromIndexToGivenIndex(){
    Integer[] array = toIntegerArray(1,2,4,5,6,3);

    sorter.insertElement(5,2,array);

    assertThat(array,is(toIntegerArray(1,2,3,4,5,6)));
  }

  @Test
  public void shouldSortAGivenArray(){
    Integer[] array = toIntegerArray(3,5,4,7,1,2,6);

    sorter.sort(array);

    assertThat(array,is(toIntegerArray(1,2,3,4,5,6,7)));
  }

  @Test
  public void shouldSortAnAlreadySortedArray(){
    Integer[] sortedArray = toIntegerArray(1,2,3,4,5,6);

    sorter.sort(sortedArray);

    assertThat(sortedArray,is(toIntegerArray(1,2,3,4,5,6)));
  }

  @Test
  public void shouldSortAReverseSortedArray(){
    Integer[] reverseSortedArray = toIntegerArray(7,6,5,4,3,2,1);

    sorter.sort(reverseSortedArray);

    assertThat(reverseSortedArray,is(toIntegerArray(1,2,3,4,5,6,7)));
  }
}
