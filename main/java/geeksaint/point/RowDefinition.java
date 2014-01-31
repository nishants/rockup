package geeksaint.point;

import extab.spike.AnnotationProcessor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class RowDefinition {
  @Getter
  private final Class rowType;
  private AnnotationProcessor annotationProcessor;

  public RowDefinition(Class rowType, AnnotationProcessor annotationProcessor){
    this.annotationProcessor = annotationProcessor;
    this.rowType = rowType;
  }

  public ExcelColumnType[] getRowDefinition() {
    List<ExcelColumnType> rowDefinition = new ArrayList<ExcelColumnType>();
    for(Field field : rowType.getDeclaredFields()){
      try {
        ExcelColumnType excelColumnType = annotationProcessor.getColumnType(rowType, field.getName());
        if(excelColumnType != null) rowDefinition.add(excelColumnType);
      } catch (NoSuchFieldException e) {}
    }
    return rowDefinition.toArray(new ExcelColumnType[0]);
  }
}
