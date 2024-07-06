package api;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WeatherAppGUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField locationField;
    private JTextArea weatherDataArea;

    public WeatherAppGUI() {
        setTitle("Weather Information App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create GUI components
        JLabel locationLabel = new JLabel("Enter Location:");
        locationField = new JTextField(20);
        JButton fetchButton = new JButton("Fetch Weather Data");
        weatherDataArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(weatherDataArea);

        // Add components to the content pane
        JPanel contentPane = new JPanel();
        contentPane.add(locationLabel);
        contentPane.add(locationField);
        contentPane.add(fetchButton);
        contentPane.add(scrollPane);
        setContentPane(contentPane);

        // Action listener for the fetch button
        fetchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String location = locationField.getText();
                try {
                    String weatherData = WeatherAPIHandler.getWeatherData(location);
                    weatherDataArea.setText(weatherData);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(WeatherAppGUI.this, "Error fetching weather data", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WeatherAppGUI::new);
    }
}
