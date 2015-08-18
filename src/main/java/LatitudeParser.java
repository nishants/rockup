import rockup.Parser;

public class LatitudeParser implements Parser<String> {
  @Override
  public String parse(String token) {
    return token;
  }
}
