package com.itkey.sam.file;

public class FileDTO {
	private String fileIdx             		 = null;
	private String fileOriginalName          = null;
	private String filePath        			 = null;
	private String fileChangedName       	 = null;
	
	private String fIDX 					 = null; // insert 할때 index를 받기위한 변수
	private String handleFile 				 = null; // 수정된 게시글 파일들의 처리여부 기존 파일 : N 
													 // 생성해야되는 파일 : C
													 // 삭제해야되는 파일 : D
	
	public String getFileIdx() {
		return fileIdx;
	}
	public void setFileIdx(String fileIdx) {
		this.fileIdx = fileIdx;
	}
	public String getFileOriginalName() {
		return fileOriginalName;
	}
	public void setFileOriginalName(String fileOriginalName) {
		this.fileOriginalName = fileOriginalName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileChangedName() {
		return fileChangedName;
	}
	public void setFileChangedName(String fileChangedName) {
		this.fileChangedName = fileChangedName;
	}
	public String getfIDX() {
		return fIDX;
	}
	public void setfIDX(String fIDX) {
		this.fIDX = fIDX;
	}
	public String getHandleFile() {
		return handleFile;
	}
	public void setHandleFile(String handleFile) {
		this.handleFile = handleFile;
	}
	
	
	
}
