import java.util.List;

public class MetroPopulation {
	public static void main(String[] args) {
		Heap shrink = new Heap();
		Heap growth = new Heap();
		Heap state = new Heap();
		String file = "75f647c2ac77-Metropolitan_Populations_2010-2012_.csv";

		Parser p = new Parser(file, shrink, growth, state);
		p.parseFile();
		List<String> list = shrink.topCities(5);
		System.out.println("Top 5 cities with shrinking %");
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println("Top 5 cities with growth %");
		list = growth.topCities(5);
		for (String s : list) {
			System.out.println(s);
		}

		System.out.println("Top 5 States with growth %");
		list = state.topCities(5);
		for (String s : list) {
			System.out.println(s);
		}
	}

}
