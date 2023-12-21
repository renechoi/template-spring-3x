package kr.rene.template.sampledomain1.common.logtrace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : Rene Choi
 * @since : 2023/12/19
 */

@Getter
@AllArgsConstructor
public class TraceStatus {

	private TraceId traceId;
	private Long startTimeMs;
	private String message;
}