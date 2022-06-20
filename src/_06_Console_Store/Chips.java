package _06_Console_Store;

import java.util.Random;

import javax.swing.JLabel;

public class Chips extends Food{
	public Chips() {
		if(new Random().nextBoolean()) {
			this.item = "chips1.jpg";
		}
		else {
			this.item = "chips2.jpg";
		}
	}

	@Override
	public JLabel getFood() {
		// TODO Auto-generated method stub
		return new JLabel(loadImage(this.item));
	}
}
