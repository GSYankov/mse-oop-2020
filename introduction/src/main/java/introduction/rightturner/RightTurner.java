package introduction.rightturner;

import kareltherobot.Robot;

public class RightTurner extends Robot implements RightTurnable {

	private int street;
	private int avenue;

	public RightTurner(int street, int avenue, Direction direction) {
		super(street, avenue, direction, 0);
		this.street = street;
		this.avenue = avenue;
	}

	/**
	 * @param street the starting X
	 * @param avenue the starting Y
	 * @param
	 */
	public void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}

}
