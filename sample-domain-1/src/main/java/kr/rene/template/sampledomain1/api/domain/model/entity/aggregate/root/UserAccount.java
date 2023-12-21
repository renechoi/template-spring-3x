package kr.rene.template.sampledomain1.api.domain.model.entity.aggregate.root;


import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import kr.rene.template.sampledomain1.api.domain.model.entity.aggregate.UserContactInfo;
import kr.rene.template.sampledomain1.api.domain.model.entity.aggregate.UserProfile;
import kr.rene.template.sampledomain1.api.domain.model.entity.aggregate.UserSettings;
import kr.rene.template.sampledomain1.api.domain.operators.UserAccountMapper;
import kr.rene.template.sampledomain1.api.infrastructure.persistence.impl.EntityAutoAuditListener;
import kr.rene.template.sampledomain1.api.interfaces.dto.UserAccountCreateRequest;
import kr.rene.template.sampledomain1.common.mapper.impl.ModelMapperBasedVoMapper;
import kr.rene.template.sampledomain1.common.mapper.impl.ObjectMapperBasedVoMapper;
import kr.rene.template.sampledomain1.common.model.persistence.ActivityAudit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


/**
 * @author : Rene Choi
 * @since : 2023/12/19
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Audited(withModifiedFlag = true)
@Table(name = "user_account", indexes = {@Index(name = "idx_user_composite", columnList = "username, email"),})
@EntityListeners({AuditingEntityListener.class, EntityAutoAuditListener.class})
public class UserAccount extends ActivityAudit {

	@Id
	private String userAccountId;

	@Column(nullable = false, length = 50, columnDefinition = "VARCHAR(50) COMMENT '사용자 이름'")
	private String username;

	@Column(nullable = false, length = 100, columnDefinition = "VARCHAR(100) COMMENT '이메일 주소'")
	private String email;

	@Column(nullable = false, columnDefinition = "VARCHAR(255) COMMENT '비밀번호'")
	private String password;

	@Column(nullable = false, columnDefinition = "BIT COMMENT '활성 상태'")
	private boolean isActive;

	@Embedded
	private UserProfile profile;

	@Embedded
	private UserSettings settings;

	@Embedded
	private UserContactInfo contactInfo;

	public static UserAccount fromWithObjectMapper(UserAccountCreateRequest userAccountCreateRequest) {
		return ObjectMapperBasedVoMapper.convert(userAccountCreateRequest, UserAccount.class);
	}

	public static UserAccount fromWithModelMapper(UserAccountCreateRequest userAccountCreateRequest) {
		return ModelMapperBasedVoMapper.convert(userAccountCreateRequest, UserAccount.class);
	}

	public static UserAccount fromWithMapStruct(UserAccountCreateRequest userAccountCreateRequest) {
		return UserAccountMapper.INSTANCE.userAccountCreateRequestToUserAccount(userAccountCreateRequest);
	}


	public static UserAccount fromWithBuilder(UserAccountCreateRequest userAccountCreateRequest) {
		return UserAccount.builder()
			.userAccountId(userAccountCreateRequest.getUserAccountId())
			.username(userAccountCreateRequest.getUsername())
			.email(userAccountCreateRequest.getEmail())
			.password(userAccountCreateRequest.getPassword())
			.isActive(userAccountCreateRequest.isActive())
			.profile(userAccountCreateRequest.getProfile())
			.settings(userAccountCreateRequest.getSettings())
			.contactInfo(userAccountCreateRequest.getContactInfo())
			.build();
	}




	public UserAccount withGeneratedPk(String id) {
		this.userAccountId = id;
		return this;
	}

	public void updateProfile(UserProfile newProfile) {
		this.profile = newProfile;
	}

	public void updateSettings(UserSettings newSettings) {
		this.settings = newSettings;
	}

	public void updateContactInfo(UserContactInfo newContactInfo) {
		this.contactInfo = newContactInfo;
	}


}
