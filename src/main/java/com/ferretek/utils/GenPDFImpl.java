package com.ferretek.utils;

import com.ferretek.dto.Cliente;
import com.ferretek.dto.Producto;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.ferretek.utils.Util.productos;

@Service
public class GenPDFImpl implements GenPDFI {


    private Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 40,
            Font.BOLD);
    private Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 28,
            Font.BOLD);
    private Font normalNegrita = new Font(Font.FontFamily.TIMES_ROMAN, 14,
            Font.BOLD);
    private Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);


    @Override
    public void generarPDF(Cliente cliente, Map<Integer, double[]> cantidadesPreciosYSubtotales, double ordeCostoEnv, double total, String resource) throws DocumentException, FileNotFoundException {
        System.out.println(resource);
        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream(resource));
        document.open();

        // Se genera un header para el pdf
        Paragraph preface = new Paragraph();
        preface.add(new Paragraph(
                "Generado: " + LocalDate.now(),
                smallBold));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("FERRETEK", catFont));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Detalle de Venta", subFont));
        addEmptyLine(preface, 1);
        //Datos del cliente
        preface.add(new Paragraph("CLIENTE: " + cliente.getClienNombres() + " " + cliente.getClienApellidos(), normalNegrita));

        preface.add(new Paragraph("CÉDULA: " + cliente.getClienCedula(), normalNegrita));

        preface.add(new Paragraph("CORREO: " + cliente.getClienCorreo(), normalNegrita));

        preface.add(new Paragraph("TELÉFONO: " + cliente.getClienTelef(), normalNegrita));
        addEmptyLine(preface, 1);
        // Se genera la tabla del PDF
        Paragraph subCatPart = new Paragraph();


        PdfPTable table = new PdfPTable(4);

        //Genero el header de cada columna
        PdfPCell columnas = new PdfPCell(new Phrase("Producto"));
        columnas.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(columnas);

        columnas = new PdfPCell(new Phrase("Cantidad"));
        columnas.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(columnas);

        columnas = new PdfPCell(new Phrase("Precio Unit"));
        columnas.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(columnas);

        columnas = new PdfPCell(new Phrase("Subtotal"));
        columnas.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(columnas);

        table.setHeaderRows(cantidadesPreciosYSubtotales.keySet().size());

        Map<Integer, String> nombreDeProductos = new HashMap<>();
        productos.forEach(s -> nombreDeProductos.put(s.getProdId(), s.getProdNombre()));
        //se añade de forma horizontal
        for (Integer key : cantidadesPreciosYSubtotales.keySet()) {

            table.addCell(nombreDeProductos.get(key));
            table.addCell(String.valueOf(cantidadesPreciosYSubtotales.get(key)[0]));
            table.addCell(String.valueOf(cantidadesPreciosYSubtotales.get(key)[1]));
            table.addCell(String.valueOf(Util.redondearDecimales(
                    cantidadesPreciosYSubtotales.get(key)[2],
                    2)));
        }
        subCatPart.add(table);
        preface.add(subCatPart);
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Costo de envió: " + ordeCostoEnv, normalNegrita));
        preface.add(new Paragraph("TOTAL A PAGAR: " + Util.redondearDecimales(total, 2), normalNegrita));

        addEmptyLine(preface, 3);

        preface.add(new Paragraph("Gracias por usar nuestro servicio", subFont));

        document.add(preface);

        document.close();
        //NOTA: El PDF se genera en la carpeta build/resources/main

    }


    public void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    @Override
    public void abrirArchivo(String archivo) {
        try {

            File objetofile = new File(archivo);
            Desktop.getDesktop().open(objetofile);

        } catch (IOException ex) {
            System.out.println(ex);
        }

    }
}
