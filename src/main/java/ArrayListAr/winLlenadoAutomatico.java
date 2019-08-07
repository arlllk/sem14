package ArrayListAr;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class winLlenadoAutomatico extends winAbstractArrayList {
	private final boolean[] activado = {false};
	private final boolean[] reactivado = {false};
	private final String STRING_BOTON = "Empezar a llenar";
	private ArrayList<Integer> arreglo = new ArrayList<>();
	private JLabel tiempoLabel = new JLabel("Ingrese el tiempo en milisegundos");
	private JTextField tiempo = new JTextField("1000");

	public winLlenadoAutomatico() {
		this.setTitle("Llenado automatico");
		this.calcular.setText(STRING_BOTON);
		this.labelIngresar.setText("Ingrese cantidad de valores a llenar");
		setUp();
		buildUI();
	}

	@Override
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
		gbc.gridy++;
		ingresos.add(tiempoLabel, gbc);
		gbc.gridy++;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		ingresos.add(tiempo, gbc);
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0, 0, 5, 0);
		gbc.gridy++;
		ingresos.add(capacidadLabel, gbc);
		gbc.gridy++;
		ingresos.add(tamannoLabel, gbc);
	}

	@Override
	protected void ejecutar() {
		bucle();
	}

	private void bucle() {
		this.calcular.setText("CANCELAR");
		if(activado[0])
			reactivado[0] = true;
		arreglo.clear();
		if(input.getText().isEmpty()) {
			input.setText("");
			return;
		}
		final int[] cantidad = {Integer.parseInt(input.getText())};
		input.setText("");
		final int[] i = {0};
		final int[] delay = {1000};
		String tiem = tiempo.getText();
		if(!tiem.isEmpty())
			delay[0] = Integer.parseInt(tiempo.getText());
		Timer t = new Timer(delay[0], g -> {
			if(i[0] < cantidad[0]) {
				arreglo.add(i[0]);
				winLlenadoAutomatico.this.ingresarValores();
				i[0]++;
				activado[0] = true;
			}
			if(reactivado[0]) {
				cantidad[0] = 0;
				activado[0] = false;
				reactivado[0] = false;
				this.calcular.setText(STRING_BOTON);
				this.out.setText("");
			}
			if(i[0] == cantidad[0] - 1) {
				this.calcular.setText(STRING_BOTON);
			}
		});
		t.start();
	}

	@Override
	protected ArrayList<Integer> calculos() {
		return arreglo;
	}
}
