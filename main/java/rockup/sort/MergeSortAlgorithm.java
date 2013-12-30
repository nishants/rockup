package rockup.sort;

public class MergeSortAlgorithm<T extends Comparable> extends SortingAlgorithm<T>{

  public final static String MERGE_SORT_ALGORITHM_NAME = "Merge Sort Algorithm";

  public MergeSortAlgorithm(){
    super(MERGE_SORT_ALGORITHM_NAME);
  }

  protected T[] sortArray(T[] elements){
    mergeSort(0,elements.length-1,elements);
    return elements;
  }

  protected void  mergeSort(int lowerIndex, int upperIndex, T[] elements){
    if(upperIndex - lowerIndex > 1){
      int midIndex = (upperIndex+lowerIndex)/2;
      mergeSort(lowerIndex,midIndex,elements);
      mergeSort(midIndex+1,upperIndex,elements);
      mergeSortedSubArray(lowerIndex,upperIndex,elements);
    }
  }

  protected void mergeSortedSubArray(int fromIndex, int toIndex, T[] array){
    int midIndex = (fromIndex + toIndex)/2;
    int i=fromIndex, j=midIndex+1;

    while(i!=j){
      if(greaterThan(array[i],array[j])){
        insertElement(j,i,array);
        if(j<toIndex) j++;
      }else{
        i++;
      }
    }
  }

  protected void insertElement(int fromIndex, int toIndex, T[] array) {
    T replaced = array[fromIndex];

    for(int i=fromIndex; i>toIndex; i--){
      array[i]=array[i-1];
    }

    array[toIndex] = replaced;
  }
}
