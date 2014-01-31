package geeksaint.point;

import extab.spike.AnnotationProcessor;
import extab.spike.ItemInstatiator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader<T> {
  private Workbook workBook;
  private ExcelRowReader<T> rowReader;

  protected ExcelReader(Workbook workBook,
                        ExcelRowReader<T> rowReader){
    this.workBook = workBook;
    this.rowReader = rowReader;
  }

  protected List<T> readDocument(){
    List<T> values = new ArrayList<T>();
    Sheet sheet = workBook.getSheetAt(0);
    Iterator<Row> rowIterator = sheet.rowIterator();
    while(rowIterator.hasNext()){
      values.add(rowReader.getData(rowIterator.next())) ;
    }
    return values;
  }

  public static <T> List<T> read(String fileName, Class<T> rowType) throws IOException {
    Workbook workBook = ExcelFileType.getFileType(fileName)
        .getWorkbook(new FileInputStream(fileName));
    RowDefinition rowDefinition =new RowDefinition(rowType, new AnnotationProcessor());
    ExcelRowReader <T> rowReader = new ExcelRowReader<T>(rowDefinition, new ItemInstatiator(rowType));

    return (new ExcelReader<T>(workBook, rowReader)).readDocument();
  }
}
