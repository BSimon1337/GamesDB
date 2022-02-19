package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.games;

public class GamesDAO {
	
	private Connection connection;
	private final String get_games_by_genre_id_query = "select * from games where  genre_id = ?";
	private final String delete_games_by_genre_id_query = "delete from games where genre_id = ?";
	private final String create_new_game_query = "insert into games(title, year_released, developer_name, genre_id) values(?,?,?,?)";
	private final String delete_game_by_id_query = "delete from games where id = ?";
	private final String update_game_by_id_query = "update games set title = ?, year_released = ?, developer_name = ? where id = ?";

	
	public GamesDAO() {
		connection = DBConnection.getConnection();
	}

	public List<games> getGamesByGenreId(int genreId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(get_games_by_genre_id_query);
		ps.setInt(1, genreId);
		ResultSet rs = ps.executeQuery();
		List<games> games = new ArrayList<games>();
		
		while (rs.next()) {
			games.add(new games(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
		}
		return games;
	}
	
	public void deleteGamesByGenreId(int genreId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(delete_games_by_genre_id_query);
		ps.setInt(1, genreId);
		ps.executeUpdate();
	}
	
	public void createNewGame(String title, int year, String developer, int genreId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(create_new_game_query);
		ps.setString(1, title);
		ps.setInt(2, year);
		ps.setString(3, developer);
		ps.setInt(4, genreId);
		ps.executeUpdate();
	}
	
	public void deleteGmeById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(delete_game_by_id_query);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public void updateGame(String title, int year, String developer, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(update_game_by_id_query);
		
		ps.setString(1, title);
		ps.setInt(2, year);
		ps.setString(3, developer);
		ps.setInt(4, id);
		ps.executeUpdate();
	
	}
}
