package com.example.demo.service;

import com.example.demo.dto.ClientDto;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;

@Service
public class ExportXlsxService {

    public ExportXlsxService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    private ClientService clientService;

    public void exportClient(OutputStream outputStream) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Clients");

        Row rowHeader = sheet.createRow(0);

        CellStyle cellStyleHeader = workbook.createCellStyle();
        Font fontHeader = workbook.createFont();
        fontHeader.setFontName("Helvetica");
        fontHeader.setBold(true);
        fontHeader.setColor(IndexedColors.PINK.index);
        cellStyleHeader.setFont(fontHeader);
        addBorder(cellStyleHeader);

        CellStyle cellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Calibri");
        cellStyle.setFont(font);
        addBorder(cellStyle);

        createCell(rowHeader, 0, cellStyleHeader).setCellValue("Nom");
        createCell(rowHeader, 1, cellStyleHeader).setCellValue("Prénom");
        createCell(rowHeader, 2, cellStyleHeader).setCellValue("Age");

        int iRow = 1;
        for (ClientDto clientDto : clientService.findAll()) {
            Row row = sheet.createRow(iRow++);
            createCell(row, 0, cellStyle).setCellValue(clientDto.getNom());
            createCell(row, 1, cellStyle).setCellValue(clientDto.getPrenom());
            createCell(row, 2, cellStyle).setCellValue(clientDto.getAge() + " ans");
        }

        workbook.write(outputStream);
        workbook.close();
    }

    private static void addBorder(CellStyle cellStyleHeader) {
        cellStyleHeader.setBorderBottom(BorderStyle.MEDIUM);
        cellStyleHeader.setBorderTop(BorderStyle.MEDIUM);
        cellStyleHeader.setBorderLeft(BorderStyle.MEDIUM);
        cellStyleHeader.setBorderRight(BorderStyle.MEDIUM);
        cellStyleHeader.setBottomBorderColor(IndexedColors.BLUE.index);
        cellStyleHeader.setTopBorderColor(IndexedColors.BLUE.index);
        cellStyleHeader.setLeftBorderColor(IndexedColors.BLUE.index);
        cellStyleHeader.setRightBorderColor(IndexedColors.BLUE.index);
    }

    private static Cell createCell(Row rowHeader, int i, CellStyle cellStyle) {
        Cell cell = rowHeader.createCell(i);
        cell.setCellStyle(cellStyle);
        return cell;
    }

}
