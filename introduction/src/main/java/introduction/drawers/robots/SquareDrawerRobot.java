package introduction.drawers.robots;

import introduction.drawers.figures.Figure;
import introduction.drawers.figures.Square;
import introduction.rightturner.RightTurnerRobot;
import kareltherobot.Directions;

/**
 * ToDo
 * 
 * @author ivo.rusev
 *
 */
public class SquareDrawerRobot extends RightTurnerRobot implements Drawer {

	/**
	 * ToDo
	 * 
	 * @param street
	 * @param avenue
	 * @param direction
	 * @param beepers
	 */
	public SquareDrawerRobot(int street, int avenue, Direction direction, int beepers) {
		super(street, avenue, direction, beepers);
	}

	/**
	 * Draws a square from lower left point.
	 * 
	 * @param sideLength the length of the side.
	 */
	@Override
	public void draw(Figure figure) {
		if (!(figure instanceof Square)) {
			System.err.println("Unsupported parameter type");
			return;
		}
		Square square = (Square) figure;

		moveTo(figure.getX(), figure.getY());
		turnTo(Directions.East);

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < square.getWidth(); j++) {
				super.putBeeper();
				move();
			}
			turnLeft();
		}
		turnRight();
	}

}
