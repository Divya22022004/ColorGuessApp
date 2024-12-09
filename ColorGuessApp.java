import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorGuessApp extends JFrame {
    private JPanel colorPanel;
    private JLabel messageLabel;

    public ColorGuessApp() {
        // Set the frame properties
        setTitle("Guess what color!");
        setSize(250, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // Create and configure the color panel (circle)
        colorPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.GRAY);  // Default color is gray
                g.fillOval(50, 20, 100, 100);  // Draw the circle
            }
        };
        colorPanel.setPreferredSize(new Dimension(200, 150));
        add(colorPanel, BorderLayout.NORTH);

        // Message label
        messageLabel = new JLabel("Click a button.", JLabel.CENTER);
        add(messageLabel, BorderLayout.CENTER);

        // Button panel for color buttons + reset button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1));  // 2 rows (1 for color buttons, 1 for reset)

        // Inner panel for color buttons
        JPanel colorButtonsPanel = new JPanel();
        colorButtonsPanel.setLayout(new FlowLayout());

        // Red button
        JButton redButton = new JButton();
        redButton.setBackground(Color.RED);
        redButton.setPreferredSize(new Dimension(50, 50));
        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCircleColor(Color.RED, "Red");
            }
        });
        colorButtonsPanel.add(redButton);

        // Green button
        JButton greenButton = new JButton();
        greenButton.setBackground(Color.GREEN);
        greenButton.setPreferredSize(new Dimension(50, 50));
        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCircleColor(Color.GREEN, "Green");
            }
        });
        colorButtonsPanel.add(greenButton);

        // Blue button
        JButton blueButton = new JButton();
        blueButton.setBackground(Color.BLUE);
        blueButton.setPreferredSize(new Dimension(50, 50));
        blueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCircleColor(Color.BLUE, "Blue");
            }
        });
        colorButtonsPanel.add(blueButton);

        // Add color buttons to button panel
        buttonPanel.add(colorButtonsPanel);

        // Reset button
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetCircleColor();
            }
        });

        // Panel for reset button
        JPanel resetPanel = new JPanel();
        resetPanel.setLayout(new FlowLayout());
        resetPanel.add(resetButton);

        // Add reset button to button panel
        buttonPanel.add(resetPanel);

        // Add button panel to frame
        add(buttonPanel, BorderLayout.SOUTH);

        // Set visibility
        setVisible(true);
    }

    // Method to change the circle color and display the color name
    private void changeCircleColor(Color color, String colorName) {
        Graphics g = colorPanel.getGraphics();
        g.setColor(color);
        g.fillOval(50, 20, 100, 100);
        messageLabel.setText("Color: " + colorName);
    }

    // Method to reset the circle color
    private void resetCircleColor() {
        Graphics g = colorPanel.getGraphics();
        g.setColor(Color.GRAY);
        g.fillOval(50, 20, 100, 100);
        messageLabel.setText("Click a button.");
    }

    public static void main(String[] args) {
        new ColorGuessApp();
    }
}
