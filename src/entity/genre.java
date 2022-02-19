package entity;

import java.util.List;

public class genre {
	
	private int genreId;
	private String genre;
	private List<games> games;
	
	public genre(int genreId, String genre, List<games> games) {
		this.setGenreId(genreId);
		this.setGenre(genre);
		this.setGames(games);
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<games> getGames() {
		return games;
	}

	public void setGames(List<games> games) {
		this.games = games;
	}

}
