package geeksaint.point;

import extab.spike.ItemInstatiator;
import org.apache.poi.ss.usermodel.Row;

import java.util.ArrayList;
import java.util.List;

public class ExcelRowReader {
  private final Row row;
  private final Class claz;
  private final ExcelColumnType[] rowDefinition;
  private final ItemInstatiator instatiator;

  protected ExcelRowReader(Row row, RowDefinition rowDefinition, ItemInstatiator instatiator){
    this.rowDefinition = rowDefinition.getRowDefinition();
    this.claz = rowDefinition.getRowType();
    this.row = row;
    this.instatiator = instatiator;
  }

  public Object getData(){
    return instatiator.createItem(getRowData());
  }

  private List<String> getRowData() {
    List<String> values = new ArrayList<String>();
    for(int i =0; i<rowDefinition.length; i++){
      values.add(rowDefinition[i].getCellValue(row.getCell(i)).toString());
    }
    return values;
  }
}
