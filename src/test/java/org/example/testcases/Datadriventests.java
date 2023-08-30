package org.example.testcases;

import org.example.utilities.Excelutilities;
import org.testng.annotations.Test;

import java.io.IOException;

public class Datadriventests {
    public String[][] getalldata() throws Exception {
        String path="C:\\Users\\DELL AIO\\IdeaProjects\\SeleniumDemos\\testdata\\testdata.xlsx";
        Excelutilities e=new Excelutilities(path);
        int rowcount=e.getRowCount("Sheet1");
        int colcount=e.getColumnCount("Sheet1");
        String[][] data=new String[rowcount][colcount];
        for(int i=1;i<=rowcount;i++){
            for(int j=0;j<colcount;j++){
                data[i-1][j]=e.getCelldata("Sheet1", i, j);
            }
        }
        return data;
    }

    @Test
    public void test1() throws Exception {
        String path="C:\\Users\\DELL AIO\\IdeaProjects\\SeleniumDemos\\testdata\\testdata.xlsx";
        Excelutilities e=new Excelutilities(path);
        System.out.println("Total number of rows: "+e.getRowCount("Sheet1"));
        System.out.println("Total number of columns: "+e.getColumnCount("Sheet1"));

    }
}
