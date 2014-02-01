package geeksaint.point;

import extab.spike.ExcelColumn;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LibTest {
  private final String allStringsPersonFile = "/data/Person.xls";
  private final String personsFileWithDateAndNumberFormats = "/data/PersonWithDateAndNumberFormat.xls";
  private Person personOne;
  private Person personTwo;
  private Person personThree;

  @NoArgsConstructor
  @AllArgsConstructor
  @EqualsAndHashCode
  public static class Person{
    @ExcelColumn(order=1) private String name;
    @ExcelColumn(order=2) private String age;
    @ExcelColumn(order=3) private String birthDate;
  }

  @Before
  public void setUp() throws Exception {
    personOne = new Person("one-one", "33", "3rd Jan 1987");
    personTwo = new Person("two-one", "44", "3rd Jan 1977");
    personThree = new Person("three-one", "55", "3rd Jan 1967");
  }

  @Test
  public void shouldParseAnExcelFileIntoModel() throws IOException {
    InputStream inputStream = getClass().getResourceAsStream(allStringsPersonFile);
    List<Person> items = asList(personOne, personTwo, personThree);

    List<Person> parsed = ExcelReader.readXls(inputStream, Person.class);

    assertThat(parsed, is(items));
  }

  @Test
  public void shouldParseAFormattedColumn() throws IOException {
    Person expected = new Person("Mr Singh", "27", "Sat Jul 21 00:00:00 IST 1990");

    InputStream inputStream = getClass().getResourceAsStream(personsFileWithDateAndNumberFormats);
    List<Person> parsed = ExcelReader.readXls(inputStream, Person.class);

    assertThat(parsed.get(0), is(expected));
  }

}
