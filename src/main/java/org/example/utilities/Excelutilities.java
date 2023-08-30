package org.example.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Excelutilities {

    public FileInputStream fis;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public String path;

    public Excelutilities(String path){
        this.path = path;
    }

    public int getRowCount(String sheetName) throws IOException {
        fis=new FileInputStream(path);
        workbook=new XSSFWorkbook(fis);
        sheet=workbook.getSheet(sheetName);
        int rowCount=sheet.getPhysicalNumberOfRows();
        return rowCount;
    }
    public int getColumnCount(String sheetName) throws IOException {
        fis=new FileInputStream(path);
        workbook=new XSSFWorkbook(fis);
        sheet=workbook.getSheet(sheetName);
        int colCount=sheet.getRow(0).getPhysicalNumberOfCells();
        return colCount;
    }
    public String getCelldata(String sheetName,int rowNum,int colNum) throws IOException {
        fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            throw new IllegalArgumentException("Sheet with name " + sheetName + " not found");
        }

        row = sheet.getRow(rowNum);

        if (row == null) {
            throw new IllegalArgumentException("Row " + rowNum + " not found in sheet " + sheetName);
        }

        cell = row.getCell(colNum);

        if (cell == null) {
            throw new IllegalArgumentException("Cell at row " + rowNum + ", column " + colNum + " is empty");
        }

        // To format all the data
        DataFormatter formatter = new DataFormatter();
        String data = formatter.formatCellValue(cell);

        // Close resources
        workbook.close();
        fis.close();

        return data;
    }

}


