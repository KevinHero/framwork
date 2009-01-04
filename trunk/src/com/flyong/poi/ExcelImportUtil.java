package com.flyong.poi;

//import  poi-3.2-FINAL-20081019.jar and poi-contrib-3.0.2-FINAL-20080204.jar is ok


/*import java.util.*;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;




public class ExcelImportUtil {
	private SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private String[][] dataArray = null;
	private int rowSize = 0;
	private int colSize = 0;
	private List errors = new ArrayList();

	public String getStringValue(int rowIndex, int colIndex) {
		if ((rowIndex >= rowSize) || (colIndex >= colSize) || (rowIndex < 0)
				|| (colIndex < 0))
			throw new RuntimeException(
					"Error:the  index parameters is invalid!!");
		return dataArray[rowIndex][colIndex];
	}

	public int getRowSize() {
		return rowSize;
	}

	public int getColSize() {
		return colSize;
	}

	public void importExcelData(String fileName) {
		setAllDefault();
		FileInputStream fs = null;
		HSSFWorkbook workbook = null;

		HSSFCell cell = null;
		try {
			fs = new FileInputStream(fileName);
			workbook = new HSSFWorkbook(fs);
			int numOfSheets = workbook.getNumberOfSheets();
			HSSFSheet aSheet = workbook.getSheetAt(0);
			for (int numSheets = 0; numSheets < numOfSheets; numSheets++) {
				if (null == workbook.getSheetAt(numSheets))
					continue;
				HSSFRow aRow = aSheet.getRow(0);
				if (aRow == null)
					throw new RuntimeException(
							"Fatal error:the first row is null.");
				boolean notValid = isNullOrEmptyOrFormatError(aRow
						.getCell((short) colSize));
				while (!notValid) {
					colSize++;
					notValid = isNullOrEmptyOrFormatError(aRow
							.getCell((short) colSize));

				}
				rowSize = (short) (aSheet.getLastRowNum() + 1);

				dataArray = new String[rowSize][colSize];
				for (short i = 0; i < rowSize; i++) {
					aRow = aSheet.getRow(i);
					if (aRow == null)
						continue;
					for (short j = 0; j < colSize; j++) {
						cell = aRow.getCell(j);

						if (cell == null)
							continue;
						dataArray[i][j] = getStringValue(cell, (int) i, (int) j);
					}
				}
				if (colSize > 1) {
					for (int k = 0; k < rowSize; k++) {
						if ((dataArray[k][0] == null)
								&& (dataArray[k][1] == null)) {
							rowSize = k;
							break;
						}
					}
				}

				break;
			}

		} catch (Exception e) {
			errors.add("Fatal error:" + e.toString());
			setAllDefault();
			e.printStackTrace();
			return;
		} finally {
			try {
				if (fs != null) {
					fs.close();
					fs = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void outPutAllData() {
		if (dataArray == null) {
			System.out.print("The array is null.");
			return;
		}
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				if (j == 0)
					System.out.println();
				System.out.print("  " + dataArray[i][j]);
			}
		}
	}

	public void outPutErrors() {
		for (Iterator it = errors.iterator(); it.hasNext();) {
			System.out.println((String) it.next());
		}
	}

	public List getErrors() {
		return errors;
	}

	private void setAllDefault() {
		dataArray = null;
		rowSize = 0;
		colSize = 0;
		errors.clear();
	}

	private boolean isNullOrEmptyOrFormatError(HSSFCell cell) {
		try {
			if (cell == null)
				return true;
			int cellType = cell.getCellType();
			if (cellType == HSSFCell.CELL_TYPE_NUMERIC)
				return false;
			if (cellType == HSSFCell.CELL_TYPE_STRING) {
				if (!"".equals(cell.getStringCellValue().toString().trim()))
					return false;
				else
					return true;
			}
			return true;

		} catch (Exception e) {
			return true;
		}
	}

	private String getStringValue(HSSFCell cell, int i, int j) {
		try {

			if (cell == null)
				return null;
			int cellType = cell.getCellType();
			if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
				if (HSSFDateUtil.isCellDateFormatted(cell))
					return dateFormat.format((cell.getDateCellValue()));
				else {

					return String.valueOf((long) cell.getNumericCellValue());
				}
			}
			if (cellType == HSSFCell.CELL_TYPE_STRING)
				return cell.getStringCellValue().toString().trim();
			if (cellType == HSSFCell.CELL_TYPE_BLANK)
				return null;

			return null;
		} catch (Exception e) {
			errors.add("Cell format error on position:(��" + (i + 1) + "��,��"
					+ (j + 1) + "��)");
			return null;
		}
	}

	public static void main(String[] args) {
		try {

			ExcelImportUtil excelImport = new ExcelImportUtil();
			excelImport.importExcelData("E:\\excel\\SeperateMediaplan+good.xls");
			excelImport.outPutAllData();
			System.out.println();
			excelImport.outPutErrors();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}*/
