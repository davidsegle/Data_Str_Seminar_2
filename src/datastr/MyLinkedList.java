package datastr;

public class MyLinkedList<Ttype> {
	private MyNode<Ttype> firstNode = null;
	private MyNode<Ttype> lastNode = null;
	private int howManyElements = 0;
	
	public int getHowManyElements() {
		return howManyElements;
	}
	
	public boolean isEmpty() {
		return (howManyElements == 0);
	}
	
	public boolean isFull() {
		try
		{
			new MyNode<Character>('A');
			return false;
		}
		catch (OutOfMemoryError e) {
			return true;
		}
	}
	
	public void add(Ttype element) throws Exception{
		if(isFull()) {
			throw new Exception("Saraksts ir pilns un nav iespejams pievienot elementu");
		}
		if(element == null) {
			throw new Exception("Padotais elements nav noradits");
		}
		if(isEmpty()) {
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			lastNode = newNode;
			firstNode = newNode;
			howManyElements++;
		}
		else 
		{
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			lastNode.setNextNode(newNode);
			newNode.setPreviousNode(lastNode);
			
			lastNode = newNode;
			howManyElements++;
		}
		
		
	}
	
	public void add(Ttype element, int position)throws Exception {
		if(isFull()) {
			throw new Exception("Saraksts ir pilns un nav iespejams pievienot elementu");
		}
		if(element == null) {
			throw new Exception("Padotais elements nav noradits");
		}
		if(position < 0) {
			throw new Exception("Pozicija nevar but negativa");
		}
		if(position > howManyElements) {
			throw new Exception("Pozicija nevar but lielaka par esoso elementu skaitu");
		}
		
		if(position == 0) {
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			
			newNode.setNextNode(firstNode);
			firstNode.setPreviousNode(newNode);
			
			firstNode = newNode;
			howManyElements++;
		}
		else if(position == howManyElements) {
			add(element);
		}
		else {
			
		}
	}
	
	
	public void print() throws Exception{
		if(isEmpty()) {
			throw new Exception("Saraksta nav elementu lidz ar to neko nevar izprintet");
		}
		
		MyNode<Ttype> currentNode = firstNode;
		
		while(currentNode != null) {
			System.out.print(currentNode.getElement() + " ");
			currentNode = currentNode.getNextNode();
		}
		
		System.out.println();
	}
	
}
