package com.mbc.nol.board;

public class BoardDTO {
		int seq;   //글 번호
	    String title;  //글 제목
	    String content;  //본문내용
	    int hit; //조회수
	    
		public BoardDTO() {}
		public BoardDTO(int seq, String title, String content, String regdate, int hit) {
			super();
			this.seq = seq;
			this.title = title;
			this.content = content;
			this.hit = hit;
		}
		public int getSeq() {
			return seq;
		}
		public void setSeq(int seq) {
			this.seq = seq;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}

		public int getHit() {
			return hit;
		}
		public void setHit(int hit) {
			this.hit = hit;
		}
	
	
	
}
