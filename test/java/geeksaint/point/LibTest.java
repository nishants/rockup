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

  private String validPersonFile;

  @NoArgsConstructor
  @AllArgsConstructor
  @EqualsAndHashCode
  public static class Person{
    @ExcelColumn(order=1) private String columnOne;
    @ExcelColumn(order=2) private String columnTwo;
    @ExcelColumn(order=3) private String columnThree;
  }

  @Before
  public void setUp() throws Exception {
    validPersonFile = "/data/Person.xls";
  }

  @Test
  public void shouldParseAnExcelFileIntoModel() throws IOException {
    Person personOne = new Person("one-one", "one-two", "one-three");
    Person personTwo = new Person("two-one", "two-two", "two-three");
    Person personThree = new Person("three-one", "three-two", "three-three");
    InputStream inputStream = getClass().(validPersonFile);

    List<Person> expected = asList(personOne, personTwo, personThree);

    List<Person> parsed = ExcelReader.readXls(inputStream, Person.class);

    assertThat(parsed, is(expected));
  }
}
