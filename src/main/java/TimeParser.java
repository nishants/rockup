import rockup.Parser;

public class TimeParser implements Parser<String>{
  @Override
  public String parse(String token) {
    return token;
  }
}
