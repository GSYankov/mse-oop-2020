package introduction.drawers.robots;

import introduction.drawers.figures.Figure;
import introduction.drawers.figures.Rectangle;
import introduction.rightturner.RightTurnerRobot;
import kareltherobot.Directions;

public class RectangleDrawerRobot extends RightTurnerRobot implements Drawer {

	public RectangleDrawerRobot(int street, int avenue, Direction direction, int beepers) {
		super(street, avenue, direction, beepers);
	}

	@Override
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
