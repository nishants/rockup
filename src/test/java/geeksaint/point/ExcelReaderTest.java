package geeksaint.point;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.util.Iterator;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExcelReaderTest {

  @Test
  public void shouldReadADocument(){
    class Item{}

    Workbook workbook = mock(Workbook.class);
    Sheet sheet = mock(Sheet.class);
    Row rowOne = mock(Row.class);
    Row rowTwo = mock(Row.class);

    Iterator<Row> rowIterator = asList(rowOne, rowTwo).iterator();

    when(workbook.getSheetAt(0)).thenReturn(sheet);
    when(sheet.rowIterator()).thenReturn(rowIterator);

    ExcelRowReader<Item> rowReader = mock(ExcelRowReader.class);
    Item itemOne = new Item();
    Item itemTwo = new Item();

    when(rowReader.getData(rowOne)).thenReturn(itemOne);
    when(rowReader.getData(rowTwo)).thenReturn(itemTwo);

    ExcelReader<Item> excelReader = new ExcelReader<Item>(workbook, rowReader);

    assertThat(excelReader.readDocument(), is(asList(itemOne, itemTwo)));
  }

}
