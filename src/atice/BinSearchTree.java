import java.util.Scanner;
class BinSearchTree
{
	BinSearchTree bst2;
	IntNode root = null;
	Scanner sc= new Scanner(System.in);
	Scanner isc = new Scanner(System.in);
	int key;

	public static void main(String[] args)
	{
		BinSearchTree bst = new BinSearchTree();
		bst.begin();
	}

	void begin()
	{
		bst2 = new BinSearchTree();
		char uIn='y';
		do
		{
			switch (uIn)
			{
				case 'i':
				System.out.println("Enter the value you want to insert");
				key = isc.nextInt();
				insert(bst2,new IntNode(key));
					break;
				case 's':
					System.out.println("Enter value to search for");
					key = isc.nextInt();
					IntNode serch=search(root,key);
					if(serch != null)
						System.out.println("found");
					else
						System.out.println("not found");
					break;
			}
			System.out.println("Insert i");
			System.out.println("search s");
			System.out.println("Exit x");
			

		}while((uIn = sc.next().charAt(0))!= 'x');
	}
	void insert(BinSearchTree tree,IntNode n)
	{
		Node temp1 = null;
		Node temp2 = root;
		
		while(temp2 != null)
		{
			temp1 = temp2;
			if(((IntNode)temp2).key< n.key)
				temp2 = temp2.rChild;
			else
				temp2 = temp2.lChild;
		}
		if(temp1 == null)
			root = n;
		else
		{
			n.parent = temp1;
			if(((IntNode)temp1).key < n.key)
			{
				System.out.println("rchild");
				temp1.rChild = n;
			}
			else
			{
				System.out.println("lchild");
				temp1.lChild = n;
			}
		}
		System.out.println("Inoder Tree Walk");
		inTreeWalk(root);
		
	}

	void inTreeWalk(Node temp)
	{	
		
		if(temp !=null)
		{
			inTreeWalk(((IntNode)temp).lChild);
			System.out.println(((IntNode)temp).key);
			inTreeWalk(temp.rChild);
		}
	}

	IntNode search(Node tmpRt,int ky)
	{
		if(tmpRt == null || ((IntNode)tmpRt).key == ky )
		{
			return (IntNode)tmpRt;
		}
		if(((IntNode)tmpRt).key <= ky)
		{
			return search(tmpRt.rChild,ky);
		}
		else
			return search(tmpRt.lChild,ky);
	}	



















}
