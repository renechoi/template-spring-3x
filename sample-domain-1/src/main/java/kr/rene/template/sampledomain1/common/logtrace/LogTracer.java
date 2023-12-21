package kr.rene.template.sampledomain1.common.logtrace;

import kr.rene.template.sampledomain1.common.logtrace.model.TraceStatus;

/**
 * @author : Rene Choi
 * @since : 2023/12/19
 */
public interface LogTracer {

	TraceStatus begin(String message);
	void end(Object result, TraceStatus status);
	void exception(Object result, TraceStatus status, Exception e);
}