import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

public class SourceReader implements Iterator<String>{
  private final BufferedReader bufferedReader;
  private final CSVParser csvParser;
  private String nextToken;

  public SourceReader(InputStream inputStream, CSVParser parser) throws IOException {
    csvParser = parser;
    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    nextToken = bufferedReader.readLine();
  }

  public static Iterable<String> read(final InputStream inputStream) throws IOException {
    final SourceReader reader = new SourceReader(inputStream, new CSVParser());

    return new Iterable<String>() {
      @Override
      public Iterator<String> iterator() {
        return reader;
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
    return csvParser.parse(current);
  }
}
