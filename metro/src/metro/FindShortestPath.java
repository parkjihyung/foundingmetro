package metro;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FindShortestPath {
	static final double INF = (double) 99999;
	private double[] distence = null;
	private String[] saveRoute;

	String startStn,endStn;
	Station<AdjStation> st;//현재 있는 역
	Boolean[] check;//역을 방문했는지 여부를 체크
	ArrayList<Station<AdjStation>> stns;
	
	public FindShortestPath(String startStn,String endStn,ArrayList<Station<AdjStation>> s) {
		
		this.startStn=startStn;
		this.endStn=endStn;
		stns=s;
	}
	
	public void dijkstra() {
		int index;
		saveRoute= new String[stns.size()];
		distence = new double[stns.size()];
		check = new Boolean[stns.size()];
		
		if(startStn.equals(endStn)) {
			return;
		}
		
		for(index=0; index < stns.size(); ++index) {
			if(startStn.equals(stns.get(index).getName())) {
				st=stns.get(index);
				break;
			}
		}
		if(index==stns.size()) return;//출발역이 없으면 return
		for(int j = 0; j < stns.size(); ++j) {//값 초기화
			distence[j]=INF;
			check[j]=false;
			}
		distence[index]=0;
		saveRoute[index]=st.getName();
		
		Queue<AdjStation> queue = new LinkedList<>();
		queue.add(new AdjStation(startStn, stns.get(index).getLineNumber(), 0, index));//시작역 추가
		distence[index]=0;
		while(!queue.isEmpty()) {
			AdjStation curNode = queue.poll();
			int cur = curNode.getIndex();
			if(check[cur] == true) continue;
			check[cur]=true;
			for(int i = 0; i < stns.get(cur).getAdjStnList().size(); ++i) {
				AdjStation s = stns.get(cur).getAdjStnList().get(i);
				if(distence[s.getIndex()] > distence[cur] + s.getDistence()) {
					distence[s.getIndex()] = distence[cur] + s.getDistence();
					if(curNode.getLineNumber().equals(s.getLineNumber())) {
						if(curNode.getName().equals(s.getName())) {
							saveRoute[s.getIndex()] = saveRoute[cur];
						}
						
						else{
							saveRoute[s.getIndex()] = saveRoute[cur] +" "+ s.getName();
							}
					}
					else {
						
						saveRoute[s.getIndex()] = saveRoute[cur] + "-" +s.getLineNumber();
					}
					
					queue.add(s);
				}
				
			}
		}
	}
	
	public int getEndStnIndex() {
		for(int i=0;i<stns.size();++i) {
			if(stns.get(i).getName().equals(endStn)) {
				return i;
			}
		}
		return -1;
	}
	
	public String[] showShortestPath() {
		String[] r = null;
		if(getEndStnIndex() == -1 || saveRoute[getEndStnIndex()] == null) {//출발역이나 도착역이 없으면 null을 반환
			return r;
		}
		
		r = saveRoute[getEndStnIndex()].split(" ");
		
		if(r[r.length-1].split("-").length>1) {
			r[r.length-1]=r[r.length-1].split("-")[0];
		}
		if(r[0].split("-").length>1) {
			r[0] = r[0].split("-")[0];
		}
		
		return r;
	}
	
	public double getDistence() {
		int i = getEndStnIndex();
		if (i == -1)return 0;
		distence[i] = Double.parseDouble(String.format("%.1f", distence[i]));
		return distence[i];
	}
}
