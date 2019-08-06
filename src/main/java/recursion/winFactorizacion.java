package recursion;

import java.math.BigInteger;

public class winFactorizacion extends winAbstractRecursion {

	public winFactorizacion() {
		this.setTitle("Factorizacion");
		setUp();
		buildUI();
	}

	@Override
	public String calculos() {
		if(this.input.getText().isEmpty())
			return "";
		if(this.input.getText().charAt(0) == '0') {
			input.setText("");
			return "";
		}
		int numero = Integer.parseInt(this.input.getText());
		return String.valueOf(factorizar(BigInteger.valueOf(numero)));
	}

	private BigInteger factorizar(BigInteger numero) {
		if(numero.compareTo(BigInteger.valueOf(1)) == 0) {
			return BigInteger.valueOf(1);
		}
		return numero.multiply(factorizar(numero.subtract(BigInteger.valueOf(1))));
	}
}
