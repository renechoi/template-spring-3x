package kr.rene.template.sampledomain1.api.application.facade;

import kr.rene.template.sampledomain1.api.interfaces.dto.UserAccountCreateRequest;

/**
 * @author : Rene Choi
 * @since : 2023/12/20
 */
public interface UserAccountFacade {
	void saveWithObjectMapper(UserAccountCreateRequest userAccountCreateRequest);

	void saveWithModelMapper(UserAccountCreateRequest userAccountCreateRequest);

	void saveWithMapStruct(UserAccountCreateRequest userAccountCreateRequest);

	void saveWithBuilder(UserAccountCreateRequest userAccountCreateRequest);
}
