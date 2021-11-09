package metro;

import java.io.*;
import java.util.*;

//지하철역 정보로 노선도를 만드는 클래스이다
public class MakeRouteMap {

	public ArrayList<Station<AdjStation>> stations = new ArrayList<Station<AdjStation>>();
	ArrayList<String[]> raw = new ArrayList<>();

	public ArrayList<Station<AdjStation>> getStaions() {
		return stations;
	}

	public MakeRouteMap() {
		// TODO Auto-generated method stub
		String file = "src\\지하철역정보.csv";
		String line = "";

		try {
			BufferedReader reader = null;
			reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {
				raw.add(line.split(","));
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator<String[]> iter = raw.iterator();
		iter.next();
		
		while (iter.hasNext()) {
			String[] s = iter.next();
			stations.add(new Station<AdjStation>(s[1], s[0]));
		}
		
		AddNextStation(raw.get(1), stations.get(42), 0);
		AddPrevStation(raw.get(43), stations.get(0), Float.valueOf(raw.get(1)[2]), 42);
		
		for (int i = 1; i < raw.size() - 1; ++i) {
			if (raw.get(i)[3].equals("1")) {
				AddNextStation(raw.get(i + 1), stations.get(i - 1), i);
				continue;
			}
			if (raw.get(i)[2].equals("0") || (!(raw.get(i)[0].equals(raw.get(i - 1)[0])))) {
				AddNextStation(raw.get(i + 1), stations.get(i - 1), i);
			} else if (!(raw.get(i + 1)[0].equals(raw.get(i)[0]))) {
				AddPrevStation(raw.get(i - 1), stations.get(i - 1), Float.valueOf(raw.get(i)[2]), i - 2);
			} else {
				AddPrevStation(raw.get(i - 1), stations.get(i - 1), Float.valueOf(raw.get(i)[2]), i - 2);
				AddNextStation(raw.get(i + 1), stations.get(i - 1), i);
			}
		}
		
		for (int i = 0; i < stations.size() - 1; ++i) {
			for (int j = i + 1; j < stations.size(); ++j) {
				if (stations.get(i).getName().equals(stations.get(j).getName())) {
					AddPrevStation(raw.get(j + 1), stations.get(i), 0, j);
					AddPrevStation(raw.get(i + 1), stations.get(j), 0, i);
					break;
				}
			}
		}
		return;
	}

	private void AddNextStation(String[] raw, Station<AdjStation> stn, int index) {
		String[] nextS = raw;
		AdjStation next = new AdjStation(nextS[1], nextS[0], Float.valueOf(nextS[2]), index);
		stn.AdjStnList.add(next);
		return;
	}

	private void AddPrevStation(String[] raw, Station<AdjStation> stn, float distence, int index) {
		AdjStation prev = new AdjStation(raw[1], raw[0], distence, index);
		stn.AdjStnList.add(prev);
		return;
	}

}
