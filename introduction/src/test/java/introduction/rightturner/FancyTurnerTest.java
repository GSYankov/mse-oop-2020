package introduction.rightturner;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import kareltherobot.Directions;
import kareltherobot.World;

public class FancyTurnerTest {

	@Test
	public void testPolymorphism() {
		World.setSize(3, 3);
		World.setDelay(0);

		RightTurner robot1 = new FancyRightTurnerRobot(1, 1, Directions.East);
		RightTurner robot2 = new RightTurnerRobot(1, 1, Directions.East);
		List<RightTurner> asList = Arrays.asList(robot1, robot2);
		for (RightTurner rightTurner : asList) {
			rightTurner.turnRight();
		}
	}

}
