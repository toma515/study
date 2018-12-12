package com.itkey.sam.sample;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


/**
 * Service for SAMPLE_BOARD_TB table : 사용자 정보
**/
public interface SampleService {

	/**
	 * 사용자 정보 조회
	 * @param eDTO 조회 조건
	 * @return 결과 목록
	 */
	public List<SampleDTO> getSampleList(SampleDTO eDTO) throws Exception;

	/**
	 * 사용자 상세정보 조회
	 * @param eDTO 조회조건
	 * @return 결과 목록
	 */
	public SampleDTO getBoardDetail(SampleDTO eDTO) throws Exception;
	
	
	
	/**
	 * 사용자 정보 데이터 갯수 조회
	 * @param eDTO 조회 조건
	 * @return  데이터 갯수
	 */
	public int getSampleCount(SampleDTO eDTO) throws Exception;

	/**
	 * 사용자 정보 추가
	 * @param eDTO 생성할 데이터
	 * @return 입력 데이터 개수 (selectKey 를 사용하여 key 를 딴 경우 입력 DTO에 해당 key 사용)
	 * @throws Exception
	 */
	public int addSample(SampleDTO eDTO, HttpServletRequest request) throws Exception;

	/**
	 * 사용자 정보 수정
	 * @param eDTO 수정할 데이터
	 * @return 성공여부 (수정된 데이터 개수)
	 * @throws Exception
	 */
	public int chgSample(Map<String, Object> map, HttpServletRequest request) throws Exception;

	/**
	 * 사용자 정보 삭제
	 * @param eDTO 삭제할 데이터 키값
	 * @return 성공여부 (삭제된 데이터 개수)
	 * @throws Exception
	 */
	public int delSample(String keyId) throws Exception;

	

	

}
