package kr.rene.template.sampledomain1.api.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.rene.template.sampledomain1.api.domain.model.entity.aggregate.root.UserAccount;

/**
 * @author : Rene Choi
 * @since : 2023/12/20
 */
public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
}
