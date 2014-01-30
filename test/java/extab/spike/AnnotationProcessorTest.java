package extab.spike;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AnnotationProcessorTest {

  private AnnotationProcessor processor;

  @Before
  public void setUp() throws Exception {
    processor = new AnnotationProcessor();
  }

  @Test
  public void shouldReadName(){
    assertThat(processor.getAnnotationName(LineItem.class), is("LineItem"));
  }

  @Test
  public void shouldReadValue(){
    assertThat(processor.getAnnotationValue(LineItem.class), is("A line item"));
  }

  @Test
  public void shouldReadFieldAnnotations() throws NoSuchFieldException {
    assertThat(processor.getColumnAnnotationOrder(LineItem.class, "programId"), is(1));
    assertThat(processor.getColumnAnnotationValue(LineItem.class, "programId"), is("program-id"));
  }
}
