package kr.rene.template.sampledomain1.api.domain.model.entity;

import org.hibernate.envers.Audited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "category")
public class Category extends ActivityAudit {

	@Id
	private String categoryId;

	@Column(nullable = false, length = 100, columnDefinition = "VARCHAR(100) COMMENT '카테고리 이름'")
	private String name;

	@Column(length = 500, columnDefinition = "VARCHAR(500) COMMENT '카테고리 설명'")
	private String description;

	@Column(nullable = false, columnDefinition = "BIT COMMENT '활성 상태'")
	private boolean isActive;

}