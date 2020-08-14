package first;
import java.util.Scanner;
import java.util.*;

class People{
	int people_num;
	Vector<Integer> people_lotto;
	public People() {}
	public People(int num) {
		this.people_num = num;
	people_lotto = new Vector<Integer>();
	}
	public void get_code() {
	for(int i=0;i<6;i++)
		this.people_lotto.add((int)(Math.random()*45+1));
	}
	
	void clean() {

			this.people_lotto.clear();
		
	}
	
}


class Player extends People{
	public Player(int num) {
		this.people_num = num;
		people_lotto = new Vector<Integer>();
	}

	public void get_code(int[] a) {
		for(int i=0;i<6;i++) {
			this.people_lotto.add(a[i]);
		}
		
	}
	
}


public class ff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Vector <Integer> Lotto= new Vector<Integer>();   //�ζ� ����
		for(int i=0;i<7;i++)
			Lotto.add((int)(Math.random()*45+1));
		
		
		System.out.println("��÷�� ���� �Է����ּ���");
		Scanner scan = new Scanner(System.in);
		int people;
		people = scan.nextInt();
		
		int Money = 0; 
		int eMoney = 0;
		
		People[] Peoples = new People[people]; //��� ����, ������� �ζǹ�ȣ ����
		for(int i=0;i<people;i++) {
			Peoples[i] = new People(i);
		}
		
		int num=1;
		while(true) {
			
		Money += people; //����� * ����
		System.out.println(" 1 - �ζ� "+num+"ȸ�� �����ϱ�  2- �̿��ݾ� Ȯ���ϱ�  3 - �����ϱ� ");
		int select;
		select = scan.nextInt();
		int one=0;//1��
		int two =0;
		int three =0;
		
		
		if(select == 1) {
		
		Money = Money/2;//���
		int lucky = 0;
		for(int i=0;i<people;i++) {
			int o=0;
			for(int w=0;w<6;w++) {
				if(Peoples[i].people_lotto.contains(Lotto.get(w))==true)
					o++;
			}	

			if(o==6) {
				System.out.println("ȣ��"+i+"�� ���� 1� ��÷�Ǽ̽��ϴ�.");
				lucky++;
				one ++;}
			if(o ==5) {
				if(Peoples[i].people_lotto.contains(Lotto.get(6))==true) {
					System.out.println("ȣ��"+i+"�� ���� 2� ��÷�Ǽ̽��ϴ�.");
					lucky++;
					two++;}
				else {
					System.out.println("ȣ��"+i+"�� ���� 3� ��÷�Ǽ̽��ϴ�.");
					lucky++;
					three++;}
			}		
		}
		System.out.println("��÷�� ����� "+lucky +"�� �Դϴ�.");
	int lucky_money = Money;
		if(one>0) {
			System.out.println("��÷���� 1�� "+one+"���� �� " +(Money * 3/5 / one) + "����");
			lucky_money =(Money) * (3/5) / one;
		}
		
		if(two>0) {
			System.out.println("��÷���� 2��"+two+ "���� �� " +(Money /5 / two) + "����");
			lucky_money =(Money) /5 /two;
		}
		
		if(three>0) {
			System.out.println("��÷���� 3��"+three+"���� �� " +(Money /5/ three) + "����");
			lucky_money =(Money) /5 /three;
		}
		
	Money -= lucky_money;
		
			System.out.println("�ζǱݾ��� 50%�� ��εǸ�, ��÷���� ���� �ݾ��� ���� ȸ���� �̿��˴ϴ�.");
			
			
			
		num++;
		
		Lotto.clear();//�ʱ�ȭ
		for(int i=0;i<people;i++)
		Peoples[i].clean();
		
		for(int i=0;i<7;i++)
			Lotto.add((int)(Math.random()*45+1));
		Peoples = new People[people]; //��� ����, ������� �ζǹ�ȣ ����
		for(int i=0;i<people;i++) 
			Peoples[i] = new People(i);
		
		
		eMoney += Money;
		
		}
		
		
		
		if(select == 2) {
			System.out.println("�̿��ݾ� : "+eMoney + "����");
		}
		
		if(select == 3) {
			System.out.println("�����մϴ�.");
			break;}
		
		
		}
	
}}
