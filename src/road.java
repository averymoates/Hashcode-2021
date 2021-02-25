
public class road {
	
	private int end = 0;
	private int start = 0;
	private String roadName = "";
	private int duration = 0;
	
	public road(int start, int end, String roadName, int duration) {
		this.start = start;
		this.end = end;
		this.roadName = roadName;
		this.duration = duration;
	}
	
	public String getRoadName() {
		return this.roadName;
	}

}
