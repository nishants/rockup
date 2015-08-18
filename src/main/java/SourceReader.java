import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

import static java.util.Arrays.asList;

public class SourceReader implements Iterator<String>{
  private final BufferedReader bufferedReader;
  private String nextToken;

  public SourceReader(InputStream inputStream) throws IOException {
    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    nextToken = bufferedReader.readLine();
  }

  public static Iterable<String> read(final InputStream inputStream) {
    return new Iterable<String>() {
      @Override
      public Iterator<String> iterator() {
        try {
          return new SourceReader(inputStream);
        } catch (IOException e) {
          throw new IllegalArgumentException(e);
        }
      }
    };
  }

  @Override
  public boolean hasNext() {
    return nextToken != null;
  }

  @Override
  public String next() {
    String current = nextToken;
    try {
      nextToken = bufferedReader.readLine();
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
    return current;
  }
}
