package introduction.rightturner;

import kareltherobot.Robot;

/**
 * TBD
 * 
 * @author ivo.rusev
 *
 */
public class FancyRightTurner extends Robot {

	/**
	 * TBD
	 * 
	 * @param street
	 * @param avenue
	 * @param direction
	 */
	public FancyRightTurner(int street, int avenue, Direction direction) {
		super(street, avenue, direction, 0);
	}

	/**
	 * TBD.
	 */
	public void turnRight() {
		move();
		turnLeft();
		move();
		turnLeft();
		move();
		turnLeft();
		move();
	}

}
