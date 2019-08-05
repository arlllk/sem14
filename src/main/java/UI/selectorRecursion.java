package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class selectorRecursion extends selectorAbstract implements ActionListener {

	selectorRecursion() {
		this.buttonOne.addActionListener(this);
		this.buttonTwo.addActionListener(this);
		this.retornarButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.retornarButton) {
			this.setVisible(false);
		}
	}
}
