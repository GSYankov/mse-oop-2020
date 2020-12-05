package exceptions.drawers.robots;

import exceptions.drawers.figures.Figure;
import exceptions.drawers.figures.Rectangle;
import exceptions.robot.AdvancedRobot;
import kareltherobot.Directions;

public class RectangleDrawerRobot extends AdvancedRobot implements Drawer {

	public RectangleDrawerRobot(int street, int avenue, Direction direction, int beepers) {
		super(street, avenue, direction, beepers);
	}

	public void draw(Figure figure) {
		if (!(figure instanceof Rectangle)) {
			System.err.println("Unsupported parameter type");
			return;
		}

		Rectangle rectangle = (Rectangle) figure;

		moveTo(figure.getX(), figure.getY());
		turnTo(Directions.East);

		for (int i = 0; i < 4; i++) {
			int size = i % 2 == 0 ? rectangle.getWidth() : rectangle.getHeight();
			for (int j = 0; j < size; j++) {
				super.putBeeper();
				move();
			}
			turnLeft();
		}
		turnRight();
	}

}
