import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("BorderLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 100);
        frame.setLayout(new BorderLayout());

        // Create a panel for the top row (textbox and button)
        JPanel topPanel = new JPanel(new BorderLayout());
        JTextField textField = new JTextField();
        //textField.setPreferredSize(new Dimension(150, 25)); // Set desired size
        JButton button = new JButton("Submit");

        topPanel.add(textField, BorderLayout.WEST);
        topPanel.add(button, BorderLayout.EAST);

        // Create the label for the center
        JLabel label = new JLabel("Result will appear here", SwingConstants.CENTER);

        // Add components to the frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(label, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }
}
