package kr.rene.template.sampledomain1.api.interfaces.filter;

import java.time.LocalDateTime;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;

/**
 * @author : Rene Choi
 * @since : 2023/12/20
 */
public class RequestTimeRecordFilter implements Filter {

	@Override
	@SneakyThrows
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)  {

		if (request instanceof HttpServletRequest) {
			request.setAttribute("requestReceivedTime", LocalDateTime.now());
		}

		chain.doFilter(request, response);
	}
}