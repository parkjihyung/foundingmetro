package metro;

public class LinkedList {
	private Station head;
	public LinkedList() {
		head = null;
	}
	//���� ������ �ִ� ���� �߰��ϴ� �Լ�
	public void AddStation(String name,float distence) {
		Station next = new Station(distence,name);
		next.setNext(head.getNext());
		head.setNext(next);
		
	}
}
