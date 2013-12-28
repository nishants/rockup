package rockup.sort;

public class InsertSortAlgorithm<T extends Comparable> extends SortingAlgorithm<T>{

  public final static String ALGORITHM_NAME = "INSERTION SORT";

  protected InsertSortAlgorithm() {
    super(ALGORITHM_NAME);
  }

  @Override
  public T[] sortArray(T[] elements) {

    for(int firstNotSortedIndex=1; firstNotSortedIndex<elements.length; firstNotSortedIndex++){
      for(int j=0; j<firstNotSortedIndex; j++){
        if(greaterThan(elements[j],elements[firstNotSortedIndex])){
          insertElementAt(firstNotSortedIndex,j , elements);
        }
      }
    }

    return elements;
  }

  private boolean greaterThan(T element, T with) {
    return element.compareTo(with) > 0;
  }

  protected void insertElementAt(int fromIndex, int toIndex, T[] elements){
    T replaced = elements[fromIndex];
    elements[fromIndex] = elements[toIndex];

    for(int i=fromIndex +1; i<toIndex-1;i++){
      elements[i+1] = elements[i];
    }

    elements[toIndex] = replaced;
  }
}
