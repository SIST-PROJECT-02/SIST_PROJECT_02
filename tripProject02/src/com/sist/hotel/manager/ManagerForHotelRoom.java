package com.sist.hotel.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sist.hotel.dao.HotelVO;
import com.sist.hotel.dao.ProductRoomsDAO;
import com.sist.hotel.dao.ProductRoomsVO;

public class ManagerForHotelRoom {
	// 호텔날짜를 제거한다 delete all hotel room *** 테이블은 두개 -> room, room_available
	// 여기서는 호텔방을 랜덤으로 만들어서 출력한다
	// 조건: 101~ 505호 중 5~10개를 만든다->
	// 101, 102, 103, 104, 105, 201, 202, 203, 204, 205 ... 504, 505
	// 조건: 각 방마다 입장 가능한 날짜(현재날짜 + a(0~30)를 정한다
	//

	public static void main(String[] args) {
		ManagerForHotelRoom mfhr = new ManagerForHotelRoom();

		// 1. 호텔 번호를 가져온다. 가격을 정한다 호텔 번호와 방을 테이블에 저장한다

		List list;
		List priceList = new ArrayList();

		List<HotelVO> hotelList = ProductRoomsDAO.getAllHotelId();

		System.out.println("hotelList.size : " + hotelList.size());
		for (int j = 0; j < hotelList.size(); j++) {
			list = mfhr.randomHotelRoom();
			priceList.clear();
			
			System.out.print("hotel[" + hotelList.get(j).getId() +"] : (room,price) ==>");
			
			for (int i = 0; i < list.size(); i++) {
				int value = (int)(Math.random() * 40001) + 30000;
				priceList.add((value / 1000) * 1000);
				
				System.out.print("(" + list.get(i) + "," + priceList.get(i) + ")");
				//여기서 INSERT를 해야한다
				
				ProductRoomsVO vo = new ProductRoomsVO();
				vo.setRoom_no((int)list.get(i));
				vo.setHotel_id((int)hotelList.get(j).getId());
				vo.setPrice((int)priceList.get(i));
				
				ProductRoomsDAO.insertProductRooms(vo);
				
			}
			System.out.println();
		}
	}

	public List randomHotelRoom() {
		List list = new ArrayList();

		// 5~10개의 방을 생성한다
		int roomCount = (int) (Math.random() * 6) + 5;
		// 해당 방의 개수만큼 101~ 505를 만든다
		boolean bCheck = true;
		int value = 0;
		for (int i = 0; i < roomCount; i++) {
			bCheck = true;
			while (bCheck) {
				bCheck = false;
				value = (int) (Math.random() * (505 - 101 + 1)) + 101;
				value = ((value / 100) % 6) * 100 + value % 6;
				for (int j = 0; j < i; j++) {
					if ((int) list.get(j) == value) {
						bCheck = true;
						break;
					}
				}
			}
			list.add(value);
		}
		list.sort(null);
		return list;
	}
}
