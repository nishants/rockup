package rockup.sort;

import lombok.Getter;

import java.util.Calendar;

@Getter
public abstract class SortingAlgorithm<T extends Comparable>{
  private String algorithmName;

  protected SortingAlgorithm(String algorithmName){
    this.algorithmName = algorithmName;
  }

  public final long sort(T[] elements){
    long beginTime = getTime();
    sortArray(elements);
    long endTime = getTime();
    return endTime - beginTime;
  }

  private long getTime(){
    return Calendar.getInstance().getTimeInMillis();
  }

  public final String getAlgorithmName(){
    return algorithmName;
  }

  protected boolean greaterThan(T element, T with) {
    return element.compareTo(with) > 0;
  }

  protected abstract T[] sortArray(T[] input);
}
