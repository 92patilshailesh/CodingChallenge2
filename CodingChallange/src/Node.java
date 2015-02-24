import java.text.DecimalFormat;

/**
 * @author Shailesh
 * Node class is for inserting a Node in the Heap.
 *
 */
public class Node {
	private double differnce;
	String city = "";
	String state = "";

	public Node(double d, String city, String state) {
		differnce = d;
		this.city = city;
		this.state = state;
	}

	@Override
	public boolean equals(Object n) {
		try {
			return differnce == ((Node) n).differnce;
		} catch (ClassCastException c) {
			return false;
		}
	}

	public double differnce() {
		return differnce;
	}

	public boolean lessThanOrEquals(Node n) {
		return differnce <= n.differnce;
	}

	@Override
	public String toString() {
		if(!city.equalsIgnoreCase(""))
		return city + "," + state + " has change of "
				+ new DecimalFormat("#.##").format(differnce) + "%";
		return "\""+state.trim() + " has change of "
		+ new DecimalFormat("#.##").format(differnce) + "%";
	}
}
