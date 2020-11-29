package introduction.rightturner;

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

}
