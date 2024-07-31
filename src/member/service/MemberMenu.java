package member.service;

import java.util.Scanner;

public class MemberMenu implements Member{

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		while(true) {
			System.out.println("MemberMenu 실행");
			num = sc.nextInt();
			if(num == 3) break;
		}
	}

}
