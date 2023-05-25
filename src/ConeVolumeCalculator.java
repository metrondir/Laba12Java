import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ConeVolumeCalculator extends JFrame implements ActionListener {
    private JTextField radiusField;
    private JTextField heightField;
    private JLabel resultLabel;

    public ConeVolumeCalculator() {
        setTitle("Cone Volume Calculator");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the components
        JLabel radiusLabel = new JLabel("Radius:");
        radiusField = new JTextField(10);
        JLabel heightLabel = new JLabel("Height:");
        heightField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        resultLabel = new JLabel();

// Create the layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Use GridBagLayout for more precise control
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(15, 15, 15, 15); // Add spacing between components

// Add components to the panel with custom constraints
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(radiusLabel, constraints);

        constraints.gridx = 1;
        panel.add(radiusField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(heightLabel, constraints);

        constraints.gridx = 1;
        panel.add(heightField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        panel.add(calculateButton, constraints);

        constraints.gridy = 3;
        panel.add(resultLabel, constraints);

// Set preferred size of the panel

// Add the panel to the frame
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Calculate")) {
            try {
                // Get the values from the text fields
                double radius = Double.parseDouble(radiusField.getText());
                double height = Double.parseDouble(heightField.getText());

                // Check for negative values
                if (radius < 0 || height < 0) {
                    throw new NumberFormatException("Negative values are not allowed.");
                }

                // Calculate the volume of the cone
                double volume = (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;

                // Display the result
                resultLabel.setText("Volume: " + volume);
            } catch (NumberFormatException ex) {
                // Handle the exception and display an error message
                resultLabel.setText("Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ConeVolumeCalculator().setVisible(true);
            }
        });
    }
}