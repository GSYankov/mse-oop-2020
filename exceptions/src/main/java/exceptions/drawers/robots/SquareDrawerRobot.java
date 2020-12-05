package exceptions.drawers.robots;

import exceptions.drawers.figures.Figure;
import exceptions.drawers.figures.Square;
import exceptions.robot.AdvancedRobot;
import kareltherobot.Directions;

/**
 * ToDo
 * 
 * @author ivo.rusev
 *
 */
public class SquareDrawerRobot extends AdvancedRobot implements Drawer {

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
				if (!anyBeepersInBeeperBag()) {
					throw new NoBeepersInBagException("Out of beepers");
				}
				super.putBeeper();
				move();
			}
			turnLeft();
		}
		turnRight();
	}

}
