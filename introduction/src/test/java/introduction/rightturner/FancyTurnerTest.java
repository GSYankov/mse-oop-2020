package introduction.rightturner;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import kareltherobot.Directions;
import kareltherobot.World;

public class FancyTurnerTest {

	@Test
	public void testTurnRight() {
		World.setSize(3, 3);
		World.setVisible();
		World.setDelay(200);

		RightTurner robot1 = new FancyRightTurnerRobot(1, 1, Directions.East);
		RightTurner robot2 = new RightTurnerRobot(1, 1, Directions.East);
		List<RightTurner> asList = Arrays.asList(robot1, robot2);
		for (RightTurner rightTurner : asList) {
			rightTurner.turnRight();
		}
	}

}
