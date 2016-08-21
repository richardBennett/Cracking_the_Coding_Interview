/*Implement an algorithm to find the kth to last element of a singly linked list
*/

public class return_kth_to_last
{
	/*The solution is to have a pointer point at the kth node down, and then increment a root pointer
	and the kth node down pointer until you reach the end.
	*/

	static class kth_list extends LinkedList
	{
		public Node kthToLast(int k)
		{
			Node end = root;
			Node kth = root;
			for(int i = 0; i < k; i++)
			{
				if(end == null) return null;
				else end = end.next;
			}

			while(end != null)
			{
				end = end.next;
				kth = kth.next;
			}
			return kth;
		}
	}

	public static void main(String[] args)
	{
		int k = Integer.parseInt(args[0]);

		kth_list listing = new kth_list();
		listing.add("T");
		listing.add("E");
		listing.add("S");
		listing.add("T");
		System.out.println(listing.kthToLast(k).data);
	}
}