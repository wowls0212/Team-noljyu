package com.mbc.nol.flea;

import java.util.ArrayList;

import com.mbc.nol.how.HowDTO;
import com.mbc.nol.how.HowReviewDTO;

public interface FleaService {

	void howinsert(String id, String fleatitle, String fleadetail, String fleaimg);

	ArrayList<FleaDTO> howout();

	HowDTO howdetailout(int fleanum);

	ArrayList<HowReviewDTO> howreviewout(int fleanum);

	void howreview(int fleanum, String id, String fleareview);

	HowReviewDTO howrere(int fleareviewnum);

	void howstepup(int fleagroups, int fleastep);

	void howreinsert(int fleanum, String id, String fleareview, int fleagroups, int fleastep, int fleaindent);

}
