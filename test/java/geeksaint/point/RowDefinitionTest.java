package geeksaint.point;

import extab.spike.AnnotationProcessor;
import extab.spike.ExcelColumn;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RowDefinitionTest {

  @Test
  public void shouldGetRowDefinition() throws NoSuchFieldException {
    class TestClass{
      @ExcelColumn(order = 1) private int columnOne;
      @ExcelColumn(order = 2) private int columnTwo;
      @ExcelColumn(order = 3) private int columnThree;
      @ExcelColumn(order = 4) private int columnFour;
    }

    AnnotationProcessor annotationProcessor = mock(AnnotationProcessor.class);
    when(annotationProcessor.getFieldColumnType(Test.class, "columnOne")).thenReturn(ExcelColumnType.STRING);
    when(annotationProcessor.getFieldColumnType(Test.class, "columnTwo")).thenReturn(ExcelColumnType.STRING);
    when(annotationProcessor.getFieldColumnType(Test.class, "columnThree")).thenReturn(ExcelColumnType.STRING);
    when(annotationProcessor.getFieldColumnType(Test.class, "columnFour")).thenReturn(ExcelColumnType.STRING);

    RowDefinition rowDefinition = new RowDefinition(TestClass.class, new AnnotationProcessor()) ;

    ExcelColumnType[] expectedRowDefinition = new ExcelColumnType[]{
      ExcelColumnType.STRING,
      ExcelColumnType.STRING,
      ExcelColumnType.STRING,
      ExcelColumnType.STRING
    } ;

    assertArrayEquals(rowDefinition.getRowDefinition(), expectedRowDefinition);
  }
}
