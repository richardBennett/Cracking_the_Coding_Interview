/*Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
For Example, the node c from the linked list "a->b->c->d->e->f" so that it becomes
"a->b->d->e->f"
*/

//detonode is just a node that can remove itself.
//It removes itself by copying the data of the next node, and the next of the next node
//which removes that next node from the list;
class detonode
{
	char data;
	detonode next;
	public detonode(char d)
	{
		data = d;
	}

	public void detonate()
	{
		if(this.next == null) 
		{
			System.out.println("Can't detonate as last");
			return;
		}
		this.data = this.next.data;
		this.next = this.next.next;
	}
}

public class delete_middle_node
{
	public static void main(String[] args)
	{
		detonode a = new detonode('a');
		detonode b = new detonode('b');
		detonode c = new detonode('c');
		detonode d = new detonode('d');
		detonode e = new detonode('e');

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;

		detonode iterator = a;
		while(iterator != null)
		{
			System.out.println(iterator.data);
			iterator = iterator.next;
		}

		c.detonate();
		System.out.println();

		iterator = a;
		while(iterator != null)
		{
			System.out.println(iterator.data);
			iterator = iterator.next;
		}
	}
}


