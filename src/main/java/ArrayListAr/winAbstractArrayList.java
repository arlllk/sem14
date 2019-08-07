package ArrayListAr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Field;
import java.util.ArrayList;

public abstract class winAbstractArrayList extends JFrame implements ActionListener {
	private final int ROWS = 30;
	private final int COLUMNS = 20;

	JLabel labelIngresar = new JLabel("Ingrese un numero", JLabel.CENTER);
	JTextField input = new JTextField(COLUMNS);
	JButton calcular = new JButton("Calcular");

	JLabel capacidadLabel = new JLabel();
	JLabel tamannoLabel = new JLabel();

	JPanel ingresos = new JPanel();

	JTextArea out = new JTextArea(ROWS, COLUMNS);
	private JScrollPane paneOut = new JScrollPane(out, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	void setUp() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(510, 600));
		this.setLayout(new GridBagLayout());
		this.setEnabled(true);
		this.setVisible(true);
		this.setResizable(true);
		paneOut.setSize(out.getSize());

		ingresos.setLayout(new GridBagLayout());

		this.pack();
		this.setLocationRelativeTo(null);

		input.setVisible(true);

		out.setLineWrap(true);
		out.setEditable(false);

		calcular.addActionListener(this);

		input.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
					ejecutar();
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

	protected void buildPanelIngresos() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.weighty = 1;
		gbc.weightx = 1;
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.insets = new Insets(0, 0, 20, 0);
		ingresos.add(labelIngresar, gbc);
		gbc.gridy++;
		ingresos.add(input, gbc);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridy++;
		gbc.insets = new Insets(0, 0, 50, 0);
		ingresos.add(calcular, gbc);
		gbc.insets = new Insets(0, 0, 5, 0);
		gbc.gridy++;
		ingresos.add(capacidadLabel, gbc);
		gbc.gridy++;
		ingresos.add(tamannoLabel, gbc);

	}

	void buildUI() {
		buildPanelIngresos();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridheight = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy = 0;
		gbc.weighty = 1;

		int MARGEN_TOP = 30;
		int MARGEN_BOTTOM = 30;
		int MARGEN_LEFT = 10;
		int DISTANCIA_ENTRE_X = 20;
		gbc.insets = new Insets(MARGEN_TOP, MARGEN_LEFT, MARGEN_BOTTOM, DISTANCIA_ENTRE_X);
		gbc.gridx = 0;
		gbc.weightx = 20;
		this.add(ingresos, gbc);

		//gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx++;
		int MARGEN_RIGHT = 10;
		gbc.insets = new Insets(MARGEN_TOP, 0, MARGEN_BOTTOM, MARGEN_RIGHT);
		gbc.weightx = 80;
		add(paneOut, gbc);
	}

	protected void ejecutar() {
		ingresarValores();
	}

	void ingresarValores() {
		ArrayList<Integer> resultado = calculos();
		StringBuilder resultadoString = new StringBuilder();
		for(Integer numero : resultado) {
			resultadoString.append(numero.toString()).append('\n');
		}
		if(resultadoString.length() > 0)
			resultadoString = new StringBuilder(resultadoString.substring(0, resultadoString.length() - 1));
		input.setText("");
		out.setText(resultadoString.toString());

		int tamanno = resultado.size();

		//ESTO ES FEO, MAL HECHO Y NO ENTIENDO NADA DE REFLEXIONES, PERO HACE LO SUYO
		int capacidad = 0;
		try {
			capacidad = getCapacity(resultado);
		} catch(Exception e) {
			e.printStackTrace();
		}
		tamannoLabel.setText("El tamanno del arrego es: " + tamanno);
		capacidadLabel.setText("La capacidad del arreglo es: " + capacidad);
	}

	//CODIGO DE INTERNET, PUEDE DESTRUIR EL MUNDO FACILMENTE, MUY DELICADO SI LO MINIMO FALLA
	private int getCapacity(ArrayList<Integer> al) throws Exception {
		Field field = ArrayList.class.getDeclaredField("elementData"); //NI IDEA
		field.setAccessible(true); //NOS DA ACCESO A EL CAMPO QUE QUEREMOS VER
		return ((Object[]) field.get(al)).length; //SI LO ENTIENDO BIEN ACA CONVIERTE A UN ARREGLO NORMAL
	}

	protected abstract ArrayList<Integer> calculos();

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.calcular) {
			ejecutar();
		}
	}
}
