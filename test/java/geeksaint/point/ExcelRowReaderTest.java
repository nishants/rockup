package geeksaint.point;

import extab.spike.ItemInstatiator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExcelRowReaderTest {

  @Test
  public void shouldReturnRowData(){
    ExcelColumnType columnOneType = mock(ExcelColumnType.class);
    ExcelColumnType columnTwoType = mock(ExcelColumnType.class);
    ExcelColumnType columnThreeType = mock(ExcelColumnType.class);

    ExcelColumnType[] rowDefinitionArray = new ExcelColumnType[]{columnOneType, columnTwoType, columnThreeType};
    RowDefinition rowDefinition = mock(RowDefinition.class);
    when(rowDefinition.getRowDefinition()).thenReturn(rowDefinitionArray);

    Row row = mock(Row.class);
    Cell cellOne = mock(Cell.class) ;
    Cell cellTwo = mock(Cell.class) ;
    Cell cellThree = mock(Cell.class) ;

    when(row.getCell(0)).thenReturn(cellOne);
    when(row.getCell(1)).thenReturn(cellTwo);
    when(row.getCell(2)).thenReturn(cellThree);

    when(columnOneType.getCellValue(cellOne)).thenReturn("one");
    when(columnTwoType.getCellValue(cellTwo)).thenReturn("two");
    when(columnThreeType.getCellValue(cellThree)).thenReturn("three");

    ItemInstatiator instatiator = mock(ItemInstatiator.class);
    Object object = new Object();
    when(instatiator.createItem(asList("one", "two", "three"))).thenReturn(object);

    ExcelRowReader reader = new ExcelRowReader(row, rowDefinition, instatiator);
    assertThat(reader.getData(), is(object));
  }
}
