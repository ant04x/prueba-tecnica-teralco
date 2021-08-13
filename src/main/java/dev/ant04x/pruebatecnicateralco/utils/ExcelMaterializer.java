package dev.ant04x.pruebatecnicateralco.utils;

import dev.ant04x.pruebatecnicateralco.entities.Car;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelMaterializer {

    public static ByteArrayInputStream carsToExcel(List<Car> cars) throws IOException {
        String[] columns = {"Id", "Color", "Model"};
        try(
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
        ) {
            CreationHelper createHelper = workbook.getCreationHelper();

            Sheet sheet = workbook.createSheet("Cars");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            // Row for Header
            Row headerRow = sheet.createRow(0);

            // Header
            for (int col = 0; col < columns.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(columns[col]);
                cell.setCellStyle(headerCellStyle);
            }



            int rowIdx = 1;
            for (Car car : cars) {

                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(car.getId());
                row.createCell(1).setCellValue(car.getColorName());
                row.createCell(2).setCellValue(car.getModelName());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}
