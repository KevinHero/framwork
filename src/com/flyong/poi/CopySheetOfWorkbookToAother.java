package com.flyong.poi;

import org.apache.poi.hssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CopySheetOfWorkbookToAother {
	public static void main(String[] args) throws IOException {
		String xlsFilePath = "e:\\excel\\Template.xls";
		t();

	}

	public static void getStyle() {
		InputStream is = null;
		OutputStream os = null;

		try {
			is = new FileInputStream("e:\\excel\\Template.xls");
			os = new FileOutputStream("e:\\excel\\out.xls");
			// ��ģ���ļ�
			HSSFWorkbook tempWorkBook = new HSSFWorkbook(is);
			// ���㲢�������浽aimworkbook�У� ���������棬��֤aim�����޸�
			HSSFSheet sheet1 = tempWorkBook.getSheetAt(0);
			HSSFCellStyle style = sheet1.getRow(8).getCell(2).getCellStyle();
			HSSFSheet aimSheet = tempWorkBook.createSheet("fd_test");

			HSSFCell cell = aimSheet.createRow(8).createCell(2);
			cell.setCellStyle(style);
			cell.setCellValue("aaaa");

			tempWorkBook.removeSheetAt(0);
			tempWorkBook.removeSheetAt(0);
			tempWorkBook.removeSheetAt(0);
			tempWorkBook.write(os);
			os.close();
			is.close();
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
		}
	}

	public static HSSFWorkbook copySheet(HSSFWorkbook wb) {

		HSSFSheet tempSheet = null;
		int size = wb.getNumberOfSheets();
		List<HSSFSheet> sheetList = new ArrayList<HSSFSheet>();
		for (int i = 0; i < size; i++) {
			sheetList.add(wb.getSheetAt(i));
		}

		wb.createSheet("copy");

		for (int k = 0; k < sheetList.size(); k++) {
			tempSheet = sheetList.get(3);
			for (Iterator rit = tempSheet.rowIterator(); rit.hasNext();) {
				HSSFRow row = (HSSFRow) rit.next();
				for (Iterator cit = row.cellIterator(); cit.hasNext();) {
					HSSFCell cell = (HSSFCell) cit.next();
					HSSFCellStyle style = cell.getCellStyle();

					// HSSFCellStyle style =
					// sheet1.getRow(8).getCell(2).getCellStyle();
					// HSSFCell cell = aimSheet.createRow(8).createCell(2);
					int hang = row.getRowNum();
					int lie = cell.getCellNum();
					System.out.println(hang + ":" + lie);
					HSSFCell outcell = wb.getSheetAt(4).createRow(hang)
							.createCell(lie);
					outcell.setCellStyle(style);
					outcell.setCellValue("test" + hang + ":" + lie);
				}
			}

		}

		return wb;
	}

	public static HSSFWorkbook getWorkbook(String xlsFilePath) {

		InputStream is = null;
		HSSFWorkbook wb = null;
		try {
			is = new FileInputStream(xlsFilePath);
			try {
				wb = new HSSFWorkbook(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return wb;
	}

	public static void t() {
		String filepath = "e:\\excel\\Template.xls";
		HSSFWorkbook hssfworkbook = getWorkbook(filepath);
		HSSFSheet hssfsheet = hssfworkbook.getSheetAt(0);
		
		hssfworkbook.cloneSheet(0);
		int rowNum = hssfsheet.getLastRowNum();
		for (int k = 0; k <= rowNum; k++) {
			HSSFRow hssfrow = hssfsheet.getRow(k);
			for (int j = 0; j < hssfrow.getLastCellNum(); j++) {
				HSSFCell hssfcell = hssfrow.getCell((short) j);
				int cType = hssfcell.getCellType();
				if (cType == HSSFCell.CELL_TYPE_BOOLEAN) {
					System.out.println(hssfcell.getBooleanCellValue());
				}
				if (cType == HSSFCell.CELL_TYPE_ERROR) {
					System.out.println(hssfcell.getErrorCellValue());
				}
				if (cType == HSSFCell.CELL_TYPE_FORMULA) {
					System.out.println(hssfcell.getCellFormula());

				}
				if (cType == HSSFCell.CELL_TYPE_NUMERIC) {
					System.out.println(hssfcell.getNumericCellValue());
				}
				if (cType == HSSFCell.CELL_TYPE_STRING) {
					System.out.println(hssfcell.getStringCellValue());
				}
			}
		}
	}
}