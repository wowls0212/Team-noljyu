package com.mbc.nol.user;

import java.util.ArrayList;

public interface UserService {

	int idcount(String id);

	void insertq(String id, String pw, String name, String address, String phone, String nickname, String myanimal
			);

	ArrayList<UserDTO> allout();

}
