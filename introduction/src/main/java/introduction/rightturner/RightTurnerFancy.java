package introduction.rightturner;

import kareltherobot.Robot;

public class RightTurnerFancy extends Robot implements RightTurnable {

	public RightTurnerFancy(int street, int avenue, Direction direction) {
		super(street, avenue, direction, 0);
	}

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
