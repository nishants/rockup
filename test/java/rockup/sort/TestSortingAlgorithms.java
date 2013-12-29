package rockup.sort;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TestSortingAlgorithms {

  private SortingAlgorithm<Integer> dumbSortingAlgorithm;
  private static final long MINIMUM_SLEEP_TIME = 1000L;
  private String algorithmName = "DUMB ALGO";

  @Before
  public void setup(){
    this.dumbSortingAlgorithm = new SortingAlgorithm<Integer>(algorithmName){
      @Override
      protected Integer[] sortArray(Integer[] input) {
        try {
          Thread.sleep(MINIMUM_SLEEP_TIME);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        return input;
      }
    } ;
  }

  @Test
  public void shouldReturnName(){
    assertThat(dumbSortingAlgorithm.getAlgorithmName(),is(algorithmName));
  }

  @Test
  public void shouldUpdateBeginTimeAndEndTime(){
    long runtime = dumbSortingAlgorithm.sort(new Integer[0]);

    assertTrue(runtime > MINIMUM_SLEEP_TIME);
  }
}
