package UI;

import recursion.winFactorizacion;
import recursion.winFibonacci;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class selectorRecursion extends selectorAbstract implements ActionListener {

	selectorRecursion() {
		this.buttonOne.addActionListener(this);
		this.buttonTwo.addActionListener(this);
		this.retornarButton.addActionListener(this);
		buttonOne.setText("Factorizacion");
		buttonTwo.setText("Fibonacci");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.retornarButton) {
			this.setVisible(false);
		}
		if(e.getSource() == this.buttonOne) {
			this.setVisible(false);
			this.setSize(400, 400);
			new winFactorizacion();
		}
		if(e.getSource() == this.buttonTwo) {
			this.setVisible(false);
			this.setSize(400, 400);
			new winFibonacci();
		}
	}
}
