package ArrayListAr;

import java.util.ArrayList;

public class winAddInt extends winAbstractArrayList {
	private ArrayList<Integer> numeros = new ArrayList<>();

	public winAddInt() {
		this.setName("Añadir Enteros");
		this.calcular.setText("Añadir");
		setUp();
		buildUI();
	}

	@Override
	protected ArrayList<Integer> calculos() {
		String ingreso = this.input.getText();
		if(ingreso.isEmpty())
			return numeros;
		numeros.add(Integer.parseInt(ingreso));
		this.input.setText("");
		return numeros;
	}
}
