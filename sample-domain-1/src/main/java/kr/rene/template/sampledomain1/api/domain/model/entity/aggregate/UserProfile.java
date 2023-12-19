package kr.rene.template.sampledomain1.api.domain.model.entity.aggregate;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;

/**
 * @author : Rene Choi
 * @since : 2023/12/19
 */
@Embeddable
public class UserProfile {
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
}