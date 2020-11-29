package introduction.rightturner;

import kareltherobot.Robot;

/**
 * Robot that allows right turning.
 * 
 * @author ivo.rusev
 *
 */
public class RightTurner extends Robot {

	/**
	 * Creates a new robot.
	 * 
	 * @param street    the starting X
	 * @param avenue    the starting Y
	 * @param direction the direction the robot is initially facing
	 */
	public RightTurner(int street, int avenue, Direction direction) {
		super(street, avenue, direction, 0);
	}

	/**
	 * Turns the robot right.
	 */
	public void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}

}
