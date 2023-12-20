package kr.rene.template.sampledomain1.api.interfaces.resolver;

import java.lang.reflect.Type;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import jakarta.servlet.http.HttpServletRequest;
import kr.rene.template.sampledomain1.common.model.dto.AbstractAuditDto;
import lombok.RequiredArgsConstructor;

/**
 * @author : Rene Choi
 * @since : 2023/12/20
 */
@Component
@RequiredArgsConstructor
@ControllerAdvice(annotations = RestController.class)
public class CustomRequestBodyAdvice extends RequestBodyAdviceAdapter {

	private final HttpServletRequest request;

	@Override
	public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
		return AbstractAuditDto.class.isAssignableFrom(methodParameter.getParameterType());
	}

	@Override
	public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
		if (body instanceof AbstractAuditDto) {
			AbstractAuditDto auditDto = (AbstractAuditDto) body;
			auditDto.setCreatedIp(getClientIp());
		}
		return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
	}

	private String getClientIp() {
		String xForwardedForHeader = request.getHeader("X-Forwarded-For");
		if (xForwardedForHeader != null) {
			return xForwardedForHeader.split(",")[0].trim();
		} else {
			return request.getRemoteAddr();
		}
	}
}
