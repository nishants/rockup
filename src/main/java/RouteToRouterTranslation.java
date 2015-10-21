import java.io.*;

public class RouteToRouterTranslation {

  public  static void main(String...hh) throws IOException {
    String file = "/Users/dawn/Documents/projects/tookitaki/led/src/app/index.js";
    String output = "/Users/dawn/Documents/converted.js";
    transform(file, output);
  }

  public static void transform(String fileName, String outputFileName) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

    String line = reader.readLine();
    while(line != null){
      writer.write(line);
      writer.newLine();
      line = reader.readLine();
    }
    reader.close();
    writer.close();
  }
}
