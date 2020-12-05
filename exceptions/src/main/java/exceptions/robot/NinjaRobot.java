package exceptions.robot;

/**
 * TBD.
 * 
 * @author ivo.rusev
 *
 */
public class NinjaRobot extends AdvancedRobot {

	public NinjaRobot(int street, int avenue, Direction direction) {
		super(street, avenue, direction);
	}

	/**
	 * Moves forwards, avoids walls.
	 */
	@Override
	public void move() {
		if (!frontIsClear()) {
			throw new EncounteredWallException("Was facing wall, stopping the action.");
		}
		super.move();
	}

}
