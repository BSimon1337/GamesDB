package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.genre;

public class GenreDAO {
	
	private Connection connection;
	private GamesDAO gameDao;
	private final String get_genres_query = "select * from genres";
	private final String get_genre_by_id_query = "select * from genres where id = ?";
	private final String create_new_team_query = "insert into genres(genre) values(?)";
	private final String delete_genre_by_id_query = "delete from genres where id = ?"; 

	
	
	
	public GenreDAO() {
		connection = DBConnection.getConnection();
		gameDao = new GamesDAO();
	}
	
	public List<genre> getGenres() throws SQLException{
		ResultSet rs = connection.prepareStatement(get_genres_query).executeQuery();
		List<genre> genres = new ArrayList<genre>();
		
		while (rs.next()) {
			genres.add(populateGenre(rs.getInt(1), rs.getString(2)));
		}
		
		return genres;
	}
	
	public genre getGenreById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(get_genre_by_id_query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateGenre(rs.getInt(1), rs.getString(2));
		
	}

	private genre populateGenre(int id, String genre) throws SQLException {
		return new genre(id, genre, gameDao.getGamesByGenreId(id));
	}
	
	public void createNewGenre(String genreName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(create_new_team_query);
		ps.setString(1, genreName);
		ps.executeUpdate();
	}
	
	public void deleteGenreById(int id) throws SQLException {
		gameDao.deleteGamesByGenreId(id);
		PreparedStatement ps = connection.prepareStatement(delete_genre_by_id_query);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
}
