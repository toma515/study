package com.itkey.sam.sample;

public class SampleDTO {
	
	private String boardIdx             = null;// Index 값 (auto incremelogin table의 Index값으로 활용)
	private String boardTitle           = null;// 글의 제목
	private String boardContents        = null;// 글의 내용
	private String boardParent          = null;// 부모글의 index값 (댓글, 대댓nt)
	private String boardWriter          = null;// 작성자 (차후 Login기능 구현시 글 구현시) 부모가 없을때(본글) null로 처리
	private String boardSeq             = null;// 댓글 대댓글의 순서 본글인 경우 seq는 1이며 댓글, 대댓글일시 seq+1씩 증가
	private String boardViewCount       = null;// 조회
	private String fileIdx			= null;
	
	private int    sortNumber           = 0;// [paging 처리용 변수] 정렬순서 - 0:
	private int    offset               = 0;// [paging 처리용 변수] 시작 데이터 번호 = (조회 페이지 -1)*조회 데이터 개수
	private int    row                  = 0;// [paging 처리용 변수] 조회 데이터 개수
	public String getBoardIdx() {
		return boardIdx;
	}
	public void setBoardIdx(String boardIdx) {
		this.boardIdx = boardIdx;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContents() {
		return boardContents;
	}
	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}
	public String getBoardParent() {
		return boardParent;
	}
	public void setBoardParent(String boardParent) {
		this.boardParent = boardParent;
	}
	public String getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(String boardSeq) {
		this.boardSeq = boardSeq;
	}
	public String getBoardViewCount() {
		return boardViewCount;
	}
	public void setBoardViewCount(String boardViewCount) {
		this.boardViewCount = boardViewCount;
	}
	public int getSortNumber() {
		return sortNumber;
	}
	public void setSortNumber(int sortNumber) {
		this.sortNumber = sortNumber;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public String getFileIdx() {
		return fileIdx;
	}
	public void setFileIdx(String fileIndex) {
		this.fileIdx = fileIndex;
	}
}