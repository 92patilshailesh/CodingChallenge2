import java.util.*;


/**
 * @author Shailesh
 * Heap class is to get top 5 elements i.e.cities/states
 *
 */
public class Heap {
	
	private List<Node> list;

	public Heap() {
		list = new ArrayList<Node>();
		list.add(null);

	}

	public void add(double d, String city, String state) {
		Node n = new Node(d, city, state);
		int len = list.size();
		list.add(n);
		balanceHeap(len);
	}

	public int size() {
		return list.size() - 1;
	}

	private int left(int i) {
		return 2 * i;
	}

	private int right(int i) {
		return 2 * i + 1;
	}

	private void balanceHeap(int i) {
		if (i >= 1) {
			maxHeapify(i);
			i = (int) Math.floor((i) / 2);
			balanceHeap(i);
		}
	}

	private void maxHeapify(int i) {
		int largest = i;
		int left = left(i);
		int right = right(i);
		
		if (left < list.size()
				&& (list.get(left).lessThanOrEquals(list.get(i)))) {
			largest = i;
		} else {
			if (left < list.size())
				largest = left;
		}
		if (right < list.size()
				&& !(list.get(right).lessThanOrEquals(list.get(largest)))) {
			largest = right;
		}
		if (i != largest) {
			swap(i, largest);
			maxHeapify(largest);
		}
	}

	private void swap(int i, int j) {
		Node temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);

	}

	private String delete(int index) {
		String data = list.get(index).toString();
		swap(index, list.size() - 1);
		list.remove(list.size() - 1);
		maxHeapify(index);
		return data;
	}

	public List<String> topCities(int n) {
		List<String> topCities = new ArrayList<String>();
		List<Node> tempList = new ArrayList<Node>();
		tempList.addAll(list);

		while (n > 0) {
			try {

				topCities.add(delete(1));

			} catch (Exception e) {
				break;
			}
			n--;
		}
		list.clear();
		list.addAll(tempList);

		return topCities;
	}

}
