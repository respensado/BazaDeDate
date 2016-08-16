package md.convertit.bazaDeClienti.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;

import md.convertit.bazaDeClienti.domain.Client;
import md.convertit.bazaDeClienti.services.FileService;

public class ExcelFileService implements FileService {

	private static final Logger log = Logger.getLogger(ExcelFileService.class.getName());
	private File file;

	@Override
	public void saveAll(List<Client> clients, String path) throws Exception {
		file = new File(path);
		FileWriter fileWriter = new FileWriter(file);

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue(1);
		row.createCell(1).setCellValue(1.2);

		try {
			FileOutputStream out = new FileOutputStream(new File(path));
			workbook.write(out);
			out.close();
			System.out.println("Excel written successfully..");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// HSSFWorkbook
	}

	@Override
	public List<Client> readAll(String path) throws Exception {
		file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fis);
		HSSFSheet sheet = hssfWorkbook.createSheet();
		Iterator<Row> rowIterator = sheet.iterator();
		
		System.out.println("am deschis row iterator");

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> ceIterator = row.cellIterator();
			System.out.println("am deschis cell iterator");
			while (ceIterator.hasNext()) {
				Cell cell = ceIterator.next();
				//switch (cell.getCellType()) {
				//case Cell.CELL_TYPE_STRING:
					System.out.println(cell.getStringCellValue());
					System.out.println("************");
					//break;

				}

			}

			
	
		return null;
	}
}
