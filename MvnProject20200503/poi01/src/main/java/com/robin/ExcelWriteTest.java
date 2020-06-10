package com.robin;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description
 * @Author Robin
 * @Date 2020/5/3 18:44
 */
public class ExcelWriteTest {

    String PATH = "D:\\Workspaces\\IDEA171001\\MvnProject20200503\\poi01\\";

    @Test
    public void testExcelWrite03() throws IOException {
        //创建工作簿 03
        Workbook workbook = new HSSFWorkbook();
        //创建工作表
        Sheet sheet = workbook.createSheet("robinfirst");
        //创建行   //第一行
        Row row1 = sheet.createRow(0);
        //创建单元格
        //(1,1)
        Cell cell1 = row1.createCell(0);
        cell1.setCellValue("今日财务进账");
        //(1,2)
        Cell cell2 = row1.createCell(1);
        cell2.setCellValue(20202020);

        //第二行
        Row row2 = sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("统计时间：");
        Cell cell22 = row2.createCell(1);
        String time = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell22.setCellValue(time);


        //生成一直给你表，本质就是操作IO
        //注意03版本，是依据xxx.xls命名的
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "Robin的第一张表03.xls");
        //数据表，写表
        workbook.write(fileOutputStream);
        //关闭流
        fileOutputStream.close();

        System.out.println("03版本Excel文件生成完毕，注意查看！");
    }

    @Test
    public void testExcelWrite07() throws IOException {
        //创建工作簿 07
        Workbook workbook = new XSSFWorkbook();
        //创建工作表
        Sheet sheet = workbook.createSheet("robinsecond");
        //创建行   //第一行
        Row row1 = sheet.createRow(0);
        //创建单元格
        //(1,1)
        Cell cell1 = row1.createCell(0);
        cell1.setCellValue("今日财务进账");
        //(1,2)
        Cell cell2 = row1.createCell(1);
        cell2.setCellValue(20202020);

        //第二行
        Row row2 = sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("统计时间：");
        Cell cell22 = row2.createCell(1);
        String time = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell22.setCellValue(time);


        //生成一直给你表，本质就是操作IO
        //注意07版本，是依据xxx.xlsx命名的
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "Robin的第二张表07.xlsx");
        //数据表，写表
        workbook.write(fileOutputStream);
        //关闭流
        fileOutputStream.close();

        System.out.println("07版本Excel文件生成完毕，注意查看！");
    }


    @Test
    public void testExcelWrite03BigData() throws Exception {
        //时间
        long begin = System.currentTimeMillis();
        //创建一个工作簿
        Workbook workbook = new HSSFWorkbook();
        //创建一个工作表
        Sheet sheet = workbook.createSheet("03ExcelBigDate");
        //根据工作表创建一行
        //根据行创建列
        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("03ExcelBigData数据创建完毕！");
        //根据流，将数据数据
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "03ExcelBigData.xls");
        //写数据
        workbook.write(fileOutputStream);
        //关闭流
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double)(end-begin)/1000);
    }

    @Test//耗时比较久
    public void testExcelWrite07BigData() throws Exception {
        //时间
        long begin = System.currentTimeMillis();
        //创建一个工作簿
        Workbook workbook = new XSSFWorkbook();
        //创建一个工作表
        Sheet sheet = workbook.createSheet("07ExcelBigDate");
        //根据工作表创建一行
        //根据行创建列
        for (int rowNum = 0; rowNum < 65537; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("07ExcelBigData数据创建完毕！");
        //根据流，将数据数据
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "07ExcelBigData.xlsx");
        //写数据
        workbook.write(fileOutputStream);
        //关闭流
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double)(end-begin)/1000);
    }

    //采用SXSSFWorkbook技术加速处理表格，快速执行
    @Test
    public void testExcelWrite07BigDataS() throws Exception {
        //时间
        long begin = System.currentTimeMillis();
        //创建一个工作簿
        Workbook workbook = new SXSSFWorkbook();
        //创建一个工作表
        Sheet sheet = workbook.createSheet("07ExcelBigDateS");
        //根据工作表创建一行
        //根据行创建列
        for (int rowNum = 0; rowNum < 1000000; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("07ExcelBigDataS数据创建完毕！");
        //根据流，将数据数据
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "07ExcelBigDataS.xlsx");
        //写数据
        workbook.write(fileOutputStream);

        //关闭流
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double)(end-begin)/1000);
    }


}
