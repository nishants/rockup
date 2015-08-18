import java.io.InputStream;

import static java.util.Arrays.asList;

public class SourceReader{
  public SourceReader(InputStream inputStream) {

  }

  public static Iterable<String> read(InputStream inputStream) {
    return asList(
        "2013-07-10 02:52:49,-44.490947,171.220966,Pacific/Auckland,2013-07-10T14:52:49",
        "2013-07-10 02:52:49,-33.912167,151.215820,Australia/Sydney,2013-07-10T12:52:49",
        "2013-07-10 02:52:49,33.912167,-151.215820,Australia/Sydney,2013-07-10T12:52:49");
  }
}
