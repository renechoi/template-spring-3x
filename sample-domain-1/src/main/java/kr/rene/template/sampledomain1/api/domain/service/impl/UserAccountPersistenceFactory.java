package kr.rene.template.sampledomain1.api.domain.service.impl;

import kr.rene.template.sampledomain1.api.domain.model.entity.aggregate.root.UserAccount;

/**
 * @author : Rene Choi
 * @since : 2023/12/20
 */
public interface UserAccountPersistenceFactory {
	void save(UserAccount userAccount);
}
