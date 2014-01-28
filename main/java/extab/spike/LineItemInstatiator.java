package extab.spike;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LineItemInstatiator {

  private final MyAnnotationProcessor processor;

  public LineItemInstatiator() {
    processor = new MyAnnotationProcessor();
  }

  public List<LineItem> createLineItems(Map<Integer, List<String>> rows) {
    List<LineItem> createdLineItems = new ArrayList<LineItem>();
    for(int rowNum : rows.keySet()){
      List<String> rowValues = rows.get(rowNum);
      createdLineItems.add(rowNum, createLineItem(rowValues));
    }

    return createdLineItems;
  }

  private LineItem createLineItem(List<String> rowValues) {
    LineItem lineItem = new LineItem();
    for(Field field : getAnnotatedFields()){
      int index = getFieldOrder(field.getName()) - 1;
      String value = rowValues.get(index);
      setFieldValue(lineItem, field, value);
    }
    return lineItem;
  }

  private void setFieldValue(LineItem lineItem, Field field, Object value){
    try {
      field.setAccessible(true);
      field.set(lineItem, value);
    } catch (IllegalAccessException e) {}
  }

  private int getFieldOrder(String fieldName){
    try {
      return processor.getFieldAnnotationOrder(LineItem.class, fieldName);
    } catch (NoSuchFieldException e) {}

    return -1;
  }

  private List<Field> getAnnotatedFields() {
    List<Field> fields = new ArrayList<Field>();
    for(Field field : LineItem.class.getDeclaredFields()){
      if(isFieldAnnotatedWith(field, FieldAnnotation.class)) fields.add(field);
    }
    return fields;
  }

  private boolean isFieldAnnotatedWith(Field field, Class fieldAnnotationClass) {
    return null != field.getAnnotation(fieldAnnotationClass);

  }
}
