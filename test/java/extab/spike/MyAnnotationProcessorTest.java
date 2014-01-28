package extab.spike;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MyAnnotationProcessorTest {

  private MyAnnotationProcessor processor;

  @Before
  public void setUp() throws Exception {
    processor = new MyAnnotationProcessor();
  }

  @Test
  public void shouldReadName(){
    assertThat(processor.getAnnotationName(LineItem.class), is("LineItem"));
  }

  @Test
  public void shouldReadValue(){
    assertThat(processor.getAnnotationValue(LineItem.class), is("A line item"));
  }

}
