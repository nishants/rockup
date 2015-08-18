import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SourceReaderTest {
  private InputStream source = new ByteArrayInputStream(
          String.format("%s%n%s%n%s%n",
              "2013-07-10 02:52:49,-44.490947,171.220966",
              "2013-07-10 02:52:49,-33.912167,151.215820",
              "2013-07-10 02:52:49,33.912167,-151.215820"
          ).getBytes())
      ;

  private List<String> expectedOutput = asList(
      "2013-07-10 02:52:49,-44.490947,171.220966,Pacific/Auckland,2013-07-10T14:52:49",
      "2013-07-10 02:52:49,-33.912167,151.215820,Australia/Sydney,2013-07-10T12:52:49",
      "2013-07-10 02:52:49,33.912167,-151.215820,Australia/Sydney,2013-07-10T12:52:49");

  @Test
  public void shouldReadSourceFile() throws Exception {
    List<String> acutalOutput = new ArrayList<>();
    for (String output : SourceReader.read(source)) {
      acutalOutput.add(output);
    }
    assertThat(acutalOutput, is(expectedOutput));
  }
}