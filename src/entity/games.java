package entity;

public class games {

	
	private int gameId;
	private String title;
	private int yearReleased;
	private String developer;
	
	
	public games(int gameId, String title, int yearReleased, String developer) {
		this.setGameId(gameId);
		this.setTitle(title);
		this.setYearReleased(yearReleased);
		this.setDeveloper(developer);
	}


	public int getGameId() {
		return gameId;
	}


	public void setGameId(int gameId) {
		this.gameId = gameId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getYearReleased() {
		return yearReleased;
	}


	public void setYearReleased(int yearReleased) {
		this.yearReleased = yearReleased;
	}


	public String getDeveloper() {
		return developer;
	}


	public void setDeveloper(String developer) {
		this.developer = developer;
	}
}
