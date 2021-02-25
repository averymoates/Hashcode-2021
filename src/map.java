import java.util.ArrayList;

public class map {
	
	private ArrayList<road> roadMap = new ArrayList<road>();
	
	public map(road[] roads, int intersection) {
		for(int i=0; i<intersection; ++i) {
			roadMap.add(roads[i]);
		}
	}
	
	public road getRoad(String roadName) {
		road road = null;
		for(int i=0; i<roadMap.size(); ++i) {
			if(roadName.equals(roadMap.get(i).getRoadName())) {
				road = roadMap.get(i);
			}
		}
		return road;
	}

}
