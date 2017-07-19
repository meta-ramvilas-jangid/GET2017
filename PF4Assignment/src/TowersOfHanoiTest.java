import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class TowersOfHanoiTest {

	@Test(expected = IllegalArgumentException.class)
	public void test() {
		TowersOfHanoi toh= new TowersOfHanoi();
		toh.calculateMoves("ab", "c", "z", 3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void test1() {
		TowersOfHanoi toh= new TowersOfHanoi();
		toh.calculateMoves("a", "c", "z", 0);
	}
	@Test(expected = IllegalArgumentException.class)
	public void test2() {
		TowersOfHanoi toh= new TowersOfHanoi();
		toh.calculateMoves("a", "c", "z", -2);
	}
	@Test
	public void test3() {
		TowersOfHanoi toh= new TowersOfHanoi();
		List<String> expected = toh.calculateMoves("a", "b", "c", 2);
		List<String> actual = new ArrayList<String>();
		actual.add("move top disk from a to c");
		actual.add("move top disk from a to b");
		actual.add("move top disk from c to b");
		assertArrayEquals(expected.toArray(), actual.toArray());
	}
	@Test
	public void test4() {
		TowersOfHanoi toh= new TowersOfHanoi();
		List<String> expected = toh.calculateMoves("a", "b", "c", 1);
		List<String> actual = new ArrayList<String>();
		actual.add("move top disk from a to b");
		assertArrayEquals(expected.toArray(), actual.toArray());
	}
	@Test
	public void test5() {
		TowersOfHanoi toh= new TowersOfHanoi();
		List<String> expected = toh.calculateMoves("a", "b", "c", 3);
		List<String> actual = new ArrayList<String>();
		actual.add("move top disk from a to b");
		actual.add("move top disk from a to c");
		actual.add("move top disk from b to c");
		actual.add("move top disk from a to b");
		actual.add("move top disk from c to a");
		actual.add("move top disk from c to b");
		actual.add("move top disk from a to b");
		assertArrayEquals(expected.toArray(), actual.toArray());
	}
}
