package extab.spike;

import java.lang.reflect.Field;

public class MyAnnotationProcessor {

  public String getAnnotationName(Class claz){
    MyAnnotation annotation = (MyAnnotation)claz.getAnnotation(MyAnnotation.class);

    return annotation.name();
  }

  public String getAnnotationValue(Class claz) {
    MyAnnotation annotation = (MyAnnotation)claz.getAnnotation(MyAnnotation.class);

    return annotation.value();
  }

  public int getFieldAnnotationOrder(Class claz, String fieldName) throws NoSuchFieldException {

    return getFieldAnnotation(claz, fieldName).order();
  }

  public String getFieldAnnotationValue(Class claz, String fieldName) throws NoSuchFieldException {

    return getFieldAnnotation(claz, fieldName).value();
  }

  private FieldAnnotation getFieldAnnotation(Class claz, String fieldName) throws NoSuchFieldException {
    Field field = claz.getDeclaredField(fieldName);
    FieldAnnotation annotation = field.getAnnotation(FieldAnnotation.class);
    return annotation;
  }
}
