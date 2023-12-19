package kr.rene.template.sampledomain1.api.domain.model.entity.aggregate.root;


import org.hibernate.envers.Audited;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import kr.rene.template.sampledomain1.api.domain.model.entity.aggregate.UserContactInfo;
import kr.rene.template.sampledomain1.api.domain.model.entity.aggregate.UserProfile;
import kr.rene.template.sampledomain1.api.domain.model.entity.aggregate.UserSettings;
import kr.rene.template.sampledomain1.common.model.ActivityAudit;
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
