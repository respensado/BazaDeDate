package md.convertit.bazaDeClienti.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import md.convertit.bazaDeClienti.domain.Client;
import md.convertit.bazaDeClienti.services.FileService;

public class ExcelFileService implements FileService {
	private static final Logger log = Logger.getLogger(ExcelFileService.class.getName());
	private File file;

	private Object getCellValue(Cell nextCell) {
		switch (nextCell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return nextCell.getStringCellValue();

		case Cell.CELL_TYPE_BOOLEAN:
			return nextCell.getBooleanCellValue();

		case Cell.CELL_TYPE_NUMERIC:
			return nextCell.getNumericCellValue();
		}
		return nextCell;
	}

	@Override
	public void saveAll(List<Client> clients, String path) throws Exception {
		file = new File(path);
		// FileWriter fileWriter = new FileWriter(file);
		System.out.println(clients);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();

		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Nume");
		cell = row.createCell(1);
		cell.setCellValue("Is Kids");
		cell = row.createCell(2);
		cell.setCellValue("Phone Number");
		cell = row.createCell(3);
		cell.setCellValue("Email");
		cell = row.createCell(4);
		cell.setCellValue("Address");
		
		for (int i = 0; i < clients.size(); i++) {
			Client client = clients.get(i);
			row = sheet.createRow(i + 1);
			cell = row.createCell(0);
			cell.setCellValue(client.getName());
			cell = row.createCell(1);
			cell.setCellValue(client.isKids());
			cell = row.createCell(2);
			cell.setCellValue(client.getPhoneNumber());
			cell = row.createCell(3);
			cell.setCellValue(client.getEmail());
			cell = row.createCell(4);
			cell.setCellValue(client.getAddrees());
			

		}

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
		List<Client> clList = new ArrayList<>();
		FileInputStream inputStream = new FileInputStream(new File(path));

		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		HSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = sheet.iterator();
		System.out.println("am deschis row iterator");
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if(nextRow.getRowNum()>0){
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			Client client = new Client();

			System.out.println("am deschis cell iterator");
			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();

				switch (columnIndex) {

				case 0:
					System.out.println(getCellValue(nextCell));
					client.setName((String) getCellValue(nextCell));

					// System.out.print(cell.getStringCellValue());
					break;
				case 1:
					client.setKids((boolean) getCellValue(nextCell));
					break;
				case 2:
					client.setPhoneNumber((int) Math.round((double) getCellValue(nextCell)));
					break;
					
					case 3:
						client.setEmail((String) getCellValue(nextCell));
					break;
					case 4: 
						client.setAddrees((String) getCellValue(nextCell));
					break;
					
					
				}
				System.out.print(" - ");
			}
			clList.add(client);
			}
		}

		inputStream.close();

		return clList;
	}
}
