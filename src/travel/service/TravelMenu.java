package travel.service;

import java.util.Scanner;

import member.bean.MemberDTO;

public class TravelMenu implements Travel{

	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		while(true) {
			System.out.println("TravelMenu 실행");
			System.out.println("travel memberDTO" + memberDTO);
			num = sc.nextInt();
			if(num == 3) break;
		}
	}

}
