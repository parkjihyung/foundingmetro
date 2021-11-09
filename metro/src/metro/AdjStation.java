package metro;

public class AdjStation extends Station implements Comparable<AdjStation>{
	private float distence;
	private int index;
	public AdjStation(String name,String lineNumber,float distence,int index) {
		this.name=name;
		this.lineNumber=lineNumber;
		this.distence=distence;
		this.index=index;
	}
	public AdjStation getStation() {
		return this;
	}
	public float getDistence() {
		return distence;
	}
	public int getIndex() {
		return index;
	}
	@Override
	public int compareTo(AdjStation o) {
		// TODO Auto-generated method stub
		return (int) (distence*10);
	}
}
