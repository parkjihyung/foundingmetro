package metro;
import java.util.Scanner;


public class InterchangeStation extends Station{
	String[] LineNumbers=null;
	public void AddLineNumbers(int num) {
		//�ӽ÷� § �ڵ� ���� ��������� �뼱�� �߰��� ������
		LineNumbers=new String[num];
		Scanner a=new Scanner(System.in);
		for(int i=0;i<num;++i) {
			LineNumbers[i]=a.nextLine();
		}
		a.close();
	}
}
