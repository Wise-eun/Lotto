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
		
		
		Vector <Integer> Lotto= new Vector<Integer>();   //로또 생성
		for(int i=0;i<7;i++)
			Lotto.add((int)(Math.random()*45+1));
		
		
		System.out.println("추첨자 수를 입력해주세요");
		Scanner scan = new Scanner(System.in);
		int people;
		people = scan.nextInt();
		
		int Money = 0; 
		int eMoney = 0;
		
		People[] Peoples = new People[people]; //사람 생성, 사람마다 로또번호 생성
		for(int i=0;i<people;i++) {
			Peoples[i] = new People(i);
		}
		
		int num=1;
		while(true) {
			
		Money += people; //사람수 * 만원
		System.out.println(" 1 - 로또 "+num+"회차 진행하기  2- 이월금액 확인하기  3 - 종료하기 ");
		int select;
		select = scan.nextInt();
		int one=0;//1등
		int two =0;
		int three =0;
		
		
		if(select == 1) {
		
		Money = Money/2;//기부
		int lucky = 0;
		for(int i=0;i<people;i++) {
			int o=0;
			for(int w=0;w<6;w++) {
				if(Peoples[i].people_lotto.contains(Lotto.get(w))==true)
					o++;
			}	

			if(o==6) {
				System.out.println("호구"+i+"번 님이 1등에 당첨되셨습니다.");
				lucky++;
				one ++;}
			if(o ==5) {
				if(Peoples[i].people_lotto.contains(Lotto.get(6))==true) {
					System.out.println("호구"+i+"번 님이 2등에 당첨되셨습니다.");
					lucky++;
					two++;}
				else {
					System.out.println("호구"+i+"번 님이 3등에 당첨되셨습니다.");
					lucky++;
					three++;}
			}		
		}
		System.out.println("당첨된 사람은 "+lucky +"명 입니다.");
	int lucky_money = Money;
		if(one>0) {
			System.out.println("당첨금은 1등 "+one+"명은 각 " +(Money * 3/5 / one) + "만원");
			lucky_money =(Money) * (3/5) / one;
		}
		
		if(two>0) {
			System.out.println("당첨금은 2등"+two+ "명은 각 " +(Money /5 / two) + "만원");
			lucky_money =(Money) /5 /two;
		}
		
		if(three>0) {
			System.out.println("당첨금은 3등"+three+"명은 각 " +(Money /5/ three) + "만원");
			lucky_money =(Money) /5 /three;
		}
		
	Money -= lucky_money;
		
			System.out.println("로또금액의 50%는 기부되며, 당첨되지 않은 금액은 다음 회차로 이월됩니다.");
			
			
			
		num++;
		
		Lotto.clear();//초기화
		for(int i=0;i<people;i++)
		Peoples[i].clean();
		
		for(int i=0;i<7;i++)
			Lotto.add((int)(Math.random()*45+1));
		Peoples = new People[people]; //사람 생성, 사람마다 로또번호 생성
		for(int i=0;i<people;i++) 
			Peoples[i] = new People(i);
		
		
		eMoney += Money;
		
		}
		
		
		
		if(select == 2) {
			System.out.println("이월금액 : "+eMoney + "만원");
		}
		
		if(select == 3) {
			System.out.println("종료합니다.");
			break;}
		
		
		}
	
}}
