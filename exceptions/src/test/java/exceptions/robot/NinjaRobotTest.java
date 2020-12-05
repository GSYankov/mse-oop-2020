package exceptions.robot;

import org.junit.Test;

import kareltherobot.Directions;

public class NinjaRobotTest {

	@Test(expected = EncounteredWallException.class)
	public void test() {
		NinjaRobot robot = new NinjaRobot(1, 1, Directions.West);
		robot.move();
	}

}
