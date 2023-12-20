package kr.rene.template.sampledomain1.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.rene.template.sampledomain1.api.interfaces.filter.RequestTimeRecordFilter;

/**
 * @author : Rene Choi
 * @since : 2023/12/20
 */
@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean<RequestTimeRecordFilter> requestTimeRecordFilterFilterRegistrationBean() {
		FilterRegistrationBean<RequestTimeRecordFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new RequestTimeRecordFilter());
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(1);
		return registrationBean;
	}

}
