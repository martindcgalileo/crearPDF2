/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crearpdf;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author martin
 */
public class CrearPDF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Se crea el documento
        Document documento = new Document();
        try {
            // Se crea el OutputStream para el fichero donde queremos dejar el pdf.
            FileOutputStream ficheroPdf = new FileOutputStream("fichero.pdf");
            /*
                * Se asocia el documento al OutputStream y se indica que el espaciado entre
                * lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
             */
            PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);
            // Se abre el documento.
            documento.open();
            //Añadir título
            Paragraph titulo = new Paragraph("Clasificacion ATP",
                    FontFactory.getFont("arial", // fuente
                            22, // tamaño
                            Font.ITALIC, // estilo
                            BaseColor.BLUE)); // color
            titulo.setAlignment(Chunk.ALIGN_CENTER);
            documento.add(titulo);
            //Añadir una línea en blanco
            documento.add(Chunk.NEWLINE);
            //Añadir un párrafo
            documento.add(new Paragraph(
                    "El ranking ATP es una clasificación mundial de tenistas profesionales de la Asociación "
                    + "de Tenistas Profesionales. Se actualiza cada semana y abarca los resultados de las últimas 52 semanas. "
                    + "Se utiliza para seleccionar a los habilitados en cada torneo y a los cabezas de serie, el máximo galardón para "
                    + "cualquier tenista es ser considerado entre los 5 mejores del mundo en el ranking ATP."));
            //Añadir una línea en blanco
            documento.add(Chunk.NEWLINE);
            //Añadir imagen
            Image foto = Image.getInstance("src/img/atp_logo.png");
            foto.scaleToFit(100, 100);
            foto.setAlignment(Chunk.ALIGN_MIDDLE);
            documento.add(foto);
            //Añadir una línea en blanco
            documento.add(Chunk.NEWLINE);
            //Añadir tabla
            float[] anchoColumnas = {1, 3, 1.5f};
            PdfPTable tabla = new PdfPTable(anchoColumnas);
            PdfPCell celda=new PdfPCell(new Phrase("Nº"));
            celda.setBackgroundColor(GrayColor.PINK);
            tabla.addCell(celda);
            celda.setPhrase(new Phrase("Jugador"));
            tabla.addCell(celda);
            celda.setPhrase(new Phrase("Puntos"));
            tabla.addCell(celda);
            tabla.addCell("1");
            tabla.addCell("Djokovic, Novac");
            tabla.addCell("15.150");
            tabla.addCell("2");
            tabla.addCell("Murray, Andy");
            tabla.addCell("7.925");
            tabla.addCell("3");
            tabla.addCell("Federer, Roger");
            tabla.addCell("7.535");
            documento.add(tabla);
            // Se cierra el documento
            documento.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CrearPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(CrearPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CrearPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
