package kr.rene.template.sampledomain1.api.domain.service;

import org.springframework.transaction.annotation.Transactional;

import kr.rene.template.sampledomain1.api.interfaces.dto.UserAccountCreateRequest;

/**
 * @author : Rene Choi
 * @since : 2023/12/20
 */
public interface UserAccountCrudService {
	@Transactional
	void saveWithObjectMapper(UserAccountCreateRequest userAccountCreateRequest);

	@Transactional
	void saveWithModelMapper(UserAccountCreateRequest userAccountCreateRequest);

	void saveWithMapStruct(UserAccountCreateRequest userAccountCreateRequest);

	@Transactional
	void saveWithBuilder(UserAccountCreateRequest createRequest);
}
