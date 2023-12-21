package kr.rene.template.sampledomain1.api.interfaces.dto;

import kr.rene.template.sampledomain1.api.domain.model.entity.aggregate.UserContactInfo;
import kr.rene.template.sampledomain1.api.domain.model.entity.aggregate.UserProfile;
import kr.rene.template.sampledomain1.api.domain.model.entity.aggregate.UserSettings;
import kr.rene.template.sampledomain1.common.model.dto.AbstractAuditDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author : Rene Choi
 * @since : 2023/12/20
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserAccountCreateRequest extends AbstractAuditDto {
	private String userAccountId;
	private String username;
	private String email;
	private String password;
	private boolean isActive;
	private UserProfile profile;
	private UserSettings settings;
	private UserContactInfo contactInfo;
}
