package extab.spike;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemInstatiator {

  private final MyAnnotationProcessor processor;
  private Class targetClass;

  public ItemInstatiator(Class targetClass) {
    this.targetClass = targetClass;
    processor = new MyAnnotationProcessor();
  }

  public List createItems(Map<Integer, List<String>> rows) {
    List createdItems = new ArrayList();
    for(int rowNum : rows.keySet()){
      List<String> rowValues = rows.get(rowNum);
      createdItems.add(rowNum, createItem(rowValues));
    }

    return createdItems;
  }

  private Object createItem(List<String> rowValues) {
    Object item = createNewInstance();
    for(Field field : getAnnotatedFields()){
      int index = getFieldOrder(field.getName()) - 1;
      String value = rowValues.get(index);
      setFieldValue(item, field, value);
    }
    return item;
  }

  private Object createNewInstance() {
    try {
      return targetClass.newInstance();
    } catch (InstantiationException e) {} catch (IllegalAccessException e) {}
    return null;
  }

  private void setFieldValue(Object item, Field field, Object value){
    try {
      field.setAccessible(true);
      field.set(item, value);
    } catch (IllegalAccessException e) {}
  }

  private int getFieldOrder(String fieldName){
    try {
      return processor.getFieldAnnotationOrder(targetClass, fieldName);
    } catch (NoSuchFieldException e) {}

    return -1;
  }

  private List<Field> getAnnotatedFields() {
    List<Field> fields = new ArrayList<Field>();
    for(Field field : targetClass.getDeclaredFields()){
      if(isFieldAnnotatedWith(field, FieldAnnotation.class)) fields.add(field);
    }
    return fields;
  }

  private boolean isFieldAnnotatedWith(Field field, Class fieldAnnotationClass) {
    return null != field.getAnnotation(fieldAnnotationClass);

  }
}
