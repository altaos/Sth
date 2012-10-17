package lst;

public class LinkedList {
	
	private static class LinkedListNode {
		
		public LinkedListNode(){
			next = null;
			previous = null;
		}
		
		// Конструктор класса, устанавливает значение новому элементу, а так же ссылки на следующий и предыдущий элементы 
		public LinkedListNode(Object v, LinkedListNode n, LinkedListNode pr){
			value = v;
			next = n;
			previous = pr;
		}
		
		private Object value;
		private LinkedListNode next;
		private LinkedListNode previous;
		
		//Получить значение узла
		public Object getValue(){
			return value;
		}
		
		//Установить значение
		public void setValue(Object v){
			value = v;
		}
		
		//Получить следующий узел списка
		public LinkedListNode getNext(){
			return next;
		}
		
		//Установить следующий узел
		public void setNext(LinkedListNode node){
			next = node;
		}
		
		//Получить предыдущий узел узел списка
		public LinkedListNode getPrevious(){
			return previous;
		}
		
		//Установить предыдущий узел
		public void setPrevoius(LinkedListNode node){
			previous = node;
		}

	}
	
	public LinkedList(){
		first = null;
		last = null;
		count = 0;
	}
	
	private LinkedListNode first;
	private LinkedListNode last;
	private int count;
	
	//Получить количество элесентов в списке
	public int getCount(){
		return this.count;
	}
	
	//Проверка пуст ли список
	public Boolean isEmpty(){
		return this.count == 0;
	}
	
	//Получить первый узел
	private LinkedListNode getFirst(){
		return first;
	}
	
	//Последний узел
	private LinkedListNode getLast(){
		return last;
	}
	
	//Поиск узла в списке по значению
	private LinkedListNode findNode(Object v){
		
		LinkedListNode tmp = first;
		
		while (!v.equals(tmp.getValue())){
			tmp = tmp.getNext();
			if (tmp == null)
				return null;
		}
		
		return tmp;
	}
	
	//Поиск значение, возвращает true или false
	public Boolean find(Object v){
		if (this.findNode(v) != null) return true;
		else return false;
	}
	
	//Добавление элемента с после первого узла со значением v
	public void addAfter(Object v, Object c){
		LinkedListNode n = this.findNode(v);
		this.addAfter(n, c);
	}
	
	private void addAfter(LinkedListNode n, Object v) throws NullPointerException{
		try {
			LinkedListNode newNode = new LinkedListNode(v, n.getNext(), n);
			n.getNext().setPrevoius(newNode);
			n.setNext(newNode);
			this.count++;
		}
		catch (NullPointerException ex) {
			this.addLast(v);
			//System.out.println("Element is not exist, it was added to the end of list");
		}
	}
	
	public void addBefore(Object v, Object c){
		LinkedListNode n = this.findNode(v);
		this.addBefore(n, c);
	}

	private void addBefore(LinkedListNode n, Object v) throws NullPointerException {
		try {
			LinkedListNode newNode = new LinkedListNode(v, n, n.getPrevious());
			n.getPrevious().setNext(newNode);
			n.setPrevoius(newNode);
			this.count++;
		}
		catch (NullPointerException ex){
			this.addLast(v);
			//System.out.println("Element is not exist, it was added to the end of list");
		}
	}
	
	//Добавление в начало списка
	public void addFirst(Object v){
		if (first != null){
			LinkedListNode n = new LinkedListNode(v, first, null);
			first.setPrevoius(n);
			first = n;
		}
		else {
			LinkedListNode n = new LinkedListNode(v, null, null);
			first = last = n;
			//last = n;
		}
		/*LinkedListNode n = new LinkedListNode(v, first, null);
		first = n;*/
		this.count++;
	}
	
	//Добавление в конец списка
	public void addLast(Object v){
		if (last != null){
			LinkedListNode n = new LinkedListNode(v, null, last);
			last.setNext(n);
			last = n;
		}
		else {
			LinkedListNode n = new LinkedListNode(v, null, null);
			last = first = n;
		}
		this.count++;
	}
	
	//Преобразование списка в массив
	public Object[] toArray(){
		Object mas[] = new Object[this.count];
		int i = 0;
		LinkedListNode tmp = first;
		
		while (tmp != null){
			mas[i++] = tmp.getValue();
			tmp = tmp.getNext();
		}
		
		return mas;
	}
	
	//Удаление элемента из списка по значению
	public Boolean remove(Object v){
		LinkedListNode tmp = first;
		Boolean flag = false;
		while (tmp.getNext() != null){
			if (tmp.getValue() == v){
				if (tmp.getPrevious() != null){
					tmp.getPrevious().setNext(tmp.getNext());
					tmp.getNext().setPrevoius(tmp.getPrevious());
					tmp = tmp.getPrevious();
					this.count--;
					flag = true;
				}
				//Если удаляемый элемент первый в списке
				else {
					this.removeFirst();
					flag = true;
				}
			}
			else 
				tmp = tmp.getNext();
		}
		
		return flag;
	}
	
	//Удаление первого элемента в списке
	public void removeFirst(){
		LinkedListNode tmp = first;
		tmp.setNext(null);
		first = first.getNext();
		first.setPrevoius(null);
		this.count--;
	}
	
	//Преобразование списка в строку
	public String toString(){
		StringBuilder s = new StringBuilder();
		LinkedListNode tmp = first;
		
		while (tmp != null) {
			s.append(tmp.getValue().toString()).append(' ');// += tmp.getValue().toString() + " ";
			tmp = tmp.getNext();
		}
		
		return s.toString();
	}
	
	//Очистить список
	public void removeAll(){
		while (first != last){
			first = first.getNext();
			this.count--;
			/*first.getPrevious().setNext(null);
			first.setPrevoius(null);*/
		}
		first = last = null;
	}
	
	//Преобразование массива в список
	public static void toList(LinkedList list, Object[] mas){
		list.removeAll();
		for(int i = 0; i < mas.length; i++)
			list.addLast(mas[i]);
	}
	
	//Преобразование массива в список, возвращает список
	public static LinkedList toList(Object[] mas){
		
		LinkedList list = new LinkedList();
		
		for(int i = 0; i < mas.length - 1; i++)
			list.addLast(mas[i]);
		
		return list;
	}

}
