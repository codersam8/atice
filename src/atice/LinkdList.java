class LinkdList<T>
{
    T head=null;
    T next = null;
    T prev = null;
    int value;
    public static void main(String[] args)
    {

    }

    void insert(LinkdList<T> list,LinkdList<T> ele)
    {
	ele.next = list.head;
	if(list.head!=null)
	    {
		list.head.prev = ele;
	    }
	ele.prev = null;
	list.head = ele;
	display();
    }

    void display()
    {
	for(LinkdList temp = head ;temp != null ;temp = temp.next )
	    {
		System.out.println("value is "+temp.value);
	    }

    }
}
