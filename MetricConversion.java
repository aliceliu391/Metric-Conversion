package Lesson5;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MetricConversion implements ActionListener {
	JFrame window;
	JPanel panel;
	JLabel prompt, conversion;
	JComboBox conversions;
	JTextField toConvert;
	JButton convert;
	

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MetricConversion();
			}
		});

	}
	
	MetricConversion() {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		prompt = new JLabel("Select a conversion type: ");
		prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(prompt);
		
		String[] conversionTypes = {"inches to centimeters", "feet to meters", "gallons to litres", "pound to kilograms"};
		conversions = new JComboBox(conversionTypes);
		conversions.setAlignmentX(Component.CENTER_ALIGNMENT);
		conversions.addActionListener(this);
		panel.add(conversions);
		
		panel.add(Box.createRigidArea(new Dimension(20, 30)));
		conversion = new JLabel(" ");
		conversion.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(conversion);
		
		toConvert = new JTextField("1", 15);
		panel.add(toConvert);
		
		convert = new JButton("Convert");
		convert.setActionCommand("Convert");
		convert.addActionListener(this);
		convert.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(convert);
		
		window.setContentPane(panel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed (ActionEvent e) {
		
		if (e.getActionCommand().equals("Convert")) {
			double input = Double.valueOf(toConvert.getText());
			double result;

			
			String itemName = (String)conversions.getSelectedItem();
			
			if (itemName.equals("inches to centimeters")) {
				result = input * 2.54;
				conversion.setText(formatString("inch", "centimeters", input, result));
			}
			else if (itemName.equals("feet to meters")) {
				result = input * 0.3048;
				conversion.setText(formatString("feet", "meters", input, result));
			}
			else if (itemName.equals("gallons to litres")) {
				result = input * 4.5461;
				conversion.setText(formatString("gallons", "litres", input, result));
			}
			else {
				result = input * 0.4536;
				conversion.setText(formatString("pound", "kilograms", input, result));
			}
		}
	}
	
	private String formatString(String from, String to, double input, double result) {
		return String.format("%.2f %s = %.2f %s", input, from, result, to);
	}

}
