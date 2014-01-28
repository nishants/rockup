package extab.spike;

public class MyAnnotationProcessor {

  public String getAnnotationName(Class claz){
    MyAnnotation annotation = (MyAnnotation)claz.getAnnotation(MyAnnotation.class);

    return annotation.name();
  }

  public String getAnnotationValue(Class claz) {
    MyAnnotation annotation = (MyAnnotation)claz.getAnnotation(MyAnnotation.class);

    return annotation.value();
  }
}
