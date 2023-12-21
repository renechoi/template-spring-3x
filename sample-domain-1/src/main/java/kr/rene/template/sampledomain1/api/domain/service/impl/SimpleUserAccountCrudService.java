package kr.rene.template.sampledomain1.api.domain.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.rene.template.sampledomain1.api.domain.model.entity.aggregate.root.UserAccount;
import kr.rene.template.sampledomain1.api.domain.operators.PkGenerator;
import kr.rene.template.sampledomain1.api.domain.service.UserAccountCrudService;
import kr.rene.template.sampledomain1.api.interfaces.dto.UserAccountCreateRequest;
import lombok.RequiredArgsConstructor;

/**
 * @author : Rene Choi
 * @since : 2023/12/20
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SimpleUserAccountCrudService implements UserAccountCrudService {
	private final UserAccountPersistenceFactory persistenceFactory;
	private final PkGenerator<UserAccountCreateRequest> pkGenerator;

	@Override
	@Transactional
	public void saveWithObjectMapper(UserAccountCreateRequest createRequest){
		String id = pkGenerator.generate(createRequest);
		persistenceFactory.save(UserAccount.fromWithObjectMapper(createRequest).withGeneratedPk(id));
	}

	@Override
	@Transactional
	public void saveWithModelMapper(UserAccountCreateRequest createRequest) {
		String id = pkGenerator.generate(createRequest);
		persistenceFactory.save(UserAccount.fromWithModelMapper(createRequest).withGeneratedPk(id));
	}

	@Override
	@Transactional
	public void saveWithMapStruct(UserAccountCreateRequest createRequest) {
		String id = pkGenerator.generate(createRequest);
		persistenceFactory.save(UserAccount.fromWithMapStruct(createRequest).withGeneratedPk(id));
	}

	@Override
	@Transactional
	public void saveWithBuilder(UserAccountCreateRequest createRequest) {
		String id = pkGenerator.generate(createRequest);
		persistenceFactory.save(UserAccount.fromWithBuilder(createRequest).withGeneratedPk(id));
	}


}
