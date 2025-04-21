package com.mbc.nol.board;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BoardService {

	// 로그인한 유저가 쓴 글 목록 조회 
	List<BoardDTO> getpostsByUser(@Param("id") String loginId);
	//단일 글 조회
	BoardDTO getpost(@Param("seq")int seq);
    //글수정
	void updatePost(BoardDTO dto);
    //글삭제
	void deletePost(@Param("seq")int seq);

}
