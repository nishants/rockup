package geeksaint.point;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader<T> {
  private Workbook workBook;
  private Class<T> rowType;

  private ExcelReader(String fileName, Class<T> rowType) throws FileNotFoundException, IOException {
    this.workBook = ExcelFileType.getFileType(fileName)
        .getWorkbook(new FileInputStream(fileName));
    this.rowType = rowType;
  }

  private List<T> readDocument(){
    // get sheet
    // for each row in the sheet
    // invoke row reader - add the result in the list
//    Object obj = null;
//    List<T> result = new ArrayList<T>();
//    result.add((T)obj);

    return null;
  }

  public static <T> ExcelReader getExcelReader(String fileName, Class<T> rowType) throws IOException {
    return new ExcelReader(fileName, rowType);
  }


}
