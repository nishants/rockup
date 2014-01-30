package geeksaint.point;

import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExcelColumnTypeTest {
  @Test
  public void shouldReadStringValuesFromACell(){
    Cell cell = mock(Cell.class);

    when(cell.getCellType()).thenReturn(Cell.CELL_TYPE_STRING);
    when(cell.getStringCellValue()).thenReturn("cell-value");

    assertThat((String) ExcelColumnType.STRING.getCellValue(cell), is("cell-value"));
  }

}
