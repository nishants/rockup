package extab.spike;

@MyAnnotation(name="LineItem", value="A line item")
public class LineItem {

  @FieldAnnotation(order=1, value="program-id")
  private String programId;
}

