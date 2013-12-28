package rockup.sort;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
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
    assertThat(dumbSortingAlgorithm.getBeginTime(),is(0l));
    assertThat(dumbSortingAlgorithm.getEndTime(),is(0l));

    dumbSortingAlgorithm.sort(new Integer[0]);

    assertThat(dumbSortingAlgorithm.getBeginTime(),is(not(0l)));
    assertThat(dumbSortingAlgorithm.getEndTime(),is(not(0l)));
    assertTrue(dumbSortingAlgorithm.runtimeInMillis() > MINIMUM_SLEEP_TIME);
  }
}
