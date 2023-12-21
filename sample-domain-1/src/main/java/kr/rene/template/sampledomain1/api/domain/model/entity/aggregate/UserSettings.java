package kr.rene.template.sampledomain1.api.domain.model.entity.aggregate;

import jakarta.persistence.Embeddable;
import lombok.Data;

/**
 * @author : Rene Choi
 * @since : 2023/12/19
 */
@Embeddable
@Data
public class UserSettings {
	private boolean emailNotificationsEnabled;
	private boolean smsNotificationsEnabled;
}