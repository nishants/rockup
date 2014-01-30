package geeksaint.point;

import extab.spike.ExcelColumn;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RowDefinitionTest {

  @Test
  public void shouldGetRowDefinition(){
    class TestClass{
      @ExcelColumn(order = 1) private int columnOne;
      @ExcelColumn(order = 2) private int columnTwo;
      @ExcelColumn(order = 3) private int columnThree;
      @ExcelColumn(order = 4) private int columnFour;
    }

    RowDefinition rowDefinition = RowDefinition.rowDefinitionFor(TestClass.class) ;

    ExcelColumnType[] expectedRowDefinition = new ExcelColumnType[]{
      ExcelColumnType.STRING,
      ExcelColumnType.STRING,
      ExcelColumnType.STRING,
      ExcelColumnType.STRING
    } ;

    assertArrayEquals(rowDefinition.getRowDefinition(), expectedRowDefinition);

  }
}
