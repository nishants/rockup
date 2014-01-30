package extab.spike;
import lombok.Getter;

@Getter
@ExcelTable(name="LineItem", value="A line item")
public class LineItem {

  @ExcelColumn(order=1, value="program-id")
  private String programId;
}

