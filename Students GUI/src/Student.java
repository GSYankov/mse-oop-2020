import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import contracts.Largeness;

public class Student extends Human implements Largeness {

	private String facNum;
	private int[] marks;
	private double marksAvg;
	private int photoHeight;
	private int photoWidth;

	public Student(String facNum, int[] marks, int photoHeight, int photoWidth, int height, int weight, String ucn,
			String name) {
		super(height, weight, ucn, name);
		this.facNum = facNum;
		this.marks = marks;
		this.marksAvg = IntStream.of(this.marks).sum() / this.marks.length;
		this.photoHeight = photoHeight;
		this.photoWidth = photoWidth;
	}
	
	public String getFacNum() {
		return this.facNum;
	}

	public double getMarksAvg() {
		return this.marksAvg;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

}
