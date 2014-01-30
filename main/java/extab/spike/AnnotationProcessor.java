package extab.spike;

import geeksaint.point.ExcelColumnType;

import java.lang.reflect.Field;

public class AnnotationProcessor {

  public String getAnnotationName(Class claz){
    ExcelTable annotation = (ExcelTable)claz.getAnnotation(ExcelTable.class);

    return annotation.name();
  }

  public String getAnnotationValue(Class claz) {
    ExcelTable annotation = (ExcelTable)claz.getAnnotation(ExcelTable.class);

    return (annotation == null) ? null : annotation.value();
  }

  public Integer getColumnAnnotationOrder(Class claz, String fieldName) throws NoSuchFieldException {
    ExcelColumn columnAnnotation = getColumnAnnotation(claz, fieldName);
    return (columnAnnotation == null) ? null : columnAnnotation.order();
  }

  public ExcelColumnType getColumnType(Class claz, String fieldName) throws NoSuchFieldException {

    ExcelColumn columnAnnotation = getColumnAnnotation(claz, fieldName);
    return (columnAnnotation == null) ? null : columnAnnotation.type();
  }

  private ExcelColumn getColumnAnnotation(Class claz, String fieldName) throws NoSuchFieldException {
    Field field = claz.getDeclaredField(fieldName);
    ExcelColumn annotation = field.getAnnotation(ExcelColumn.class);
    return annotation;
  }
}
