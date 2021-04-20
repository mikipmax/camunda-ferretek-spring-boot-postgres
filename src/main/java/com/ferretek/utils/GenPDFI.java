package com.ferretek.utils;

import com.ferretek.dto.Cliente;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.BadElementException;

import java.io.FileNotFoundException;
import java.util.Map;

public interface GenPDFI {
    void generarPDF(Cliente cliente, Map<Integer,double[]> cantidadesPreciosYSubtotales, double ordeCostoEnv,double total,String resource) throws DocumentException, FileNotFoundException;

    void abrirArchivo(String archivo);


}
