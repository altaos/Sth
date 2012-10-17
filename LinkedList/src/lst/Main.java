package lst;

public class Main {

	public static void main(String[] args) {
		
		//—оздание списка
				LinkedList list = new LinkedList();
				
				//ƒобавление в начало списка, конец, до и после элемента с опред значением, удаление по значению
				list.addFirst(5);
				list.addFirst(18);
				list.addFirst(12);
				list.addLast(14);
				list.addAfter(18, 7);
				list.addBefore(18, 7);
				list.addBefore(4, 21);
				list.remove(7);
				list.addLast(0);
				list.addFirst(4);
				
				//¬ывод списка на консоль
				System.out.println(list.toString());
				
				//ѕреобразование списка в массив, вывод последнего в консоль
				Object mas[] = list.toArray();
				for(int i = 0; i < mas.length; i++)
					System.out.println(mas[i]);
				
				//ѕреобразование массива в заполненный список с предварительным его очищением
				LinkedList.toList(list, mas);
				System.out.println(list.toString());
				
				mas = list.toArray();
				//list.addFirst(66);
				
				//ѕреобразование массива в список, замена ссылок
				list = LinkedList.toList(mas);
				System.out.println(list.toString());
				
				//ѕоиска элемента в списке по значению, выводит true, если элемент найден, иначе - false 
				System.out.println(list.find(4));

	}

}
