package metro;

import java.util.ArrayList;

public class Station<T> {
	protected String name;
	protected String lineNumber;
	
	public Station() {}
	
	public Station(String name, String lineNumber){
		this.name=name;
		this.lineNumber=lineNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLineNumber() {
		return lineNumber;
	}
	
	private ArrayList<T> AdjStnList = new ArrayList<>();

	public ArrayList<T> getAdjStnList() {
		return AdjStnList;
	}

}