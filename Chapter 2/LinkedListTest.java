/*A test for the linkedlist class
*/
public class LinkedListTest
{
	public static void main(String[] args)
	{
		LinkedList testList = new LinkedList();
		testList.add(42);
		testList.add(43);
		testList.addToFront(41);
		System.out.println(testList.toString());
		testList.delete(42);
		System.out.println(testList.toString());
		testList.delete(41);
		System.out.println(testList.toString());
		testList.delete(43);
		System.out.println(testList.toString());

	}
}