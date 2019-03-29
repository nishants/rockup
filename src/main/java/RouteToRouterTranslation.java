import java.io.*;

public class RouteToRouterTranslation {

  public  static void main(String...hh) throws IOException {
    String file = "/Users/dawn/Documents/projects/tookitaki/led/src/app/index.js";
    String output = "/Users/dawn/Documents/converted.js";
    transform(file, output);
  }

  private static boolean defitnesRoute(String line){

    return line.indexOf(".when('") != -1;
  }

  public static void transform(String fileName, String outputFileName) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

    String line = reader.readLine();
    while(line != null){
      writer.write(defitnesRoute(line) ? toRouter(line) : line);
      writer.newLine();
      line = reader.readLine();
    }
    reader.close();
    writer.close();
  }

  private static String toRouter(String line) {
    String
        tokens[]  = line.split("'"),
        url       = tokens[1].replaceFirst("/", ""),
        stateName     = url.replaceAll("/", "-");

    return ".state('" + stateName +"',{url: '" + url+ "',";
  }
}
