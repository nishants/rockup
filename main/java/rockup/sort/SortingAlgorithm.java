package rockup.sort;

import lombok.Getter;

import java.util.Calendar;

@Getter
public abstract class SortingAlgorithm<T extends Comparable>{
  private long beginTime;
  private long endTime;
  private String algorithmName;

  protected SortingAlgorithm(String algorithmName){
    this.algorithmName = algorithmName;
  }

  public final T[] sort(T[] elements){
    beginTime = getTime();
    sortArray(elements);
    endTime = getTime();
    return  elements;
  }

  private long getTime(){
    return Calendar.getInstance().getTimeInMillis();
  }

  protected abstract T[] sortArray(T[] input);

  public final String getAlgorithmName(){
    return algorithmName;
  }

  public final long runtimeInMillis() {
    return endTime - beginTime;
  }
}
