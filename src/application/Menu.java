package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.GamesDAO;
import dao.GenreDAO;
import entity.games;
import entity.genre;


public class Menu {
	
	
	private GamesDAO gameDao = new GamesDAO();
	private GenreDAO genreDao = new GenreDAO();
	private Scanner scanner = new Scanner(System.in);
	
	
	private List<String> options = Arrays.asList(
			"Display Genres", 
			"Display a Genre", 
			"Create Genre", 
			"Delete Genre", 
			"Create Game Title", 
			"Delete Game Title",
			"Update Game");
	
	public void start() {
		String selection = "";
		
		
		do {
			printmenu();
			selection = scanner.nextLine();
			
				try {
					
					if (selection.equals("1")) {
						displayGenres(); //read
					}else if (selection.equals("2")){
						displayGenre(); //read
					}else if (selection.equals("3")){
						createGenre(); //create
					}else if (selection.equals("4")){
						deleteGenre(); //delete
					}else if (selection.equals("5")){
						createGame();
					}else if (selection.equals("6")){
						deleteGame();	
					}else if (selection.equals("7")) {
						updateGame();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			
			
			
			System.out.println("Press enter to continue.....");
			scanner.nextLine();
			
		}while (!selection.equals("-1"));
	}

	private void updateGame() throws SQLException {
		System.out.println("Enter game id to update: ");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter new title of game: ");
		String gameTitle = scanner.nextLine();
		System.out.print("Enter the new year the game was released: ");
		int yearReleased = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter the new name of the developer of the game: ");
		String developer = scanner.nextLine();
		gameDao.updateGame(gameTitle, yearReleased, developer, id);
		
	}

	private void deleteGame() throws SQLException {
		System.out.println("Enter game id to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		gameDao.deleteGmeById(id);
		
	}

	private void deleteGenre() throws SQLException {
		System.out.print("Enter genre Id to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		genreDao.deleteGenreById(id);
		
	}

	private void createGenre() throws SQLException {
		System.out.print("Enter new genre: ");
		String genreNaame = scanner.nextLine();
		genreDao.createNewGenre(genreNaame);
		
	}

	private void displayGenre() throws SQLException {
		System.out.print("Enter Genre Id: ");
		int id = Integer.parseInt(scanner.nextLine());
		genre genre = genreDao.getGenreById(id);
		System.out.println(genre.getGenreId() + ": " + genre.getGenre());
		for(games game : genre.getGames()) {
			System.out.println("\tGame Id: " + game.getGameId() + " - Title: " + game.getTitle() + " Year released: " + game.getYearReleased() + " Developer: " + game.getDeveloper());
		}
	}

	private void displayGenres() throws SQLException {
		List<genre> genres = genreDao.getGenres();
		for(genre genre : genres) {
			System.out.println(genre.getGenreId() + ": " + genre.getGenre());
		}
		
	}

	private void printmenu() {
		System.out.println("Select and option:\n-----------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ")" + options.get(i));
		}
		
	}
	
	private void createGame() throws SQLException {
		System.out.print("Enter title of game: ");
		String gameTitle = scanner.nextLine();
		System.out.print("Enter the year the game was released: ");
		int yearReleased = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter the name of the developer of the game: ");
		String developer = scanner.nextLine();
		System.out.print("Enter the genre id: ");
		int genreId = Integer.parseInt(scanner.nextLine());
		gameDao.createNewGame(gameTitle, yearReleased, developer, genreId);
		
	}

}
