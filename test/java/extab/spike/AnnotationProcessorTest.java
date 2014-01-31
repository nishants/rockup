package extab.spike;

import extab.spike.exceptions.InvalidPointAnnotationException;
import extab.spike.exceptions.PointAnnotationNotFoundException;
import geeksaint.point.ExcelColumnType;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.omg.CORBA.DynAnyPackage.Invalid;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class AnnotationProcessorTest {

  private AnnotationProcessor processor;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() throws Exception {
    processor = new AnnotationProcessor();
  }

  @Test
  public void shouldThrowExceptionIfTargetClassNotAnnotatedForName(){
    thrown.expect(PointAnnotationNotFoundException.class);
    processor.getTableName(java.lang.String.class);
  }

  @Test
  public void shouldReadName(){
    assertThat(processor.getTableName(LineItem.class), is("LineItem"));
  }

  @Test
  public void shouldReadComments(){
    assertThat(processor.getTableComments(LineItem.class), is("A line item"));
  }

  @Test
  public void shouldReadFieldAnnotations() throws NoSuchFieldException {
    assertThat(processor.getFieldColumnOrder(LineItem.class, "fieldOne"), is(1));
    assertThat(processor.getFieldColumnType(LineItem.class, "fieldOne"), is(ExcelColumnType.STRING));
  }
  @Test
  public void shouldReadMethodAnnotations() throws NoSuchFieldException {
    assertThat(processor.getMethodColumnOrder(LineItem.class, "setBadField"), is(2));
    assertThat(processor.getMethodColumnType(LineItem.class, "setBadField"), is(ExcelColumnType.STRING));
  }

  @Test
  public void shouldThrowExceptionIfTargetMethodDoesNotHaveOnlyOneStringArgument(){
    thrown.expect(InvalidPointAnnotationException.class);
    processor.getMethodColumnOrder(LineItem.class, "aBadMethod");
  }

  @Test
  public void shouldThrowExceptionIfTargetMethodDoesNotHaveAStringArgument(){
    thrown.expect(InvalidPointAnnotationException.class);
    processor.getMethodColumnOrder(LineItem.class, "anotherBadMethod");
  }

  @Test
  public void shouldReturnNullIfTheFieldIsNotAnnonated() throws NoSuchFieldException {
    assertThat(processor.getFieldColumnOrder(LineItem.class, "badField"), is(nullValue()));
    assertThat(processor.getFieldColumnType(LineItem.class, "badField"), is(nullValue()));
  }
}
