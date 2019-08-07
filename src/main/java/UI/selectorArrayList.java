package UI;

import ArrayListAr.winAddInt;
import ArrayListAr.winLlenadoAutomatico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class selectorArrayList extends selectorAbstract implements ActionListener {

	selectorArrayList() {
		this.buttonOne.addActionListener(this);
		this.buttonTwo.addActionListener(this);
		this.retornarButton.addActionListener(this);
		this.buttonOne.setText("Añadir Valores");
		this.buttonTwo.setText("Agregado Automatico");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(this.getSize());
		if(e.getSource() == this.retornarButton) {
			this.setVisible(false);
		}
		if(e.getSource() == this.buttonOne) {
			this.setVisible(false);
			this.setSize(400, 400);
			new winAddInt();
		}
		if(e.getSource() == this.buttonTwo) {
			this.setVisible(false);
			this.setSize(400, 400);
			new winLlenadoAutomatico();
		}
	}
}
