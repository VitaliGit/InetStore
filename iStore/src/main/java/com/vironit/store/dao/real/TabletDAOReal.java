package com.vironit.store.dao.real;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.vironit.store.dao.TabletDAO;
import com.vironit.store.dao.db.DAOContext;
import com.vironit.store.entity.builder.TabletBuilder;
import com.vironit.store.entity.tablet.Tablet;
import com.vironit.store.exception.NoUniqueIdException;
import com.vironit.store.dto.TabletSearchDTO;

public class TabletDAOReal extends DAOContext implements  TabletDAO  {
	

	@Override
	public void add(Tablet tablet) throws NoUniqueIdException, SQLException {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
		String strSql ="INSERT INTO t_tablets VALUES (?, ?, ?, ?, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try ( PreparedStatement statement  = connection.prepareStatement( strSql )) {
			statement.setInt(1, 	tablet.getId());
			statement.setBoolean(2, tablet.isAvailable());
			statement.setString(3, 	tablet.getBrand());
			statement.setInt(4, 	tablet.getPrice());
			statement.setInt(5, 	tablet.getDiscount());
			statement.setString(6, 	tablet.getColor());
			statement.setFloat(7, 	tablet.getDisplay());
			statement.setInt(8, 	tablet.getRam());
			statement.setInt(9, 	tablet.getMemory());
			statement.setInt(10, 	tablet.getCamera());
			statement.setFloat(11,	tablet.getBackCamera());
			statement.setFloat(12, 	tablet.getFrontCamera());
			statement.setFloat(13, 	tablet.getCpu());
			statement.setString(14, tablet.getOs());
			statement.setBoolean(15,tablet.isBluetooth());
			statement.setBoolean(16,tablet.isKeyboard());
			statement.executeUpdate();	
	}}
}

	@Override
	public void remove(int id) throws Exception {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
			String strSql = "DELETE FROM t_tablets WHERE id=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setInt( 1, id );
				statement.executeUpdate() ;
				}}
	}

	@Override
	public void updatePrice(int id, int price) throws Exception {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
		String strSql = "UPDATE t_tablets SET price = ? WHERE id = ?";
		try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
			statement.setInt( 1, price);
			statement.setInt( 2, id );
			statement.executeUpdate() ;		
}}}

	@Override
	public void updateAvailable(int id, boolean available) throws Exception {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
			String strSql = "UPDATE t_tablets SET is_present = ? WHERE id = ?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setBoolean( 1, available );
				statement.setInt( 2, id );
				statement.executeUpdate() ;		
			}}}
	@Override
	public void updateDiscount(int id, int discount) throws Exception {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
			String strSql = "UPDATE t_tablets SET discount = ? WHERE id = ?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setInt( 1, discount );
				statement.setInt( 2, id );
				statement.executeUpdate() ;		
			}}}
	@Override
	public Optional<Tablet> searchById(int id) throws SQLException {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
			String strSql = "SELECT * FROM t_tablets WHERE id=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setInt( 1, id );
				try ( ResultSet resultSet = statement.executeQuery() ) {
					resultSet.next();
					TabletBuilder builder = new TabletBuilder();
					builder = builder.withID(resultSet.getInt(1)).withAvailable(resultSet.getBoolean(2)).withBrand(resultSet.getString(3)).withPrice(resultSet.getInt(4)).withDiscount(resultSet.getInt(5)).withColor(resultSet.getString(6)).withDisplay(resultSet.getFloat(7)).withRam(resultSet.getInt(8)).withMemory(resultSet.getInt(9)).withCamera(resultSet.getInt(10)).withBackCamera(resultSet.getInt(11)).withFrontCamera(resultSet.getInt(12)).withCPU(resultSet.getFloat(13)).withOS(resultSet.getString(14)).withBluetooth(resultSet.getBoolean(15)).withKeyboard(resultSet.getBoolean(16));                            
						return Optional.of(builder.build());
	}}}

	}

	@Override
	public List<Tablet> getAllTablets() throws SQLException {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
			String strSql = "SELECT * FROM t_tablets ORDER BY id ASC";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				return execution(statement);}}
	}

	@Override
	public List<Tablet> searchByPrice(int price) throws SQLException {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
			String strSql = "SELECT * FROM t_tablets WHERE price<=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setInt( 1, price );
				return execution(statement);}}
	}

	@Override
	public List<Tablet> searchByAvailable(boolean available) throws SQLException {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
			String strSql = "SELECT * FROM t_tablets WHERE is_present=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setBoolean( 1, available );
				return execution(statement);}}
	}

	@Override
	public List<Tablet> searchByDiscount(int discount) throws SQLException {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
			String strSql = "SELECT * FROM t_tablets WHERE discount>=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setInt( 1, discount );
				return execution(statement);}}
	}
	@Override
	public List<Tablet> searchByOs(String os) throws SQLException {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
			String strSql = "SELECT * FROM t_tablets WHERE os=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setString( 1, os);
				return execution(statement);}}
	}

	@Override
	public List<Tablet> searchByBrand(String brand) throws SQLException {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
			String strSql = "SELECT * FROM t_tablets WHERE brand=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setString( 1, brand);
				return execution(statement);}}
	}

	@Override
	public List<Tablet> searchByColor(String color) throws SQLException {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
			String strSql = "SELECT * FROM t_tablets WHERE color=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setString( 1, color);
				return execution(statement);}}
	}

	@Override
	public List<Tablet> searchByDisplay(float display) throws SQLException {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
			String strSql = "SELECT * FROM t_tablets WHERE display_inch>=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setFloat( 1, display);
				return execution(statement);}}
	}

	@Override
	public List<Tablet> searchByRam(int ram) throws SQLException {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
			String strSql = "SELECT * FROM t_tablets WHERE ram_mb>=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setInt( 1, ram);
				return execution(statement);}}
	}

	@Override
	public List<Tablet> searchByMemory(int memory) throws SQLException {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
			String strSql = "SELECT * FROM t_tablets WHERE memory_gb>=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setInt( 1, memory);
				return execution(statement);}}
	}

	@Override
	public List<Tablet> searchByCpu(float cpu) throws SQLException {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
			String strSql = "SELECT * FROM t_tablets WHERE cpu_ghz>=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setFloat( 1, cpu);
				return execution(statement);}}
	}

	@Override
	public List<Tablet> searchByCamera(int camera) throws SQLException {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
			String strSql = "SELECT * FROM t_tablets WHERE camera_num>=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setInt( 1, camera);
				return execution(statement);}}
	}

	@Override
	public List<Tablet> searchByFrontCamera(float frontCamera) throws SQLException {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
			String strSql = "SELECT * FROM t_tablets WHERE frontcamera_mpx>=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setFloat( 1, frontCamera);
				return execution(statement);}}
	}
	@Override
	public List<Tablet> searchByBackCamera(float backCamera) throws SQLException {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
			String strSql = "SELECT * FROM t_tablets WHERE backcamera_mpx>=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setFloat( 1, backCamera);
				return execution(statement);}}
	}

	@Override
	public List<Tablet> searchByBluetooth(boolean bluetooth) throws SQLException {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
			String strSql = "SELECT * FROM t_tablets WHERE bluetooth=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setBoolean( 1, bluetooth);
				return execution(statement);}}
	}

	@Override
	public List<Tablet> searchByKeyboard(boolean keyboard) throws SQLException {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
			String strSql = "SELECT * FROM t_tablets WHERE keyboard=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setBoolean( 1, keyboard);
				return execution(statement);}}
	}


	public List<Tablet> searchBySeveralOptions(TabletSearchDTO allDto) throws SQLException {
		
		try ( Connection connection = DriverManager.getConnection( dbURL, dbUser, dbPassword ) ){
			String strSql = "SELECT * FROM t_tablets WHERE keyboard=? AND bluetooth=? AND backcamera_mpx>=? AND frontcamera_mpx>=? "
					+ "AND camera_num>=? AND cpu_ghz>=? AND memory_gb>=? AND ram_mb>=? AND display_inch>=? AND color=? AND brand=? AND os=? AND discount>=? "
					+ "AND is_present=? AND price<=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setBoolean( 1, allDto.isKeyboard());
				statement.setBoolean( 2, allDto.isBluetooth());
				statement.setFloat( 3, allDto.getBackCamera());
				statement.setFloat( 4, allDto.getFrontCamera());
				statement.setInt( 5, allDto.getCamera());
				statement.setFloat( 6, allDto.getCpu());
				statement.setInt( 7, allDto.getMemory());
				statement.setInt( 8, allDto.getRam());
				statement.setFloat( 9, allDto.getDisplay());
				statement.setString( 10, allDto.getColor());
				statement.setString( 11, allDto.getBrand());
				statement.setString( 12, allDto.getOs());
				statement.setInt( 13, allDto.getDiscount());
				statement.setBoolean( 14, allDto.isAvailable());
				statement.setInt( 15, allDto.getPrice());
		return execution(statement);}
	}}
	
	
	private List<Tablet> execution(PreparedStatement statement) throws SQLException { // common for all methods searching for List<Tablet>
		
		try ( ResultSet resultSet = statement.executeQuery() ) {
			List <Tablet>  list = new ArrayList<Tablet>();
			TabletBuilder builder = new TabletBuilder();
			while(resultSet.next()) {
			builder = builder.withID(resultSet.getInt(1)).withAvailable(resultSet.getBoolean(2)).withBrand(resultSet.getString(3)).withPrice(resultSet.getInt(4)).withDiscount(resultSet.getInt(5)).withColor(resultSet.getString(6)).withDisplay(resultSet.getFloat(7)).withRam(resultSet.getInt(8)).withMemory(resultSet.getInt(9)).withCamera(resultSet.getInt(10)).withBackCamera(resultSet.getInt(11)).withFrontCamera(resultSet.getInt(12)).withCPU(resultSet.getFloat(13)).withOS(resultSet.getString(14)).withBluetooth(resultSet.getBoolean(15)).withKeyboard(resultSet.getBoolean(16));                              
			list.add(builder.build());}
			return list;
}
	}	
}
