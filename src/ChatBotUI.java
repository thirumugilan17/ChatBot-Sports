import Project.ConnectionProvider;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChatBotUI {

    public JFrame frame;  // Make sure this is public so it can be accessed from outside

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    private String currentAction = "";
    private String selectedGame = "";  // Store the selected game

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ChatBotUI window = new ChatBotUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ChatBotUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        // Set the frame to maximized but keep the decorations (title bar and control buttons)
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));  // Adjust font size for better readability
        frame.getContentPane().add(new JScrollPane(chatArea), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.SOUTH);

        inputField = new JTextField();  // Create inputField without initial text
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));  // Adjust font size for better readability
        inputField.setColumns(50);  // Increase the number of columns to make it larger
        inputField.setPreferredSize(new Dimension(0, 40));  // Increase the height of the text field
        panel.add(inputField);

        // Add a placeholder to the inputField
        inputField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (inputField.getText().equals("Hi there! Type a message...")) {
                    inputField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (inputField.getText().isEmpty()) {
                    inputField.setText("Hi there! Type a message...");
                }
            }
        });
        inputField.setText("Hi there! Type a message...");  // Set placeholder text

        sendButton = new JButton("Send");
        sendButton.setFont(new Font("Arial", Font.PLAIN, 16));  // Adjust font size for better readability
        panel.add(sendButton);

        sendButton.addActionListener(e -> sendMessage());

        // Add initial greeting message to chat area
        chatArea.append("Bot: Hi there! How can I assist you today?\n");
    }

    private void sendMessage() {
        String userInput = inputField.getText().trim();
        if (!userInput.isEmpty() && !userInput.equals("Hi there! Type a message...")) {
            chatArea.append("You: " + userInput + "\n");

            String botResponse = handleUserInput(userInput);
            chatArea.append("Bot: " + botResponse + "\n");

            inputField.setText("");  // Clear the text field after sending the message
        }
    }

    private String handleUserInput(String userInput) {
        // Handle the "back" command to reset to the main menu
        if (userInput.equalsIgnoreCase("back")) {
            currentAction = "";
            return ChatBotLogic.handleGreeting();
        }

        // Handle the "exit" command to close ChatBotUI and show Login form
        if (userInput.equalsIgnoreCase("exit")) {
            closeChatBot();
            return "";
        }

        // Basic greetings and actions
        if (userInput.equalsIgnoreCase("hello") || userInput.equalsIgnoreCase("hi")) {
            return ChatBotLogic.handleGreeting();
        } else if (userInput.equalsIgnoreCase("sports news")) {
            currentAction = "sports_news";
            return "Please choose a game:\n" + ChatBotLogic.fetchGameNames();
        } else if (userInput.equalsIgnoreCase("sports score")) {
            currentAction = "sports_score";
            return "Please choose a game:\n" + ChatBotLogic.fetchGameNames();
        } else if (userInput.equalsIgnoreCase("practice techniques")) {
            currentAction = "practice_techniques";
            return "Please choose a game:\n" + ChatBotLogic.fetchGameNames();
        }

        // Handle user inputs based on current action
        switch (currentAction) {
            case "sports_news":
                return ChatBotLogic.handleSportsNews(userInput);
            case "sports_score":
                selectedGame = userInput.trim();
                currentAction = "enter_teams";
                return "Please enter the home team and away team, separated by a comma (e.g., 'Team A, Team B').";
            case "enter_teams":
                String[] teams = userInput.split(",");
                if (teams.length == 2) {
                    String homeTeam = teams[0].trim();
                    String awayTeam = teams[1].trim();
                    return ChatBotLogic.handleSportsScore(selectedGame, homeTeam, awayTeam);
                } else {
                    return "Please enter both home and away team names separated by a comma.";
                }
            case "practice_techniques":
                return ChatBotLogic.handlePracticeTechniques(userInput);
            default:
                return "I didn't understand that. Please try again.";
        }
    }

    private void closeChatBot() {
        frame.dispose();  // Close the ChatBotUI window
        // Show the Login form
        Login login = new Login();
        login.setVisible(true);
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }
}
