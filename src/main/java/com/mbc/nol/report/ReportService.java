package com.mbc.nol.report;

import java.util.ArrayList;

public interface ReportService {

	void postreport(int num, String id);

	void save(int postnum, String postid, String reason, String reportid ,String detail);

	ArrayList<ReportDTO> postreportout();

	void redel(int reportnum);

	void resave(int postnum, int reviewnum, String id, String reason, String detail, String reportid);

	ArrayList<ReportDTO> rereportout();

}
