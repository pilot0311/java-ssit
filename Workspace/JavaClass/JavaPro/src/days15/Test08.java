package days15;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test08 {

	public static void main(String[] args) {
		String n = "keNik";
		String m = "kKnie";

		n = n.toUpperCase().chars().sorted()
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		m = Stream.of(m.toUpperCase().split("")).sorted().collect(Collectors.joining());

		System.out.println(n + "/" + m);
		System.out.println(n.equals(m));
	} // main
}
