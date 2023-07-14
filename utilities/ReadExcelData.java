package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class ReadExcelData {

	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	String excelSheetPath;

	public ReadExcelData(String excelSheetPath) throws Exception {
		this.excelSheetPath = excelSheetPath;
		fis = new FileInputStream(excelSheetPath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
	}

	public String getCellData(String sheetName, int rows, int cols) {
		try {
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rows);
			cell = row.getCell(cols);

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return cell.getStringCellValue();
	}

	public int getRowCount(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		rowCount = rowCount + 1;
		return rowCount;
	}

	public int getColCount(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		return row.getLastCellNum();
	}

	public String getCellValueAsString(Cell cell) {
		String cellValue;
		cellValue = cell.getStringCellValue();
		return cellValue;
	}

	public void writeDataInCell(String sheetName, List<String> data) throws Exception {
		sheet = workbook.getSheet(sheetName);
		if (sheet.getLastRowNum() == 1)
			sheet.removeRow(sheet.getRow(1));
		Row row = sheet.createRow(1);
		for (int i = 0; i < data.size(); i++) {
			Cell cell = row.createCell(i);
			cell.setCellType(CellType.STRING);
			cell.setCellValue(data.get(i));
		}
		FileOutputStream fos = new FileOutputStream(excelSheetPath);
		workbook.write(fos);
		fos.close();
	}
}