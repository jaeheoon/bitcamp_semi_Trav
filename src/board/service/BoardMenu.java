package board.service;

import java.util.Scanner;

public class BoardMenu implements Board{

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		while(true) {
			System.out.println("BoardMenu 실행");
			num = sc.nextInt();
			if(num == 3) break;
		}
	}

}
