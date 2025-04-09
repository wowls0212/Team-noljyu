package com.mbc.nol.how;

import java.util.ArrayList;

public interface HowService {

	void howinsert(String id, String howtitle, String howdetail, String howimg);

	ArrayList<HowDTO> howout();

	HowDTO howdetailout(int hownum);

	void howreview(int hownum, String id, String review);

	ArrayList<HowReviewDTO> howreviewout(int hownum);

	HowReviewDTO howrere(int hownum);

	void howstepup(int groups, int step);

	void howreinsert(int hownum, String id, String review, int groups, int step, int indent);

}
