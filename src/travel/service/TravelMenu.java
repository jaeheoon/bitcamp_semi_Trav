package travel.service;

import java.util.Scanner;

public class TravelMenu implements Travel{

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		while(true) {
			System.out.println("TravelMenu 실행");
			num = sc.nextInt();
			if(num == 3) break;
		}
	}

}
