package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

abstract class selectorAbstract extends JFrame implements ActionListener {
	JButton buttonOne = new JButton("1");
	JButton buttonTwo = new JButton("2");
	JButton retornarButton = new JButton("Retornar");

	selectorAbstract() {
		super("Elige");
		setUp();
		buildUI();
	}

	private void setUp() {
		this.setLayout(new GridBagLayout());
		this.setAlwaysOnTop(true);
		this.setUndecorated(true);
		this.setResizable(false);
		this.setVisible(false);
		this.setSize(350, 170);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	private void buildUI() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 90;
		gbc.weightx = 1;
		add(buttonOne, gbc);
		gbc.gridx++;
		add(buttonTwo, gbc);
		gbc.gridy++;
		gbc.gridx = 0;
		gbc.weighty = 10;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(retornarButton, gbc);
	}
}
