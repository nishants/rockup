package rockup.sort;

public class BubbleSortAlgorithm<T extends Comparable> extends SortingAlgorithm<T>{

  private static final String BUBBLE_SORT_ALGORITHM_NAME = "Bubble Sort";

  public BubbleSortAlgorithm(){
    super(BUBBLE_SORT_ALGORITHM_NAME);
  }

  @Override
  protected T[] sortArray(T[] elements){
    for(int i = elements.length-1; i> 0;i--){
      moveLargestElementToIndex(i,elements);
    }
    return elements;
  }

  protected void moveLargestElementToIndex(int index,T[] array){
    for(int i=0;i<index;i++){
      if(greaterThan(array[i],array[i+1])){
        swapElements(i,i+1,array);
      }
    }
  }

  private void swapElements(int index, int toIndex, T[] array) {
    T temp = array[index];
    array[index] = array[toIndex];
    array[toIndex] = temp;
  }
}
