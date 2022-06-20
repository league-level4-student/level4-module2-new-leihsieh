package _06_Console_Store;

import java.util.Random;

import javax.swing.JLabel;

public class Cake extends Food{
	public Cake() {
		if(new Random().nextBoolean()) {
			this.item = "cake1.jpg";
		}
		else {
			this.item = "cake2.jpg";
		}
	}

	@Override
	public JLabel getFood() {
		// TODO Auto-generated method stub
		return new JLabel(loadImage(this.item));
	}
}
