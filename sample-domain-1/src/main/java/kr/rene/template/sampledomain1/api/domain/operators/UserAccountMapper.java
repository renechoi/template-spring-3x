package kr.rene.template.sampledomain1.api.domain.operators;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import kr.rene.template.sampledomain1.api.domain.model.entity.aggregate.root.UserAccount;
import kr.rene.template.sampledomain1.api.interfaces.dto.UserAccountCreateRequest;

/**
 * @author : Rene Choi
 * @since : 2023/12/20
 */
@Mapper
public interface UserAccountMapper {

	UserAccountMapper INSTANCE = Mappers.getMapper(UserAccountMapper.class);

	UserAccount userAccountCreateRequestToUserAccount(UserAccountCreateRequest request);
}