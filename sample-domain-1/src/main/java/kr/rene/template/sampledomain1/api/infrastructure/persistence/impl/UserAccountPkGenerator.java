package kr.rene.template.sampledomain1.api.infrastructure.persistence.impl;

import static java.time.LocalDateTime.*;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

import kr.rene.template.sampledomain1.api.domain.operators.PkGenerator;
import kr.rene.template.sampledomain1.api.interfaces.dto.UserAccountCreateRequest;
import kr.rene.template.sampledomain1.common.annotation.Operator;
import lombok.RequiredArgsConstructor;

/**
 * @author : Rene Choi
 * @since : 2023/12/20
 */
@Operator
@RequiredArgsConstructor
public class UserAccountPkGenerator implements PkGenerator<UserAccountCreateRequest> {

	private static final AtomicInteger counter = new AtomicInteger(0);


	@Override
	public String generate(UserAccountCreateRequest data) {
		String datePart = now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSSSSS", Locale.KOREA));
		String usernamePart = extractPart(convertToAscii(data.getUsername()), 3);
		String emailPart = extractPart(data.getEmail(), 3);

		return String.format("KR-SAMPLE-%s-%s-%s", datePart, usernamePart, emailPart);
	}

	private String extractPart(String source, int length) {
		return source.length() > length ? extractWithLength(source, length) : extractOrDefault(source);
	}

	private String extractWithLength(String source, int length) {
		return source.substring(0, length);
	}

	private String extractOrDefault(String source) {
		return source.isEmpty() ? getDefaultString() : source;
	}

	private String getDefaultString() {
		return String.format("%03d", counter.incrementAndGet());
	}

	private String convertToAscii(String input) {
		return input.replaceAll("[^\\x00-\\x7F]", "");
	}
}
