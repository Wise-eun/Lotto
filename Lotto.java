package first;
import java.util.Scanner;
import java.util.*;

class People{
	int people_num;
	Vector<Integer> people_lotto;
	
	public People(int num) {
		this.people_num = num;
	people_lotto = new Vector<Integer>();
	
	for(int i=0;i<6;i++)
		this.people_lotto.add((int)(Math.random()*10+45));
	}
	
}



public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Vector <Integer> Lotto= new Vector<Integer>();   //�ζ� ����
		for(int i=0;i<7;i++)
			Lotto.add((int)(Math.random()*10+45));
		
		
		System.out.println("��÷�� ���� �Է����ּ���");
		Scanner scan = new Scanner(System.in);
		int people;
		people = scan.nextInt();
		
		int Money = people; //����� * ����
		int eMoney = 0;
		
		People[] Peoples = new People[people]; //��� ����, ������� �ζǹ�ȣ ����
		for(int i=0;i<people;i++) {
			Peoples[i] = new People(i);
		}
		
		
		
		System.out.println(" 1 - �ζ� 1ȸ�� �����ϱ�  2- �̿��ݾ� Ȯ���ϱ�  3 - �����ϱ� ");
		int select;
		select = scan.nextInt();
		int one=0;//1��
		int two =0;
		int three =0;
		
		
		if(select == 1) {
		
		int o=0;
		
		for(int j=0;j<people;j++) {
			for(int w=0;w<6;w++) {
		if(Peoples[j].people_lotto.contains(Lotto.get(w))==true)
		o++;
			}		
		}
		
		
		for(int i=0;i<people;i++) {
		if(o==6) {
			System.out.println("ȣ��"+i+"�� ���� 1� ��÷�Ǽ̽��ϴ�.");
			one ++;}
		if(o ==5) {
			if(Peoples[i].people_lotto.contains(Lotto.get(6))==true) {
			System.out.println("ȣ��"+i+"�� ���� 2� ��÷�Ǽ̽��ϴ�.");
			two++;}
			else {
				System.out.println("ȣ��"+i+"�� ���� 3� ��÷�Ǽ̽��ϴ�.");
				three++;}
		}		
	}
		
	
		if(one>0) {
			System.out.println("��÷���� 1�� �� " +(Money/2) * (3/5) / one + "����");
			Money -=(Money/2) * (3/5) / one;
		}
		
		if(two>0) {
			System.out.println("��÷���� 2�� �� " +(Money/2) * (1/5) / two + "����");
			Money -=(Money/2) * (1/5) /two;
		}
		
		if(three>0) {
			System.out.println("��÷���� 2�� �� " +(Money/2) * (1/5) / three + "����");
			Money -=(Money/2) * (1/5) /three;
		}
		
		eMoney += Money;
		
			System.out.println("�ζǱݾ��� 50%�� ��εǸ�, ��÷���� ���� �ݾ��� ���� ȸ���� �̿��˴ϴ�.");
			
			
			
		
		}
		
		if(select == 2) {
			System.out.println("�̿��ݾ� : "+eMoney + "����");
		}
		
	
	
}}
