package com.robin;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.Date;

/**
 * @Description
 * @Author Robin
 * @Date 2020/5/3 19:45
 */
public class ExcelReadTest {

    String PATH = "D:\\Workspaces\\IDEA171001\\MvnProject20200503\\poi01\\";

    @Test
    public void testExcelRead03() throws Exception {
        //获取文件流
        FileInputStream fileInputStream = new FileInputStream(PATH + "Robin的第一张表03.xls");
        //创建一个工作簿，Excel能够操作的，这边都可以进行操作
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        //获取一个工作表   我们这里采用的根据index获取，而不是名字，通用行比较高，避免个人改写错误
        Sheet sheet = workbook.getSheetAt(0);
        //获取行
        Row row = sheet.getRow(0);
        //根据行获取列
        Cell cell = row.getCell(0);
        //根据行列获取值       这个地方需要注意，获取不同类型的值，需要采用不同类型的方法
        String stringCellValue = cell.getStringCellValue();
        System.out.println(stringCellValue);
        fileInputStream.close();
    }

    @Test
    public void testExcelRead07() throws Exception {
        //获取文件流
        FileInputStream fileInputStream = new FileInputStream(PATH + "Robin的第二张表07.xlsx");
        //创建一个工作簿，Excel能够操作的，这边都可以进行操作
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        //获取一个工作表   我们这里采用的根据index获取，而不是名字，通用行比较高，避免个人改写错误
        Sheet sheet = workbook.getSheetAt(0);
        //获取行
        Row row = sheet.getRow(0);
        //根据行获取列
        Cell cell = row.getCell(0);
        //根据行列获取值       这个地方需要注意，获取不同类型的值，需要采用不同类型的方法
        String stringCellValue = cell.getStringCellValue();
        System.out.println(stringCellValue);
        fileInputStream.close();
    }

    //读取一个表格中存在不同类型的数据
    @Test
    public void testExcelRead03Type() throws Exception {
        //获取文件流
        FileInputStream fileInputStream = new FileInputStream(PATH + "明细表.xls");
        //创建一个工作簿，Excel能够操作的，这边都可以进行操作
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        //获取一个工作表   我们这里采用的根据index获取，而不是名字，通用行比较高，避免个人改写错误
        Sheet sheet = workbook.getSheetAt(0);
        //获取标题内容
        Row rowTitle = sheet.getRow(0);
        if (rowTitle != null) {
            int cellCount = rowTitle.getPhysicalNumberOfCells();
            for (int cellNum = 0; cellNum < cellCount; cellNum++) {
                Cell cell = rowTitle.getCell(cellNum);
                if (cell != null) {
                    CellType cellType = cell.getCellType();
                    String stringCellValue = cell.getStringCellValue();
                    System.out.print(stringCellValue+" | ");
                }
            }
            System.out.println();
        }



        //获取表中内容
        int rowCount = sheet.getPhysicalNumberOfRows();
        for (int rowNum = 1; rowNum < rowCount; rowNum++) {
            Row rowData = sheet.getRow(rowNum);
            if (rowData != null) {
                //读取列  即读取单元格数据
                int cellCount = rowTitle.getPhysicalNumberOfCells();
                for (int cellNum = 0; cellNum < cellCount; cellNum++) {
                    System.out.print("[" + (rowNum + 1) + "-" + (cellNum + 1) + "]");
                    Cell cell = rowData.getCell(cellNum);
                    //匹配列的数据类型
                    if (cell != null) {
                        CellType cellType = cell.getCellType();
                        String cellValue = "";

                        switch (cellType) {
                            //case cellType.STRING://这样写会报错，An enum switch case label must be the unqualified name of an enumeration constant
                                                //枚举开关的大小写标签必须是枚举常量的非限定名称
                            case STRING:    //字符串
                                System.out.print("【String】");
                                cellValue = cell.getStringCellValue();
                                break;
                            case BOOLEAN://布尔值
                                System.out.print("【BOOLEAN】");
                                cellValue = String.valueOf(cell.getBooleanCellValue());
                                break;
                            case BLANK://空
                                System.out.print("【BLANK】");
                                break;
                            case NUMERIC://数字（日期、普通数字）
                                System.out.print("【NUMERIC】");
                                //HSSFDateUtil.isCellDateFormatted(cell)    该方法已经过时
                                if (DateUtil.isCellDateFormatted(cell)) {//日期
                                    System.out.print("【日期】");
                                    Date date = cell.getDateCellValue();
                                    cellValue = new DateTime(date).toString("yyyy-MM-dd");
                                } else {
                                    //如果不是日期格式，防止数字过长
                                    System.out.print("【转换为字符串输出】");
                                    cell.setCellType(CellType.STRING);
                                    cellValue = cell.toString();
                                }
                                break;
                            case ERROR://类型错误
                                System.out.print("【数据类型错误】");
                                break;
                        }
                        System.out.println(cellValue);
                    }
                }
            }
            fileInputStream.close();
        }


    }


}
