package geeksaint.point;

import extab.spike.ItemInstatiator;
import org.apache.poi.ss.usermodel.Row;

import java.util.ArrayList;
import java.util.List;

public class ExcelRowReader<T> {
  private final Class<T> claz;
  private final ExcelColumnType[] rowDefinition;
  private final ItemInstatiator instatiator;

  protected ExcelRowReader(RowDefinition rowDefinition, ItemInstatiator instatiator){
    this.rowDefinition = rowDefinition.getRowDefinition();
    this.claz = rowDefinition.getRowType();
    this.instatiator = instatiator;
  }

  public T getData(Row row){
    return (T)instatiator.createItem(getRowData(row));
  }

  private List<String> getRowData(Row row) {
    List<String> values = new ArrayList<String>();
    for(int i =0; i<rowDefinition.length; i++){
      values.add(rowDefinition[i].getCellValue(row.getCell(i)).toString());
    }
    return values;
  }
}
