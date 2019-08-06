package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class selectorArrayList extends selectorAbstract implements ActionListener {

	selectorArrayList() {
		this.buttonOne.addActionListener(this);
		this.buttonTwo.addActionListener(this);
		this.retornarButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(this.getSize());
		if(e.getSource() == this.retornarButton) {
			this.setVisible(false);
		}
	}
}
