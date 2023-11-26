package pojos;

public enum Course {
	DAC(80), DBDA(85), DITISS(76);

	private int minMarks;

	private Course(int minMarks) {
		this.minMarks = minMarks;
	}

	public int getMinMarks() {
		return minMarks;
	}

}
