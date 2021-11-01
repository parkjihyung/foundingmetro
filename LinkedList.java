package metro;

public class LinkedList {
	private Station head;
	public LinkedList() {
		head = null;
	}
	//역과 인접해 있는 역을 추가하는 함수
	public void AddStation(String name,float distence) {
		Station next = new Station(distence,name);
		next.setNext(head.getNext());
		head.setNext(next);
		
	}
}
