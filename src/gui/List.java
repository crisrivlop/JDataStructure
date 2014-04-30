package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;

public class List extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public List() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(12, 23, 600, 550);
		add(panel);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(654, 38, 117, 25);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Borrar");
		btnNewButton_1.setBounds(654, 75, 117, 25);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Buscar");
		btnNewButton_2.setBounds(654, 112, 117, 25);
		add(btnNewButton_2);

	}
}
