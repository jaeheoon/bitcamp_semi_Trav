package travel.service;

import java.util.ArrayList;
import java.util.Scanner;

import member.bean.MemberDTO;
import semi.main.Interfa;
import travel.bean.TravelDTO;
import travel.dao.TravelDAO;

public class ListTravelService implements Interfa {

	@Override
	public void execute(MemberDTO memberDTO) {
		TravelDAO travelDAO = TravelDAO.getInstance();
		ArrayList<TravelDTO> list = travelDAO.viewSearchList("name", "");
		
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("  여행지명\t대륙\t평점\t설명");
		System.out.println("---------------------------------------------------------------------------------------");
		for (TravelDTO travelDTO : list) {
			System.out.println(travelDTO.getName() + "\t"
							 + travelDTO.getContinent() + "\t" 
							 + travelDTO.getLike() + "\t"
							 + travelDTO.getContent());
		}
		System.out.println();
	}

}
