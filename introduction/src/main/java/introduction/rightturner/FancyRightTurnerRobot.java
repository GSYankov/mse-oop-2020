package introduction.rightturner;

import kareltherobot.Robot;

/**
 * TBD
 * 
 * @author ivo.rusev
 *
 */
public class FancyRightTurnerRobot extends Robot implements RightTurner {

	/**
	 * TBD
	 * 
	 * @param street
	 * @param avenue
	 * @param direction
	 */
	public FancyRightTurnerRobot(int street, int avenue, Direction direction) {
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
