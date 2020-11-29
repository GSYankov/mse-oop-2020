package introduction.rightturner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import kareltherobot.Directions;
import kareltherobot.World;

public class RightTurnerTest {

	@Test
	public void testTurnRight() {
		World.setSize(1, 1);
		World.setDelay(0);
		RightTurnerRobot robot = new RightTurnerRobot(1, 1, Directions.East);
		robot.turnRight();
		assertTrue(robot.facingSouth());

		FancyRightTurnerRobot fancyRobot = new FancyRightTurnerRobot(1, 1, Directions.East);
		fancyRobot.turnRight();
		assertTrue(fancyRobot.facingSouth());
	}

	@Test
	public void testMoveTo() {
		World.setSize(10, 10);
		World.setDelay(0);
		RightTurnerRobot robot = new RightTurnerRobot(1, 1, Directions.East);
		robot.moveTo(3, 3);
		assertEquals(3, robot.getStreet());
		assertEquals(3, robot.getAvenue());
		robot.moveTo(1, 1);
		assertEquals(1, robot.getStreet());
		assertEquals(1, robot.getAvenue());
		robot.moveTo(4, 3);
		assertEquals(3, robot.getStreet());
		assertEquals(4, robot.getAvenue());
	}

	@Test
	public void turnTo() {
		World.setSize(10, 10);
		World.setDelay(0);
		RightTurnerRobot robot = new RightTurnerRobot(1, 1, Directions.East);
		robot.turnTo(Directions.North);
		assertTrue(robot.facingNorth());
		robot.turnTo(Directions.South);
		assertTrue(robot.facingSouth());
	}

}
