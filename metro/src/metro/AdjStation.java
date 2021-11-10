package metro;

public class AdjStation extends Station {
	private double distence;
	private int index;
	
	public AdjStation(String name,String lineNumber,double distence,int index) {
		this.name=name;
		this.lineNumber=lineNumber;
		this.distence=distence;
		this.index=index;
	}
	
	public AdjStation getStation() {
		return this;
	}
	
	public double getDistence() {
		return distence;
	}
	
	public int getIndex() {
		return index;
	}
}
