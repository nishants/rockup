package extab.spike;
import lombok.Getter;

//A class for test
@ExcelTable(name="LineItem", comments ="A line item")
public class LineItem {

  @Getter
  @ExcelColumn(order=1)
  private String fieldOne;

  @ExcelColumn(order=2)
  private void setBadField(String value){
    badField = value+"-updated";
  }

  @ExcelColumn(order=3)
  private void aBadMethod(String value, Object some){}

  @ExcelColumn(order=4)
  private void anotherBadMethod(String value, Object some){}

  private String badField;
}

