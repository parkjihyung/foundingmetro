package metro;

import java.util.Scanner;

public class RouteMapController {

	public static void main(String[] args) {
		MakeRouteMap makeRouteMap = new MakeRouteMap();
		makeRouteMap.executeRouteMap();
		Scanner sc = new Scanner(System.in);
		while(true) {
			String StartStn,EndStn;
			System.out.println("0 입력시 종료");
			System.out.print("시작역 : ");
			StartStn = sc.next();
			System.out.print("도착역 : ");
			EndStn = sc.next();
			if(StartStn.equals("0") || EndStn.equals("0"))break;
			FindShortestPath f = new FindShortestPath(StartStn, EndStn, makeRouteMap.getStaions());
			f.dijkstra();
			if(f.getShortestPath() != null) {
				String[] s = f.getShortestPath();
				for(int i = 0; i < s.length-1; ++i) {
					 System.out.print( s[i] + " -> ");
				}
				 System.out.println(EndStn);
			}
			if(f.getDistence() != 0)
				System.out.println(f.getDistence()+"Km");
			else System.out.println("잘못 입력하셨습니다.");
		}
	}

}
