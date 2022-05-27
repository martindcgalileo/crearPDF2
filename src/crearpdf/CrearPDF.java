/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crearpdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
            // Se cierra el documento
            documento.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CrearPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(CrearPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
