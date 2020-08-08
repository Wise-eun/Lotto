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
		
		
		Vector <Integer> Lotto= new Vector<Integer>();   //로또 생성
		for(int i=0;i<7;i++)
			Lotto.add((int)(Math.random()*10+45));
		
		
		System.out.println("추첨자 수를 입력해주세요");
		Scanner scan = new Scanner(System.in);
		int people;
		people = scan.nextInt();
		
		int Money = people; //사람수 * 만원
		int eMoney = 0;
		
		People[] Peoples = new People[people]; //사람 생성, 사람마다 로또번호 생성
		for(int i=0;i<people;i++) {
			Peoples[i] = new People(i);
		}
		
		
		
		System.out.println(" 1 - 로또 1회차 진행하기  2- 이월금액 확인하기  3 - 종료하기 ");
		int select;
		select = scan.nextInt();
		int one=0;//1등
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
			System.out.println("호구"+i+"번 님이 1등에 당첨되셨습니다.");
			one ++;}
		if(o ==5) {
			if(Peoples[i].people_lotto.contains(Lotto.get(6))==true) {
			System.out.println("호구"+i+"번 님이 2등에 당첨되셨습니다.");
			two++;}
			else {
				System.out.println("호구"+i+"번 님이 3등에 당첨되셨습니다.");
				three++;}
		}		
	}
		
	
		if(one>0) {
			System.out.println("당첨금은 1등 각 " +(Money/2) * (3/5) / one + "만원");
			Money -=(Money/2) * (3/5) / one;
		}
		
		if(two>0) {
			System.out.println("당첨금은 2등 각 " +(Money/2) * (1/5) / two + "만원");
			Money -=(Money/2) * (1/5) /two;
		}
		
		if(three>0) {
			System.out.println("당첨금은 2등 각 " +(Money/2) * (1/5) / three + "만원");
			Money -=(Money/2) * (1/5) /three;
		}
		
		eMoney += Money;
		
			System.out.println("로또금액의 50%는 기부되며, 당첨되지 않은 금액은 다음 회차로 이월됩니다.");
			
			
			
		
		}
		
		if(select == 2) {
			System.out.println("이월금액 : "+eMoney + "만원");
		}
		
	
	
}}
