package com.mbc.nol.flea;

import java.util.ArrayList;


public interface FleaService {

	void fleainsert(String id, String fleatitle, String fleadetail, String fleaimg);

	ArrayList<FleaDTO> fleaout();

	FleaDTO fleadetailout(int fleanum);

	ArrayList<FleaReviewDTO> fleareviewout(int fleanum);

	void fleareview(int fleanum, String id, String fleareview);

	FleaReviewDTO flearere(int fleareviewnum);

	void fleastepup(int fleagroups, int fleastep);

	void fleareinsert(int fleanum, String id, String fleareview, int fleagroups, int fleastep, int fleaindent);

	FleaDTO fleaupdateout(int fleanum);

	void fleaupdate(int fleanum, String fleatitle, String fleadetail);

	void fleaupdateimg(int fleanum, String fleatitle, String fleadetail, String fleaimg);

	void fleadelete(int fleanum);

	int fleadeletecheck(int fleanum);

	ArrayList<FleaDTO> fleasearchall(String fleavalue);

	ArrayList<FleaDTO> fleasearch(String fleakey, String fleavalue);

}
