package rockup.sort;

public class AlgorithmTestSupport {

  public static Integer[] toIntegerArray(int... elements){
    Integer[] toElements = new Integer[elements.length];
    for(int i=0; i< elements.length; i++) toElements[i] = new Integer(elements[i]);
    return toElements;
  }
}
