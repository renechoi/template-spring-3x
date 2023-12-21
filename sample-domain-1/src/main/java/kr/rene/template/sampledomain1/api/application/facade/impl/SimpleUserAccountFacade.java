package kr.rene.template.sampledomain1.api.application.facade.impl;

import kr.rene.template.sampledomain1.api.application.facade.UserAccountFacade;
import kr.rene.template.sampledomain1.api.domain.service.UserAccountCrudService;
import kr.rene.template.sampledomain1.api.interfaces.dto.UserAccountCreateRequest;
import kr.rene.template.sampledomain1.common.annotation.Facade;
import lombok.RequiredArgsConstructor;

/**
 * @author : Rene Choi
 * @since : 2023/12/20
 */
@Facade
@RequiredArgsConstructor
public class SimpleUserAccountFacade implements UserAccountFacade {
	private final UserAccountCrudService userAccountCrudService;


	@Override
	public void saveWithObjectMapper(UserAccountCreateRequest userAccountCreateRequest){
		userAccountCrudService.saveWithObjectMapper(userAccountCreateRequest);
	}

	@Override
	public void saveWithModelMapper(UserAccountCreateRequest userAccountCreateRequest) {
		userAccountCrudService.saveWithModelMapper(userAccountCreateRequest);
	}

	@Override
	public void saveWithMapStruct(UserAccountCreateRequest userAccountCreateRequest) {
		userAccountCrudService.saveWithMapStruct(userAccountCreateRequest);
	}

	@Override
	public void saveWithBuilder(UserAccountCreateRequest userAccountCreateRequest) {
		userAccountCrudService.saveWithBuilder(userAccountCreateRequest);
	}
}
