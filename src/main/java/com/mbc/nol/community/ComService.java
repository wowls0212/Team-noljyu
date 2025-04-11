package com.mbc.nol.community;

import java.util.ArrayList;

public interface ComService {

	void comsave(String id, String comtitle, String comdetail, String comimg);

	ArrayList<ComDTO> comout();

	ComDTO comdetail(int comnum);

	void comreview(int comnum, String id, String comreview);

	ArrayList<ComReviewDTO> comreviewout(int comnum);

	ComReviewDTO comrere(int comreviewnum);

	void comstepup(int comgroups, int comstep);

	void comreinsert(int comnum, String id, String comreview, int comgroups, int comstep, int comindent);

	ComDTO comupdateout(int comnum);

	void comupdate(int comnum, String comtitle, String comdetail);

	void comupdateimg(int comnum, String comtitle, String comdetail, String comimg);

	void comdelete(int comnum);

	int comdeletecheck(int comnum);

	ArrayList<ComDTO> comsearchall(String comvalue);

	ArrayList<ComDTO> comsearch(String comkey, String comvalue);

}
