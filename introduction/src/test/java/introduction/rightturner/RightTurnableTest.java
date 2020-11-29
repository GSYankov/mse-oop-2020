package introduction.rightturner;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import kareltherobot.Directions;
import kareltherobot.World;

public class RightTurnableTest {

	@Test
	public void testTurnRightable() {
		World.setSize(1, 1);
		World.setDelay(0);

		RightTurnable robotA = new RightTurner(1, 1, Directions.East);
		RightTurnable robotB = new RightTurnerFancy(1, 1, Directions.East);

		List<RightTurnable> roborts = Arrays.asList(robotA, robotB);
		for (RightTurnable rightTurnable : roborts) {
			rightTurnable.turnRight();
		}
	}
}
