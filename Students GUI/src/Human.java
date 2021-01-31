import contracts.Largeness;

public class Human implements Largeness{
	
	private int height;
	private int weight;
	private String ucn;
	private String name;

	public Human(int height, int weight, String ucn, String name) {
		this.height = height;
		this.weight = weight;
		this.ucn = ucn;
		this.name = name;
	}
	
	public String getUcn() {
		return this.ucn;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public int getWeight() {
		// TODO Auto-generated method stub
		return this.weight;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	

}
