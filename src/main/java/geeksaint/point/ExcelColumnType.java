package geeksaint.point;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;

import static java.lang.String.format;

public enum ExcelColumnType {
  STRING {
    @Override
    public Object getCellValue(Cell cell) {
      if (cell == null) throw new IllegalArgumentException(format("Cell was null"));

      if(cell.getCellType() == Cell.CELL_TYPE_BLANK) return "";
      if (cell.getCellType() == Cell.CELL_TYPE_STRING) return cell.getStringCellValue();
      if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC && isDate(cell))  return  cell.getDateCellValue().toString();
      if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) return getNumberAsString(cell);

      throw new UnsupportedOperationException(
          format("Cannot read string value form cell at(%d,%d) of type %d",cell.getRowIndex(),
          cell.getColumnIndex(), cell.getCellType()));
    }

    private boolean isDate(Cell cell) {
      return HSSFDateUtil.isCellDateFormatted(cell);
    }

    private String getNumberAsString(Cell cell) {
      String value = Double.valueOf(cell.getNumericCellValue()).toString();
      return value.replaceFirst("\\.0*$","");
    }
  };

  public abstract Object getCellValue(Cell cell);
}
