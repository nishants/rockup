import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class TestMarathon {
  public static void main(String... args) {
    assertThat(collegecomparison(
            new int[]{1, 2, 3, -4},
            new int[]{1, 2, 3, 4}),
        is("Invalid"));

    assertThat(collegecomparison(
            new int[]{1, 2, 3, 4},
            new int[]{1, 2, 3, 4}),
        is("Equal"));

    assertThat(collegecomparison(
            new int[]{1, 2, 3, 3},
            new int[]{1, 2, 3, 4}),
        is("Unequal"));

  }

  public static String collegecomparison(int[] input1, int[] input2) {
    int sum1 = sumOf(input1),
        sum2 = sumOf(input2);

    boolean valid = sum1 != -1 && sum2 != -1,
            equal = sum1 == sum2;

    return valid ? (equal ? "Equal" : "Unequal") : "Invalid";
  }

  private static int sumOf(int... arr) {
    int result = 0;
    for (int value : arr) {
      if (value < 0) {
        return -1;
      }
      result += value;
    }
    return result;
  }
}