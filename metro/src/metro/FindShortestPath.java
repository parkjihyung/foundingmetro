package metro;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FindShortestPath {
	static final double INF = (double) 99999;
	double[] distence = null;
	String[] saveRoute;

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
		
		for(index=0; index < stns.size(); ++index) {
			if(startStn.equals(stns.get(index).getName())) {
				st=stns.get(index);
				break;
			}
		}
		for(int j = 0; j < stns.size(); ++j) {
			distence[j]=INF;
			check[j]=false;
			}
		distence[index]=0;
		//check[index]=true;
		saveRoute[index]=st.getName();
		if(startStn.equals(endStn)) {
			return;
		}
		Queue<AdjStation> queue = new LinkedList<>();
		queue.add(new AdjStation(startStn, stns.get(index).getLineNumber(), 0, index));
		distence[index]=0;
		while(!queue.isEmpty()) {
			AdjStation curNode = queue.poll();
			//System.out.println(curNode.name);
			int cur = curNode.getIndex();
			//System.out.println(stns.get(cur).AdjStnList.size());
			if(check[cur] == true) continue;
			check[cur]=true;
			for(int i = 0; i < stns.get(cur).AdjStnList.size(); ++i) {
				AdjStation s = stns.get(cur).AdjStnList.get(i);
				if(distence[s.getIndex()] > distence[cur] + s.getDistence()) {
					distence[s.getIndex()] = distence[cur] + s.getDistence();
					if(curNode.getLineNumber().equals(s.getLineNumber())) {
						saveRoute[s.getIndex()] = saveRoute[cur] +" "+ s.getName();
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
	
	public void showShortestPath() {
		String[] r = saveRoute[getEndStnIndex()].split(" ");
	}
}
