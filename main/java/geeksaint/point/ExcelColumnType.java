package geeksaint.point;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;

import java.math.BigDecimal;

import static java.lang.String.format;

public enum ExcelColumnType {
  STRING {
    @Override
    public String getCellValue(Cell cell) {
      if (cell == null) throw new IllegalArgumentException(format("Cell was null at (%d,%d)",
          cell.getRowIndex(), cell.getColumnIndex()));

      if (cell.getCellType() == Cell.CELL_TYPE_STRING) return cell.getStringCellValue();
      if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) return getNumberAsString(cell);
      if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC && cellDateFormatted(cell))  return  cell.getDateCellValue().toString();

      throw new UnsupportedOperationException(format("Cell type not supported for %d", cell.getCellType()));
    }

    private boolean cellDateFormatted(Cell cell) {
      return HSSFDateUtil.isCellDateFormatted(cell);
    }

    private String getNumberAsString(Cell cell) {
      return Double.valueOf(cell.getNumericCellValue()).toString();
    }
  };

  public abstract Object getCellValue(Cell cell);
}
