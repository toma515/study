package com.itkey.sam.sample;

import java.util.List;

import com.itkey.sam.file.FileDTO;


public interface SampleDAO {

	/**
	 * 사용자 정보 조회
	 * @param eDTO 조회조건
	 * @return 결과 목록
	 */
	public List<SampleDTO> selectSampleList(SampleDTO eDTO) throws Exception;

	/**
	 * 사용자 상제 정보 조회
	 * @param map 조회조건
	 * @return 결과 데이터
	 */
	public SampleDTO selectBoardDetail(SampleDTO eDTO) throws Exception;
	
	
	
	/**
	 * 사용자 정보 데이터 갯수 조회
	 * @param eDTO 조회조건
	 * @return 데이터 갯수
	 */
	public int selectSampleCount(SampleDTO eDTO) throws Exception;

	/**
	 * 사용자 정보 생성
	 * @param eDTO 생성할 데이터
	 * @return 입력 데이터 개수 (selectKey 를 사용하여 key 를 딴 경우 입력 DTO에 해당 key 사용)
	 * @throws Exception
	 */
	public int insertSample(SampleDTO eDTO) throws Exception;

	/**
	 * 파일 정보 생성
	 * @param Map 생성할 데이터
	 * @return 입력 데이터 개수 
	 * @throws Exception
	 */
	public int insertFile(FileDTO fDTO) throws Exception;
	
	/**
	 * 사용자 정보 수정
	 * @param eDTO 수정할 데이터
	 * @return 성공여부 (수정된 데이터 개수)
	 * @throws Exception
	 */
	public int updateSample(SampleDTO eDTO) throws Exception;

	/**
	 * 조회수 증가
	 * @param eDTO 수정 조건
	 * @return 성공여부 (수정된 데이터 개수)
	 * @throws Exception
	 */
	public int updateViewCountUp(SampleDTO eDTO) throws Exception;
	
	/**
	 * 사용자 정보 삭제
	 * @param eDTO 삭제할 데이터 키값
	 * @return 성공여부 (삭제된 데이터 개수)
	 * @throws Exception
	 */
	public int deleteSample(String keyId) throws Exception;

	

	

}