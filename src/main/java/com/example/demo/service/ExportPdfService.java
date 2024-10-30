package com.example.demo.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.OutputStream;

@Service
public class ExportPdfService {

    @Autowired
    private FactureService factureService;

    public void exportFacture(Long idFacture, OutputStream outputStream) throws Exception {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();

        Paragraph paragrapheHeader1 = new Paragraph();
        paragrapheHeader1.add("hello");
        document.add(paragrapheHeader1);

        document.close();
    }
}
