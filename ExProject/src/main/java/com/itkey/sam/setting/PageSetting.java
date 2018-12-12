package com.itkey.sam.setting;

public class PageSetting {
	private int pageSize = 10; // 한 페이지당 게시글 수
	private int rangeSize = 10; // 한 블럭당 페이지 수
	private int curPage = 1; // 현제 페이지 
	private int curRange = 1; // 현재블럭
	private int totalList = 0; // 총게시물 수
	private int totalPage = 1; // 총 페이지 수
	private int totalRange = 1; // 총 블럭 수 
	private int startRange = 0; // 블럭 처음 수 
	private int endRange = 0; // 블럭 마지막 수 
	
	public PageSetting(int curPage, int totalList) {
		/*현재 페이지 */
		setCurPage(curPage);
		/*총게시글*/
		setTotalList(totalList);
		
		/*총페이지*/
		setTotalPage(totalList);
		
		/*총블럭*/
		setTotalRange(totalPage);
		/*현재블록번호*/ 
		setCurRange(curPage);
		/*현재 블럭 처음 페이지번호*/
		setStartRange(curRange);	
		/*블록 마지막 페이지 번호*/
		setEndRange(startRange);
		
	}  

	public int getPageSize() {
		return pageSize;
	}

	public int getRangeSize() {
		return rangeSize;
	}

	public int getCurPage() {
		return curPage;
	}

	public int getCurRange() {
		return curRange;
	}

	public int getTotalList() {
		return totalList;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getTotalRange() {
		return totalRange;
	}

	public int getStartRange() {
		return startRange;
	}
	
	public int getEndRange() {
		return endRange;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public void setCurRange(int curPage) {
		this.curRange = (int)((curPage-1)/rangeSize)+1;
	}

	public void setTotalList(int totalList) {
		this.totalList = totalList;
	}

	public void setStartRange(int curRange) {
		this.startRange = (curRange-1)*rangeSize+1;
	}
	
	public void setEndRange(int startRange) {
		this.endRange = startRange + rangeSize -1;
		if(endRange > totalPage) {
		this.endRange = totalPage; }
	}
	
	public void setTotalPage(int totalList) {
		this.totalPage = (int)Math.ceil(totalList*1.0/pageSize);
	}
	
	public void setTotalRange(int totalPage) {
		this.totalRange = (int)Math.ceil(totalPage*1.0/rangeSize);
	}
	
}