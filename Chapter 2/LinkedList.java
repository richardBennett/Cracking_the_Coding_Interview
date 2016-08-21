/* A basic linked list class. Throws some warnings because of the generics 
*/
class Node<T>
{
	Node next = null;
	T data;

	public Node(T d)
	{
		data = d;
	}
}

public class LinkedList<T>
{
	Node root;

	public LinkedList()
	{
		root = null;
	}

	public void add(T d)
	{
		Node end = new Node(d);
		if(root == null) root = end;
		else 
		{
			Node iteratorNode = root;
			while(iteratorNode.next != null)
			{
				iteratorNode = iteratorNode.next;
			}
			iteratorNode.next = end;
		}
	}

	public void addToFront(T d)
	{
		Node front = new Node(d);
		if(root == null) root = front;
		else
		{
			front.next = root;
			root = front;
		}
	}

	public void delete(T d)
	{
		
		if(root.data == d)
		{
			root = root.next;
			return;
		}

		Node iteratorNode = root;
		while(iteratorNode.next != null)
		{
			if(iteratorNode.next.data == d)
			{
				iteratorNode.next = iteratorNode.next.next;
			}
			iteratorNode = iteratorNode.next;
		}
	}

	public String toString()
	{
		
		StringBuilder output = new StringBuilder();
		Node iteratorNode = root;
		while(iteratorNode != null)
		{
			output.append(iteratorNode.data);
			output.append(" ");
			iteratorNode = iteratorNode.next;
		}
		String outputString = output.toString();
		if(outputString.isEmpty()) return ("Empty");
		else return outputString;
	}
}