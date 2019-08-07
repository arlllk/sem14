package recursion;

public class winFibonacci extends winAbstractRecursion {
	public winFibonacci() {
		this.setTitle("Fibonachi");
		setUp();
		buildUI();
	}

	@Override
	public String calculos() {
		if(this.input.getText().isEmpty())
			return "";
		long numero = Long.parseLong(this.input.getText());
		String resultado = String.valueOf(fibonachi(numero));
		return "El n° " + numero + " valor en Fibonacci es: " + resultado;
	}

	private long fibonachi(long numero) {
		cantidadDeRecursiones++;
		if(numero == 0)
			return 0;
		if(numero == 1) {
			return 1;
		}
		return fibonachi(numero - 1) + fibonachi(numero - 2);
	}
}



