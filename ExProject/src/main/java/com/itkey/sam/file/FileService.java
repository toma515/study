package com.itkey.sam.file;

public interface FileService {
	/**
	 * 파일 상세정보 조회
	 * @param fileIdx 조회조건
	 * @return 결과 목록
	 */
	public FileDTO getFileDetail(FileDTO fDTO) throws Exception;
}
