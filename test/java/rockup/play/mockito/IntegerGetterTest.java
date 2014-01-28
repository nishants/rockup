package rockup.play.mockito;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IntegerGetterTest {

  @Test
  public void shouldExecuteAnswer(){
    final List<Integer> params = new ArrayList<Integer>();
    IntegerGetter integerGetter = mock(IntegerGetter.class);

    Answer <Integer> answer = new Answer<Integer>() {
      @Override
      public Integer answer(InvocationOnMock invocation) throws Throwable {
        params.add((Integer)invocation.getArguments()[0]);
        System.out.println((Integer)invocation.getArguments()[0]);
        return 101;
      }
    };

    when(integerGetter.getInt(2)).thenAnswer(answer);

    assertThat(integerGetter.getInt(2), is(101));
    assertThat(params, hasItems(2));
  }
}
