import rockup.Parser;

public class CSVParser {

  private final Parser[] columnParsers;

  public CSVParser(Parser...columnParsers) {
    this.columnParsers = columnParsers;
  }

  public String parse(String inputCSV) {
    String[] tokens = inputCSV.split(",");
    StringBuffer result = new StringBuffer();
    for(int i =0; i<tokens.length; i++){
      result.append(columnParsers[i].parse(tokens[i]));
    }
    return result.toString();
  }
}
