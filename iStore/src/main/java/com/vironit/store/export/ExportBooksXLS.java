package com.vironit.store.export;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;


@WebServlet("/export_books")
public class ExportBooksXLS extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ExportBooksXLS() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String driver = context.getInitParameter("JDBC_DRIVER");
		String url = context.getInitParameter("JDBC_URL");
		String user = context.getInitParameter("JDBC_USER");
		String password = context.getInitParameter("JDBC_PASSWORD");	
		
		try {
			Class.forName(driver);
			
			try(HSSFWorkbook wb = new HSSFWorkbook();
				Connection con = DriverManager.getConnection(url, user, password)){
					
				CellStyle style = wb.createCellStyle();
				HSSFFont font = wb.createFont();
				style.setAlignment(HorizontalAlignment.CENTER);
				
				font.setBold(true);
				style.setFont(font);
				
				
				CellStyle numbers = wb.createCellStyle();
				numbers.setDataFormat(wb.createDataFormat().getFormat("0.00"));
					
				HSSFSheet sheet = wb.createSheet("t_books");
				HSSFRow row = sheet.createRow(0);
				
				HSSFCell cell;
				
				row.setRowStyle(style);
				
				cell=row.createCell(0);
				cell.setCellStyle(style);
				cell.setCellValue("Price");
				cell=row.createCell(1);
				cell.setCellStyle(style);
				cell.setCellValue("Availability");
				cell=row.createCell(2);
				cell.setCellStyle(style);
				cell.setCellValue("Discount");
				cell=row.createCell(3);
				cell.setCellStyle(style);
				cell.setCellValue("Title");
				cell=row.createCell(4);
				cell.setCellStyle(style);
				cell.setCellValue("Author");
				cell=row.createCell(5);
				cell.setCellStyle(style);
				cell.setCellValue("Age Group");
				cell=row.createCell(6);
				cell.setCellStyle(style);
				cell.setCellValue("Genre");
				
				int counter=1;
				String str = "SELECT * FROM t_books";
				try(Statement state = con.createStatement()){
					try(ResultSet resultSet = state.executeQuery(str)){
						while(resultSet.next()) {
							row = sheet.createRow(counter++);
							
							cell = row.createCell(0, CellType.NUMERIC);
							cell.setCellValue(resultSet.getInt("price"));
							cell = row.createCell(1);
							cell.setCellValue(resultSet.getBoolean("is_present") ? "There is at the warehouse" :"Absent");
							cell = row.createCell(2, CellType.NUMERIC);
							cell.setCellValue(resultSet.getInt("discount"));
							cell = row.createCell(3, CellType.NUMERIC);
							cell.setCellValue(resultSet.getString("title"));
							cell = row.createCell(4);
							cell.setCellValue(resultSet.getString("author"));
							cell = row.createCell(5);
							cell.setCellValue(resultSet.getString("age_group"));
							cell = row.createCell(6);
							cell.setCellValue(resultSet.getString("genre"));
							
						}
					}
				}
				
				for(int i =0; i<15; i++) sheet.autoSizeColumn(i);
				response.setContentType("application/vnd.ms-excel");
				try(OutputStream out = response.getOutputStream()){
					wb.write(out);
				}
	        }           
	    } catch (Exception e) {
	        e.printStackTrace();
	        
	        response.setContentType( "text/html" );
	        try ( PrintWriter out = response.getWriter() ) {
	            out.println( "An error is produced" );
	        }
	        
	    }
	    
	}}
														
						
				