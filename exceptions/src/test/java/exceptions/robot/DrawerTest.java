package exceptions.robot;

import org.junit.Test;

import exceptions.drawers.figures.Square;
import exceptions.drawers.robots.NoBeepersInBagException;
import exceptions.drawers.robots.SquareDrawerRobot;
import kareltherobot.Directions;
import kareltherobot.World;

public class DrawerTest {

	@Test(expected = NoBeepersInBagException.class)
	public void test() {
		World.setSize(10, 10);
		World.setDelay(0);
		SquareDrawerRobot robot = new SquareDrawerRobot(1, 1, Directions.North, 2);
		robot.draw(new Square(2, 2, 4));
	}

}
