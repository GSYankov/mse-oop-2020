package introduction.drawers.figures;

public class Square extends Figure {

	public Square(int x, int y, int width) {
		this.width = width;
		super.x = x;
		super.y = y;
	}

	private int width;

	public int getWidth() {
		return width;
	}

	public void setWidth(int size) {
		this.width = size;
	}

}
