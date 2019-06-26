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

@WebServlet("/export_tablets")
public class ExportTabletsXLS extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

    public ExportTabletsXLS() {
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
				
				
				
				HSSFSheet sheet = wb.createSheet("t_tablets");
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
				cell.setCellValue("OS");
				cell=row.createCell(4);
				cell.setCellStyle(style);
				cell.setCellValue("Brand");
				cell=row.createCell(5);
				cell.setCellStyle(style);
				cell.setCellValue("Color");
				cell=row.createCell(6);
				cell.setCellStyle(style);
				cell.setCellValue("RAM");
				cell=row.createCell(7);
				cell.setCellStyle(style);
				cell.setCellValue("Display");
				cell=row.createCell(8);
				cell.setCellStyle(style);
				cell.setCellValue("Memory");
				cell=row.createCell(9);
				cell.setCellStyle(style);
				cell.setCellValue("Number of cameras");
				cell=row.createCell(10);
				cell.setCellStyle(style);
				cell.setCellValue("CPU");
				cell=row.createCell(11);
				cell.setCellStyle(style);
				cell.setCellValue("Front Camera");
				cell.setCellStyle(style);
				cell=row.createCell(12);
				cell.setCellStyle(style);
				cell.setCellValue("Back Camera");
				cell=row.createCell(13);
				cell.setCellStyle(style);
				cell.setCellValue("Blutooth");
				cell=row.createCell(14);
				cell.setCellStyle(style);
				cell.setCellValue("Keyboard");
				
				int counter=1;
				String str = "SELECT * FROM t_tablets";
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
							cell = row.createCell(3);
							cell.setCellValue(resultSet.getString("os"));
							cell = row.createCell(4);
							cell.setCellValue(resultSet.getString("brand"));
							cell = row.createCell(5);
							cell.setCellValue(resultSet.getString("color"));
							cell = row.createCell(6, CellType.NUMERIC);
							cell.setCellValue(resultSet.getInt("ram_mb"));
							cell = row.createCell(7, CellType.NUMERIC);
							cell.setCellValue(resultSet.getFloat("display_inch"));
							cell.setCellStyle(numbers);
							cell = row.createCell(8, CellType.NUMERIC);
							cell.setCellValue(resultSet.getInt("memory_gb"));
							cell = row.createCell(9, CellType.NUMERIC);
							cell.setCellValue(resultSet.getInt("camera_num"));
							cell = row.createCell(10, CellType.NUMERIC);
							cell.setCellValue(resultSet.getFloat("cpu_ghz"));
							cell = row.createCell(11, CellType.NUMERIC);
							cell.setCellStyle(numbers);
							cell.setCellValue(resultSet.getFloat("frontcamera_mpx"));
							cell = row.createCell(12, CellType.NUMERIC);
							cell.setCellStyle(numbers);
							cell.setCellValue(resultSet.getFloat("backcamera_mpx"));
							cell = row.createCell(13);
							cell.setCellValue(resultSet.getBoolean("bluetooth") ? "Yes" : "No");
							cell = row.createCell(14,CellType.BOOLEAN);
							cell.setCellValue(resultSet.getBoolean("keyboard") ? "Yes" : "No");
														
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