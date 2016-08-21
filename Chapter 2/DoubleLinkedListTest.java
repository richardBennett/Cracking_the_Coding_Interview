/*A test for the double linked list class
*/

public class DoubleLinkedListTest
{
	public static void main(String[] args)
	{
		DoubleLinkedList testList = new DoubleLinkedList();
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