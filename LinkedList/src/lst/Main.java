package lst;

public class Main {

	public static void main(String[] args) {
		
		//�������� ������
				LinkedList list = new LinkedList();
				
				//���������� � ������ ������, �����, �� � ����� �������� � ����� ���������, �������� �� ��������
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
				
				//����� ������ �� �������
				System.out.println(list.toString());
				
				//�������������� ������ � ������, ����� ���������� � �������
				Object mas[] = list.toArray();
				for(int i = 0; i < mas.length; i++)
					System.out.println(mas[i]);
				
				//�������������� ������� � ����������� ������ � ��������������� ��� ���������
				LinkedList.toList(list, mas);
				System.out.println(list.toString());
				
				mas = list.toArray();
				//list.addFirst(66);
				
				//�������������� ������� � ������, ������ ������
				list = LinkedList.toList(mas);
				System.out.println(list.toString());
				
				//������ �������� � ������ �� ��������, ������� true, ���� ������� ������, ����� - false 
				System.out.println(list.find(4));

	}

}
