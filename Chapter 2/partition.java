/* Write code to partition a linkedlist around a value x, such that all nodes less than x
come before all nodes greater than or equal to x. If x is contained within the list, the values
of x only need to be right after the elements less than x.  The partition element x can appear
anywhere in the "right partition"; it does not need to appear between the left and right partitions.
*/


/*To solve this I created a LinkedList for smaller than numbers, and larger than numbers, and
then merged them at the end
*/

class partitionLinkedList extends LinkedList
{
	public void partition(int parter)
	{
		Node smallroot = null;
		Node largeroot = null;
		Node smalls = null;
		Node larges = null;
		Node iterator = root;

		while(iterator != null) 
		{
			if((int) iterator.data < parter)
			{
				if(smallroot == null)
				{
					smalls = new Node(iterator.data);
					smallroot = smalls;
				}
				else 
				{
					smalls.next = new Node(iterator.data);
					smalls = smalls.next;
				}
			}
			else
			{
				if(largeroot == null)
				{
					larges = new Node(iterator.data);
					largeroot = larges;
				}
				else 
				{
					larges.next = new Node(iterator.data);
					larges = larges.next;
				}
			}
			iterator = iterator.next;
		}
		root = smallroot;
		smalls.next = largeroot;
	}
}

public class partition
{
	public static void main(String[] args)
	{
		partitionLinkedList input = new partitionLinkedList();
		input.add(3);
		input.add(5);
		input.add(8);
		input.add(5);
		input.add(10);
		input.add(2);
		input.add(1);
		System.out.println(input.toString());
		input.partition(5);
		System.out.println(input.toString());
	}
}