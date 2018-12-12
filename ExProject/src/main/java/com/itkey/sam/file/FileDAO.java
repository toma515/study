package com.itkey.sam.file;

public interface FileDAO {
	/**
	 * 파일 상제 정보 조회
	 * @param map 조회조건
	 * @return 결과 데이터
	 */
	public FileDTO selectFileDetail(FileDTO fDTO)throws Exception;
}
