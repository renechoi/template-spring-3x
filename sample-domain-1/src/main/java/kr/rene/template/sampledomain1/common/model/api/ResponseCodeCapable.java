package kr.rene.template.sampledomain1.common.model.api;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author : Rene Choi
 * @since : 2023/12/19
 */
@Getter
@RequiredArgsConstructor
public enum ResponseCodeCapable implements ResponseCapable {

	SUCCESS("0000", "성공", HttpStatus.OK),
	FAIL("9000", "실패", HttpStatus.INTERNAL_SERVER_ERROR);


	private final String code;
	private final String message;
	private final HttpStatus httpStatus;

}
