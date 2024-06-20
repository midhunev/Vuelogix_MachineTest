package vimeoUtil;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VimeoUilities {
	
	public static String getCellValue(String xl, String sheet, int row, int col)
	{
		try
		{
			File f = new File(xl);
			FileInputStream fi = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			XSSFCell cell = wb.getSheet(sheet).getRow(row).getCell(col);
			if(cell.getCellType()==CellType.STRING)
			{
				return cell.getStringCellValue();
			}
			else
			{
				return cell.getRawValue();
			}
		}
		catch(Exception e)
		{
			return "";
		}
		
	}
	
	public static int getRowCount(String xl, String sheet)
	{
		try
		{
			File f = new File(xl);
			FileInputStream fi = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			return wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			return 0;
		}
		
	}
	
	public static void fileUpload(String f) throws AWTException, InterruptedException
	{
		StringSelection strSelection =  new StringSelection(f);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
		
		Robot robot = new Robot();
		robot.delay(4000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);	
	}

}
