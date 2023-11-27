package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public class FilmDaoJdbcImpl implements FilmDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private final static String USERNAME = "student";
	private final static String PASSWORD = "student";

	public FilmDaoJdbcImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	// YOUR FIRST SELECT DB QUERY APPLICATION WITH PASS IN ARGUMENT
	public Film findFilmById(int filmId) {
		Film film = null;
		try {
		Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		String sql = "select rawdatatbl.id, rawdatatbl.title, rawdatatbl.description, rawdatatbl.release_year, rawlanguagetbl.name as language_Name, rawdatatbl.rental_duration, rawdatatbl.rental_rate, rawdatatbl.length, rawdatatbl.replacement_cost, rawdatatbl.rating, rawdatatbl.special_features from (select * from film where id = ?) rawdatatbl join (select * from language) rawlanguagetbl on rawdatatbl.language_id=rawlanguagetbl.id";

		PreparedStatement sqlStmt = conn.prepareStatement(sql);
		sqlStmt.setInt(1, filmId);

//	  System.out.println(sqlStmt); // Debug Line

		ResultSet queryResult = sqlStmt.executeQuery();

		if (queryResult.next()) {
			film = new Film();

			film.setFilmId(queryResult.getInt("id"));
			film.setTitle(queryResult.getString("title"));
			film.setDescriptionOffilm(queryResult.getString("description"));
			film.setReleaseYear(queryResult.getShort("release_year"));
			film.setLanguage(queryResult.getString("language_Name"));
			film.setRental_duration(queryResult.getInt("rental_duration"));
			film.setRental_rate(queryResult.getDouble("rental_rate"));
			film.setLength(queryResult.getInt("length"));
			film.setReplacementCost(queryResult.getDouble("replacement_cost"));
			film.setRating(queryResult.getString("rating"));
			film.setSpecialFeatures(queryResult.getString("special_features"));
			film.setCast(findActorsByFilmId(filmId));
			film.setCategory(findFilmCategory(filmId));
		}
		queryResult.close();
		sqlStmt.close();
		conn.close(); 
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;

	}
	
	
	@Override
	// YOUR SECOND SELECT DB QUERY APPLICATION WITH PASS IN ARGUMENT
	public List<Film> findFilmByString(String searchString) {
		List<Film> films = new ArrayList<>();
		Film film = null;
		try {
		Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		String sql = "select rawdatatbl.id, rawdatatbl.title, rawdatatbl.description, rawdatatbl.release_year, rawlanguagetbl.name as language_Name, rawdatatbl.rental_duration, rawdatatbl.rental_rate, rawdatatbl.length, rawdatatbl.replacement_cost, rawdatatbl.rating, rawdatatbl.special_features from (select * from film where title like ? or description like ?) rawdatatbl join (select * from language) rawlanguagetbl on rawdatatbl.language_id=rawlanguagetbl.id";

		PreparedStatement sqlStmt = conn.prepareStatement(sql);
		sqlStmt.setString(1, "%" + searchString + "%");
		sqlStmt.setString(2, "%" + searchString + "%");

//	  System.out.println(sqlStmt); // Debug Line

		ResultSet queryResult = sqlStmt.executeQuery();

			while (queryResult.next()) {
				film = new Film();

				film.setFilmId(queryResult.getInt("id"));
				film.setTitle(queryResult.getString("title"));
				film.setDescriptionOffilm(queryResult.getString("description"));
				film.setReleaseYear(queryResult.getShort("release_year"));
				film.setLanguage(queryResult.getString("language_Name"));
				film.setRental_duration(queryResult.getInt("rental_duration"));
				film.setRental_rate(queryResult.getDouble("rental_rate"));
				film.setLength(queryResult.getInt("length"));
				film.setReplacementCost(queryResult.getDouble("replacement_cost"));
				film.setRating(queryResult.getString("rating"));
				film.setSpecialFeatures(queryResult.getString("special_features"));
				film.setCast(findActorsByFilmId(queryResult.getInt("id")));
				film.setCategory(findFilmCategory(queryResult.getInt("id")));
				

				films.add(film);
			}
		
		queryResult.close();
		sqlStmt.close();
		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;

	}
	
	

	
	@Override
	public List<Actor> findActorsByFilmId(int filmId) throws SQLException {
		// 0 Step: write out the prepared statement
		String sql = "select fa.actor_id, at.first_name, at.last_name, fa.film_id, fl.title  \n"
				+ "from actor at, film_actor fa, film fl where at.id=fa.actor_id and fa.film_id=fl.id and fl.id=?";

//		AUTO CLOSE DESIGN
		try (
				// 1st) insert connection to DB
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				// 2nd) Prepared Statement with added binding variable assignment with your own
				// method design
				PreparedStatement stmt = createDiegoPreparedStatement(conn, sql, filmId);
				// 3rd) execute the query and assign returned value to ResultSet
				ResultSet result = stmt.executeQuery();) {

			// After AutoClosable try block, then do assignments of result to individual
			// Actor objects:
			List<Actor> actors = new ArrayList<>();

			while (result.next()) {
				int id = result.getInt("fa.actor_id");
				String firstName = result.getString("at.first_name");
				String lastName = result.getString("at.last_name");
//				String filmName = result.getString("fl.title");

				// Construct Each Actor
				Actor aActor = new Actor(id, firstName, lastName);
				// Assign individual actor to list per each iteration
				actors.add(aActor);
			} // End while Loop

			return actors;

		} // End Auto close design pattern
	} // End Method
	
	
	@Override
	public String findFilmCategory(int filmId) throws SQLException {
		// 0 Step: write out the prepared statement
		String sql = "select fc.film_id, fc.category_id, ct.name from film_category fc, category ct where fc.category_id=ct.id and fc.film_id = ?";
		
//		AUTO CLOSE DESIGN
		try (
				// 1st) insert connection to DB
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				// 2nd) Prepared Statement with added binding variable assignment with your own
				// method design
				PreparedStatement stmt = createDiegoPreparedStatement(conn, sql, filmId);
				// 3rd) execute the query and assign returned value to ResultSet
				ResultSet result = stmt.executeQuery();) {
			
			// After AutoClosable try block, then do assignments of result to individual
			// Actor objects:
//			List<Actor> actors = new ArrayList<>();
			String category = null;
			
			while (result.next()) {
				 category = result.getString("ct.name");
			} // End while Loop
			
			return category;
			
		} // End Auto close design pattern
	} // End Method

	// NOTE this is your method for creating the prepared statement where the autoclose section did not allow biding variables
	private PreparedStatement createDiegoPreparedStatement(Connection conn, String sql, int bindingVariableValue)
			throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, bindingVariableValue);
		return stmt;

	}
	

}
