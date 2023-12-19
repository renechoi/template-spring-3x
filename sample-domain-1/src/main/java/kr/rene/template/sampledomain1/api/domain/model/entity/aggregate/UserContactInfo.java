package kr.rene.template.sampledomain1.api.domain.model.entity.aggregate;

import jakarta.persistence.Embeddable;

/**
 * @author : Rene Choi
 * @since : 2023/12/19
 */
@Embeddable
public class UserContactInfo {
	private String phoneNumber;
	private String address;
}