public class CSVParser {

  public String parse(String csv) {
    String
        tokens[]  = csv.split(","),
        time      = tokens[0],
        latitude  = tokens[1],
        longitude = tokens[2];

    return csv  +
            "," + timezoneOf(latitude, longitude) +
            "," + local(time);
  }

  private String local(String time) {
    return null;
  }

  private String timezoneOf(String latitude, String longitude) {
    //TODO  figure out
     return "Australia/Sydney";
  }
}
