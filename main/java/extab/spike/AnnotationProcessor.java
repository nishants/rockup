package extab.spike;

import java.lang.reflect.Field;

public class AnnotationProcessor {

  public String getAnnotationName(Class claz){
    ExcelTable annotation = (ExcelTable)claz.getAnnotation(ExcelTable.class);

    return annotation.name();
  }

  public String getAnnotationValue(Class claz) {
    ExcelTable annotation = (ExcelTable)claz.getAnnotation(ExcelTable.class);

    return annotation.value();
  }

  public int getColumnAnnotationOrder(Class claz, String fieldName) throws NoSuchFieldException {

    return getColumnAnnotation(claz, fieldName).order();
  }

  public String getColumnAnnotationValue(Class claz, String fieldName) throws NoSuchFieldException {

    return getColumnAnnotation(claz, fieldName).value();
  }

  private ExcelColumn getColumnAnnotation(Class claz, String fieldName) throws NoSuchFieldException {
    Field field = claz.getDeclaredField(fieldName);
    ExcelColumn annotation = field.getAnnotation(ExcelColumn.class);
    return annotation;
  }
}
