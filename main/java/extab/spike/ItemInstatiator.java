package extab.spike;

import extab.spike.exceptions.MethodInvokationExcpetion;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemInstatiator {

  private final AnnotationProcessor processor;
  private Class targetClass;

  public ItemInstatiator(Class targetClass) {
    this.targetClass = targetClass;
    processor = new AnnotationProcessor();
  }

  public List createItems(Map<Integer, List<String>> rows) {
    List createdItems = new ArrayList();
    for(int rowNum : rows.keySet()){
      List<String> rowValues = rows.get(rowNum);
      createdItems.add(rowNum, createItem(rowValues));
    }
    return createdItems;
  }

  public Object createItem(List<String> rowValues) {
    Object item = createNewInstance();
    setFieldValues(rowValues, item);
    invokeMethods(rowValues, item);
    return item;
  }

  private void invokeMethods(List<String> rowValues, Object item) {
    for(Method method : getAnnotatedMethods()){
      int index = getMethodOrder(method.getName()) - 1;
      String value = rowValues.get(index);
      invokeMethodWithArgument(item, method, value);
    }
  }

  private void setFieldValues(List<String> rowValues, Object item) {
    for(Field field : getAnnotatedFields()){
      int index = getFieldOrder(field.getName()) - 1;
      String value = rowValues.get(index);
      setFieldValue(item, field, value);
    }
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

  private void invokeMethodWithArgument(Object item, Method method, Object value){
    try {
      method.setAccessible(true);
      method.invoke(item, value);
    } catch (IllegalAccessException e) {
      throw new MethodInvokationExcpetion(e);
    }
    catch (InvocationTargetException e) {
      throw new MethodInvokationExcpetion(e);
    }
  }

  private int getFieldOrder(String fieldName){
    try {
      return processor.getFieldColumnOrder(targetClass, fieldName);
    } catch (NoSuchFieldException e) {
      throw new RuntimeException(e);
    }
  }


  private int getMethodOrder(String methodName) {
      return processor.getMethodColumnOrder(targetClass, methodName);
  }

  private List<Method> getAnnotatedMethods() {
    List<Method> methods = new ArrayList<Method>();
    for(Method method : targetClass.getDeclaredMethods()){
      if(isAnnotated(method, ExcelColumn.class)) methods.add(method);
    }
    return methods;
  }

  private List<Field> getAnnotatedFields() {
    List<Field> fields = new ArrayList<Field>();
    for(Field field : targetClass.getDeclaredFields()){
      if(isAnnotated(field, ExcelColumn.class)) fields.add(field);
    }
    return fields;
  }

  private boolean isAnnotated(AccessibleObject member, Class fieldAnnotationClass) {
    return null != member.getAnnotation(fieldAnnotationClass);

  }
}
