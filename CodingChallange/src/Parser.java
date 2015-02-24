import java.io.*;
import java.util.*;

/**
 * @author Shailesh
 * This class is parsing the file and performing logic
 *
 */
public class Parser {
	

	private String file;
	private Heap shrink, growth, state;
	HashMap<String, Double> hm2010 = new HashMap<String, Double>();
	HashMap<String, Double> hm2012 = new HashMap<String, Double>();

	public Parser(String file, Heap minHeap, Heap maxHeap, Heap state) {
		this.file = file;
		this.shrink = minHeap;
		this.growth = maxHeap;
		this.state = state;

	}

	public void parseFile() {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(file));
			br.readLine();
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] lines = line.split(cvsSplitBy);
				stateCumulativeGrowth(lines);

				
				double d = Double.parseDouble(lines[4])
						- Double.parseDouble(lines[2]);
				double change = percentChange(Double.parseDouble(lines[4]),
						Double.parseDouble(lines[2]));
				if (d > 0)
					growth.add(change, lines[0], lines[1]);
				else
					shrink.add(change, lines[0], lines[1]);

			}

			for (String s : hm2012.keySet()) {
				state.add(percentChange(hm2012.get(s), hm2010.get(s)), "", s);
				// System.out.println(s+" "+hm2012.get(s)+" "+hm2010.get(s));

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void stateCumulativeGrowth(String[] lines) {
		if (hm2012.containsKey(lines[1])) {
			hm2012.put(lines[1],
					hm2012.get(lines[1]) + Double.parseDouble(lines[4]));
			hm2010.put(lines[1],
					hm2010.get(lines[1]) + Double.parseDouble(lines[2]));
		} else {
			hm2012.put(lines[1], Double.parseDouble(lines[4]));
			hm2010.put(lines[1], Double.parseDouble(lines[2]));
		}

	}

	private double percentChange(double a, double b) {
		try {

			return ((Math.abs((a - b)) / b) * 100);
		} catch (Exception e) {
			return 0;
		}
	}

}
