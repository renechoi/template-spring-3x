package kr.rene.template.sampledomain1.api.infrastructure.persistence.impl;

import kr.rene.template.sampledomain1.api.domain.model.entity.aggregate.root.UserAccount;
import kr.rene.template.sampledomain1.api.domain.service.impl.UserAccountPersistenceFactory;
import kr.rene.template.sampledomain1.api.infrastructure.persistence.UserAccountRepository;
import kr.rene.template.sampledomain1.common.annotation.Factory;
import lombok.RequiredArgsConstructor;

/**
 * @author : Rene Choi
 * @since : 2023/12/20
 */
@Factory
@RequiredArgsConstructor
public class SimpleUserAccountPersistenceFactory implements UserAccountPersistenceFactory {
	private final UserAccountRepository repository;

	@Override
	public void save(UserAccount userAccountRequest) {
		repository.save(userAccountRequest);
	}
}
