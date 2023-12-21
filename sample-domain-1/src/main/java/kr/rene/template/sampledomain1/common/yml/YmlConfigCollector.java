package kr.rene.template.sampledomain1.common.yml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author : Rene Choi
 * @since : 2023/12/20
 */
@Component
@RequiredArgsConstructor
@Getter
public class YmlConfigCollector {

	@Value("${spring.application.name}")
	private String serviceName;

	@Value("${server.port}")
	private String port;

	@Value("${server.servlet.context-path}")
	private String contextPath;
}
