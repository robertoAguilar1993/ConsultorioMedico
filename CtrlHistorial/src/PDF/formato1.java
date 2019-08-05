/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDF;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.*; 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author hctab
 */
public class formato1 {
    String edad,paciente;
public void formato1(String desempeño,float valnum) {
    String username=System.getProperty("user.name");
    String nombre="ERIKA VELAZQUEZ GUILLEN";
    String numControl="14700266";
    Date date = new Date();
    DateFormat dia = new SimpleDateFormat("dd");
    DateFormat mes = new SimpleDateFormat("MMMMM");
    DateFormat año = new SimpleDateFormat("yyyy");
    try {
		    //LEER ARCHIVO ORIGEN.
		    PdfReader origen = 
	            new PdfReader("C:\\Users\\"+username+"\\Desktop\\formato\\Form\\RECETA.pdf");	
 
		    //NUEVO ARCHIVO A PARTIR DE ORIGEN.
		    PdfStamper nuevopdf = new PdfStamper(origen,
		    new FileOutputStream("C:\\Users\\"+username+"\\Desktop\\formato\\"+nombre+" F1.pdf"));
 
		    //Creación de fuentes.
		    BaseFont baseFont = BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
                    BaseFont negrita = BaseFont.createFont(BaseFont.TIMES_BOLD,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    
			//PÁGINA DE PDF.
			PdfContentByte pdf = nuevopdf.getOverContent(1);
                        //INICIAR TEXTO
			pdf.beginText();
			//FUENTE Y TAMAÑO DE LETRA.
			pdf.setFontAndSize(baseFont, 12);
                        //NOMBRE DE DEPARTAMENTO
                        pdf.setTextMatrix(354, 156);
                        pdf.showText("Sistemas y computaciónPARAMETRO:v");
                        //TEXTO DOCUMENTO
                        pdf.setTextMatrix(80, 500);
			pdf.showText("El que suscribe "+"PARAMETRO"+", por este  medio se  permite hacer de  su");
			pdf.setTextMatrix(80, 480);
			pdf.showText("conocimiento que el estudiante "+"PARAMETRO"+" con número de control");
			pdf.setTextMatrix(80, 460);
			pdf.showText("PARAMETRO"+" de la carrera de "+"PARAMETRO"+" ha  cumplido");
			pdf.setTextMatrix(80, 440);
			pdf.showText("su actividad complementaria con el nivel de desempeño "+desempeño+" y un valor númerico");
			pdf.setTextMatrix(80, 420);
			pdf.showText("de "+valnum+",  durante el período escolar "+"PARAMETRO"+" con un ");
			pdf.setTextMatrix(80, 400);
			pdf.showText("valor curricular de "+"PARAMETRO"+" créditos");
                        pdf.setTextMatrix(80, 360);
                        pdf.showText("Se extiende la presente en la Ciudad de Comitán de Dominguez a los "+dia.format(date)+" días de "+mes.format(date)+" de "+año.format(date));
                        
                        //NOMBRES 3 PUNTOS DOC
                        
                        pdf.setFontAndSize(negrita, 12);
                        pdf.setTextMatrix(87, 600);
			pdf.showText("PARAMETRO1");//NOMBRE DEL JEFE DE DPTO DE SERVICIOS ESCOLARES
			pdf.setTextMatrix(97, 185);
			pdf.showText("PARAMETRO2");//NOMBRE DEL PROFESOR RESPONSABLE
                        pdf.setTextMatrix(350, 185);
                        pdf.showText("PARAMETRO3");//NOMBRE DEL JEFE DE DPTO
			
                        pdf.endText();
		   
                    //CERRAR DOCUMENTO.
		    nuevopdf.close();	
 
		    System.out.println("PDF modified successfully.");
		} catch (Exception e) {
		    e.printStackTrace();
		} 
}    
    }
