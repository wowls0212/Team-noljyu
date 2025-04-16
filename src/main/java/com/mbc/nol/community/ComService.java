package com.mbc.nol.community;

import java.util.ArrayList;

public interface ComService {

	void comsave(String id, String comtitle, String comdetail, String comimg, String comtype);

	ArrayList<ComDTO> comout();

	ComDTO comdetail(int comnum);

	void comreview(int comnum, String id, String review, String posttype);

	ArrayList<ComReviewDTO> comreviewout(int comnum, ComPageDTO pdto);

	ComReviewDTO comrere(int comreviewnum);

	void comstepup(int groups, int step);

	void comreinsert(int comnum, String id, String comreview, int comgroups, int comstep, int comindent, String posttype);

	ComDTO comupdateout(int comnum);

	void comupdate(int comnum, String comtitle, String comdetail);

	void comupdateimg(int comnum, String comtitle, String comdetail, String comimg);

	void comdelete(int comnum);

	int comdeletecheck(int comnum);

	ArrayList<ComDTO> comsearchall(String comvalue);

	ArrayList<ComDTO> comsearch(String comkey, String comvalue);

	int comtotal();

	int comreviewtotal();

<<<<<<< HEAD
	ComReviewDTO comrereout(int reviewnum);

	int comrerecheck(String review);
=======
	ComReviewDTO rereout(int reviewnum);

	int rerecheck(String review);
>>>>>>> 8546762916583da98135734a1f7933dd5da22e86

	void comreviewupdate(int reviewnum, String review);

	int comreviewcheck(String review);

	void comreviewdelete(int reviewnum);

	int comreviewdeletecheck(int reviewnum);

	
}
