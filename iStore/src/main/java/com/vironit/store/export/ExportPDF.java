package com.vironit.store.export;
/*
import java.io.IOException;
//import java.text.NumberFormat;
//import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;

@WebServlet("/exportpdf")
public class ExportPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ExportPDF() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String file= request.getServletContext().getRealPath("/WEB-INF/view/GoodsInCart.pdf");
		response.setContentType("application/pdf");
		
		
		try(PdfReader reader = new PdfReader(file);
		PdfWriter writer = new PdfWriter(response.getOutputStream());
		PdfDocument doc = new PdfDocument(reader, writer);){
			
			PdfPage page = doc.getPage(1);
			PdfCanvas canvas = new PdfCanvas(page);
			
			FontProgram fp= FontProgramFactory.createFont();
			PdfFont font = PdfFontFactory.createFont(fp,"utf-8", true);	
			canvas.setFontAndSize(font, 12);
			
			canvas.beginText();
			canvas.setTextMatrix(0,0);
			canvas.showText("Text");
			canvas.endText();
			
			
		//	NumberFormat form =NumberFormat.getNumberInstance(new Locale("en", "EN"));
		//	int top=500;
		}
			
		}



}
*/