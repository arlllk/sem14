package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class mainWin extends JFrame implements ActionListener, ComponentListener {
	private static final long serialVersionUID = 1L;
	private JButton ArrayListButton = new JButton("ArrayList");
	private JButton RecursividadButton = new JButton("Recursividad");
	private JButton CloseButton = new JButton("SALIR");
	private GridBagConstraints gbc = new GridBagConstraints();
	private selectorArrayList array = new selectorArrayList();
	private selectorRecursion recursion = new selectorRecursion();

	private int counterArray = 0;
	private int counterRecursion = 0;

	private mainWin() {
		super("Menu");
		setUp();
		buildUI();
	}

	public static void main(String[] args) {
		new mainWin();
	}

	private void setUp() {
		this.setUndecorated(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		this.setSize(380, 160);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		this.recursion.addComponentListener(this);
		this.array.addComponentListener(this);
		this.ArrayListButton.addActionListener(this);
		this.RecursividadButton.addActionListener(this);
		this.CloseButton.addActionListener(this);
	}

	private void buildUI() {
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 90;
		this.add(ArrayListButton, gbc);
		gbc.gridx++;
		this.add(RecursividadButton, gbc);
		gbc.gridy++;
		gbc.gridx = 0;
		gbc.weighty = 10;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		this.add(CloseButton, gbc);
	}

	private void onClose() {
		this.array.dispose();
		this.recursion.dispose();
		this.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.CloseButton) {
			onClose();
		}
		if(e.getSource() == this.ArrayListButton) {
			array.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource() == this.RecursividadButton) {
			recursion.setVisible(true);
			this.setVisible(false);
		}
	}

	@Override
	public void componentResized(ComponentEvent e) {
		if(e.getSource() == this.array) {
			counterArray++;
			if(counterArray > 1) {
				onClose();
			}
		}
		if(e.getSource() == this.recursion) {
			counterRecursion++;
			if(counterRecursion > 1) {
				onClose();
			}
		}
		//onClose(); //DONT WORK :(
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		System.out.println("Objeto movido we");
	}

	@Override
	public void componentShown(ComponentEvent e) {
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		if(e.getSource() == this.array) {
			this.setVisible(true);
		}
		if(e.getSource() == this.recursion) {
			this.setVisible(true);
		}
	}
}