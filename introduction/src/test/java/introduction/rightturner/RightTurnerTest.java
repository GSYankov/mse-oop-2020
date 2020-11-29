package introduction.rightturner;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import kareltherobot.Directions;
import kareltherobot.World;

public class RightTurnerTest {

	@Test
	public void testTurnRight() {
		World.setSize(5, 5);
		World.setVisible();
		RightTurner robot = new RightTurner(1, 1, Directions.East);
		robot.turnRight();
		assertTrue(robot.facingSouth());

	}

	@Test
	public void testTurnRightFancy() {
		World.setSize(5, 5);
		World.setDelay(0);
		RightTurnerFancy robot = new RightTurnerFancy(1, 1, Directions.East);
		robot.turnRight();
		assertTrue(robot.facingSouth());
	}
}
