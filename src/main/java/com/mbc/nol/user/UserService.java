package com.mbc.nol.user;

import org.apache.ibatis.annotations.Param;
import java.util.ArrayList;

public interface UserService {

	int idcount(String id);

	void insertq(String id, String pw, String name, String address, String phone, String nickname, String myanimal, String admin);

	ArrayList<UserDTO> allout();

	ArrayList<UserDTO> searcha(@Param("cate") String cate, @Param("scearch") String scearch);

	UserDTO getuser(String loginId);

	UserDTO modify1(String id);

	void modify2(String id, String pw, String name, String address, String phone, String nickname, String myanimal);

	UserDTO delete1(String id);

	void delete2(String id);
	
	// 관리자용 비밀번호 가져오기
	String getAdminPassword();

	int nicknamecount(String nickname);

}
