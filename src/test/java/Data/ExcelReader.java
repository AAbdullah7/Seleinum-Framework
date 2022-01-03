package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	static FileInputStream Fis = null ;

	public FileInputStream getFileInputStream()
	{
		String filepath = System.getProperty("user.dir")+"/src/test/java/Data/UserData.xlsx";
		File srcfile = new File(filepath);
		try 
		{

			Fis = new FileInputStream(srcfile);

		}
		catch (FileNotFoundException e) 
		{

			System.out.println("File Not Found :"+ e.getMessage());
			System.exit(0);
		}
		return Fis;
	}

	public Object[][] getExcelData() throws IOException
	{
		Fis = getFileInputStream();
		XSSFWorkbook WB = new XSSFWorkbook(Fis);
		XSSFSheet sheet = WB.getSheetAt(0);
		
		int TotalnNumberOfRow = (sheet.getLastRowNum()+1);
		int TotalNumberOfCols = 4;

		String [][] arrayExcelData = new String [TotalnNumberOfRow][TotalNumberOfCols];

		for (int i = 0; i < TotalnNumberOfRow ; i++) 
		{
			for (int j = 0; j < TotalNumberOfCols ; j++) 
			{
				XSSFRow row = sheet.getRow(i);
				arrayExcelData [i][j] = row.getCell(j).toString();
			}
		}

		WB.close();
		return arrayExcelData;

	}

}
