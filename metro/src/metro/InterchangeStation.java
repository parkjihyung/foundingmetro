package metro;
import java.util.Scanner;


public class InterchangeStation extends Station{
	String[] LineNumbers=null;
	public void AddLineNumbers(int num) {
		//임시로 짠 코드 파일 입출력으로 노선을 추가할 예정임
		LineNumbers=new String[num];
		Scanner a=new Scanner(System.in);
		for(int i=0;i<num;++i) {
			LineNumbers[i]=a.nextLine();
		}
		a.close();
	}
}
