package Recursion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class winAbstractRecursion extends JFrame implements ActionListener {
	protected final int COLUMN_SIZE_OF_OUTPUT = 30;

	JLabel lInput = new JLabel("Ingrese un numero");
	JTextField input = new JTextField();

	JTextArea out = new JTextArea(1, COLUMN_SIZE_OF_OUTPUT);
	JButton calcular = new JButton("Calcular");

	JScrollPane outPane = new JScrollPane(out, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	protected void setUp() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		this.setMinimumSize(new Dimension(450, 220));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		calcular.addActionListener(this);

		out.setLineWrap(true);
		out.setEditable(false);

		outPane.setSize(out.getSize());

		this.pack();

		this.input.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
					ingresarValores();
				if(!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
	}

	protected void buildUI() {
		final int MARGEN_TOP = 30;
		final int MARGEN_BOTTOM = 30;
		final int MARGEN_LEFT = 10;
		final int MARGEN_RIGHT = 10;
		final int DISTANCIA_ENTRE_Y = 20;
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(MARGEN_TOP, MARGEN_LEFT, DISTANCIA_ENTRE_Y, 0);

		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.weightx = 2;
		//gbc.weighty = 1;
		add(lInput, gbc);
		gbc.gridx++;
		gbc.weightx = 80;
		gbc.insets = new Insets(MARGEN_TOP, 0, DISTANCIA_ENTRE_Y, MARGEN_RIGHT);
		add(input, gbc);
		gbc.insets = new Insets(0, MARGEN_LEFT, DISTANCIA_ENTRE_Y, MARGEN_RIGHT);
		gbc.weightx = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		add(outPane, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.gridy++;
		gbc.insets = new Insets(0, MARGEN_LEFT, MARGEN_BOTTOM, MARGEN_RIGHT);
		add(calcular, gbc);
	}

	protected void ingresarValores() {
		int filas = 1;
		String resultado = calculos();
		if(resultado.length() >= COLUMN_SIZE_OF_OUTPUT) {
			filas = Math.min(resultado.length() / COLUMN_SIZE_OF_OUTPUT, 10);
		}
		out.setColumns(COLUMN_SIZE_OF_OUTPUT);
		out.setRows(filas);
		out.setText(resultado);
		outPane.setSize(out.getSize());
		this.pack();
		this.setLocationRelativeTo(null);
		input.setText("");
		out.setText(resultado);
		out.setCaretPosition(0);
	}

	public abstract String calculos();

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.calcular) {
			ingresarValores();
		}
	}
}
