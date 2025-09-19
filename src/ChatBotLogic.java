import Project.ConnectionProvider;
import java.sql.*;

public class ChatBotLogic {

    public static String handleGreeting() {
        return "Hello! How can I help you today?\n1. Sports News\n2. Sports Score\n3. Practice Techniques";
    }

    // Fetch the list of games from the database
    public static String fetchGameNames() {
        StringBuilder gamesList = new StringBuilder("Please choose a game:\n");

        try (Connection con = ConnectionProvider.getCon()) {
            String query = "SELECT gamename FROM games";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            // Fetch the games from the database and append to response
            while (rs.next()) {
                gamesList.append(rs.getString("gamename")).append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            gamesList = new StringBuilder("Error fetching game names.");
        }

        return gamesList.toString();
    }

    // Handle sports news for a specific game and fetch all related news
    public static String handleSportsNews(String game) {
        StringBuilder response = new StringBuilder("Sports News for " + game + ":");
        try (Connection con = ConnectionProvider.getCon()) {
            String query = "SELECT date, details FROM news WHERE game = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, game);
            ResultSet rs = pstmt.executeQuery();

            boolean newsFound = false;
            while (rs.next()) {
                newsFound = true;
                response.append("\n\nDate: ").append(rs.getDate("date"))
                        .append("\nDetails: ").append(rs.getString("details"));
            }
            if (!newsFound) {
                response = new StringBuilder("No news found for " + game + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response = new StringBuilder("Error retrieving news for " + game + ".");
        }

        return response.toString();
    }

    // Handle sports scores for a game
    public static String handleSportsScore(String game, String homeTeam, String awayTeam) {
        StringBuilder response = new StringBuilder("Scores for " + game + " between " + homeTeam + " and " + awayTeam + ": ");
        try (Connection con = ConnectionProvider.getCon()) {
            String query = "SELECT date, league, home, away, status FROM score WHERE game = ? AND home = ? AND away = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, game);
            pstmt.setString(2, homeTeam);
            pstmt.setString(3, awayTeam);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                response.append("\nDate: ").append(rs.getDate("date"))
                        .append("\nLeague: ").append(rs.getString("league"))
                        .append("\nHome Team: ").append(rs.getString("home"))
                        .append("\nAway Team: ").append(rs.getString("away"))
                        .append("\nStatus: ").append(rs.getString("status"));
            } else {
                response = new StringBuilder("No scores found for the match between " + homeTeam + " and " + awayTeam + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response = new StringBuilder("Error retrieving scores for the match between " + homeTeam + " and " + awayTeam + ".");
        }

        return response.toString();
    }

    // Handle practice techniques for a specific game
    public static String handlePracticeTechniques(String game) {
        StringBuilder response = new StringBuilder("Practice techniques for " + game + ":");
        try (Connection con = ConnectionProvider.getCon()) {
            String query = "SELECT technical FROM tech WHERE game = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, game);
            ResultSet rs = pstmt.executeQuery();

            boolean techniqueFound = false;
            while (rs.next()) {
                techniqueFound = true;
                response.append("\n- ").append(rs.getString("technical"));
            }
            if (!techniqueFound) {
                response = new StringBuilder("No practice techniques found for " + game + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response = new StringBuilder("Error retrieving practice techniques for " + game + ".");
        }

        return response.toString();
    }
}
