package metro;

public class Station {
	private String name;
	float distence=1;
	public Station() {}
	public Station(float distence,String name){
		this.distence=distence;
		this.name=name;
	}
	private Station next = null;
	public void setNext(Station next) {
		this.next=next;
	}
	public Station getNext() {
		return this.next;
	}
}