package com.sist.hotel.manager;

import java.util.ArrayList;
import java.util.List;

import com.sist.hotel.dao.ProductRoomsAvailableDAO;
import com.sist.hotel.dao.ProductRoomsAvailableVO;
import com.sist.hotel.dao.ProductRoomsVO;

public class ManagerForHotelRoomDate {

	public static void main(String[] args) {
		ManagerForHotelRoomDate mfhrd = new ManagerForHotelRoomDate();
		List<ProductRoomsVO> productList = ProductRoomsAvailableDAO.getAllHotelRoomId();
		for (int j = 0; j < productList.size(); j++) {
			List list = mfhrd.randomHotelRoomDate();
			for (int i = 0; i < list.size(); i++) {
				if(i < list.size()-1 && list.get(i) == list.get(i+1)){
					System.out.println("중복발생");
				}
				System.out.print(list.get(i) + " ");
				//INSERT를 여기서 한다 -> productList의 hotel_id, room_no를 DAO에 준다.
				ProductRoomsAvailableVO vo = new ProductRoomsAvailableVO();
				vo.setHotel_id(productList.get(j).getHotel_id());
				vo.setRoom_no(productList.get(j).getRoom_no());
				vo.setAddDate((int)list.get(i));
				ProductRoomsAvailableDAO.insertProductRoomDates(vo);
			}
			System.out.println();
		}
		
		//1. 룸 no와 호텔 id를 모두 가져온다. 2. 시간을 삽입한다 3. id = NVL 4. state = 0으로 한다
	}

	public List randomHotelRoomDate() {
		List list = new ArrayList();

		// 데이의 개수를 결정한다 10 ~ 20
		int dateCount = (int) (Math.random() * 11) + 10;
		int value = 0;
		boolean bCheck = true;
		for (int i = 0; i < dateCount; i++) {
			// 데이의 개수만큼 데이를 만든다
			bCheck = true;
			while (bCheck) {
				bCheck = false;
				value = (int) (Math.random() * 31) + 1;
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
