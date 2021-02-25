import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class mainProgram {
	static String fileA = "a.txt";
	static String fileB = "b.txt";
	static String fileC = "c.txt";
	static String fileD = "d.txt";
	static String fileE = "e.txt";
	
	static String outputA = "a_output.txt";
	static String outputB = "b_output.txt";
	static String outputC = "c_output.txt";
	static String outputD = "d_output.txt";
	static String outputE = "e_output.txt";
	
	static int totalTime = 0;
	static int intersections = 0;
	static int numRoads = 0;
	static int numCars = 0;
	static int points = 0;
	
	static map map;

	public static void main(String[] args) throws IOException {
		String filename = "";
		String outputFile = "";
		Scanner input = new Scanner(System.in);
		System.out.println("Please type the desired input. A, B, C, D, E");
		String desiredInput = input.next();
		input.close();
		if(desiredInput.equalsIgnoreCase("A")) {
			filename = fileA;
			outputFile = outputA;
		}
		else if(desiredInput.equalsIgnoreCase("B")) {
			filename = fileB;
			outputFile = outputB;
		}
		else if(desiredInput.equalsIgnoreCase("C")) {
			filename = fileC;
			outputFile = outputC;
		}
		else if(desiredInput.equalsIgnoreCase("D")) {
			filename = fileD;
			outputFile = outputD;
		}
		else if(desiredInput.equalsIgnoreCase("E")) {
			filename = fileE;
			outputFile = outputE;
		}
		FileReader fr = new FileReader(filename);
		
		try(BufferedReader br = new BufferedReader(fr)){
			String line = br.readLine();
			String[] numbers = line.split(" ");
			totalTime = Integer.parseInt(numbers[0]);
			intersections = Integer.parseInt(numbers[1]);
			numRoads = Integer.parseInt(numbers[2]);
			numCars = Integer.parseInt(numbers[3]);
			points = Integer.parseInt(numbers[4]);
			
			road[] roads = new road[numRoads];
			int count = 0;
			while(count<numRoads) {
				String[] split = line.split(" ");
				road current = new road(Integer.parseInt(split[0]), Integer.parseInt(split[1]), split[2], Integer.parseInt(split[1]));
				roads[count] = current;
				++count;
			}
			map = new map(roads, intersections);
			ArrayList<car> cars = new ArrayList<car>();
			while((line = br.readLine())!=null) {
				String[] split = line.split(" ");
				int size = Integer.parseInt(split[0]);
				road[] route = new road[size];
				for(int i=0; i<size; ++i) {
					route[i] = map.getRoad(split[i+1]);
				}
				car car = new car(route, size);
				cars.add(car);
			}
			
		}

	}

}
