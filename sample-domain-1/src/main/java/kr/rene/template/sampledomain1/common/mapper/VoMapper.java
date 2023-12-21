package kr.rene.template.sampledomain1.common.mapper;

import java.util.List;

/**
 * VoMapper 인터페이스는 객체 매핑을 위한 기본 메소드를 정의합니다.
 * 이 인터페이스는 ObjectMapperBasedVoMapper 클래스에 의해 구현됩니다.
 *
 * @param <T> 변환을 원하는 원본 객체 타입
 * @param <U> 변환된 객체의 타입
 */
public interface VoMapper {

	/**
	 * 주어진 객체를 지정된 클래스 타입으로 변환합니다.
	 *
	 * @param from 변환할 객체
	 * @param to   변환될 객체의 클래스 타입
	 * @return 변환된 객체
	 */
	<T, U> U convert(T from, Class<U> to);

	/**
	 * 객체 리스트를 지정된 클래스 타입의 리스트로 변환합니다.
	 *
	 * @param from 변환할 객체 리스트
	 * @param to   변환될 객체의 클래스 타입
	 * @return 변환된 객체 리스트
	 */
	<T, U> List<U> convert(List<T> from, Class<U> to);

	/**
	 * 주어진 원본 객체의 비어 있지 않은 값들로 목적지 객체를 업데이트합니다.
	 *
	 * @param source      원본 객체
	 * @param destination 업데이트할 목적지 객체
	 * @return 업데이트된 객체
	 */
	<T, U> U updateWithNonNullValues(T source, U destination);
}
