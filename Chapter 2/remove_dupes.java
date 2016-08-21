/* Write code to remove duplicates from an unsorted linked list
FOLLOW UP
*/ 

//Extended LinkedList class to remove duplicates
class rmLinkedList extends LinkedList
{
	//Using a runner checks the rest of the list for duplicates and removes them
	//Could also be solved using a hash table for each character and deleting the
	//current node if the table already had that character counted.
	public void remove_duplicates()
	{
		if(root.next == null) return;

		Node original = root;
		Node check = root;

		while(original != null)
		{
			while(check.next != null)
			{
				if(check.next.data == original.data)
				{
					check.next = check.next.next;
				}
				check = check.next;
			}
			original = original.next;
			check = original;
		}
	}
}

public class remove_dupes
{
	public static void main(String[] args)
	{
		rmLinkedList listing = new rmLinkedList();
		listing.add('F');
		listing.add('O');
		listing.add('L');
		listing.add('L');
		listing.add('O');
		listing.add('W');
		listing.add(' ');
		listing.add('U');
		listing.add('P');
		
		System.out.println(listing.toString());
		listing.remove_duplicates();
		System.out.println(listing.toString());
	}
}