package kr.rene.template.sampledomain1.common.model.persistence;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author : Rene Choi
 * @since : 2023/12/19
 */
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class ActivityAudit {

	@CreatedDate
	@Column(updatable = false, columnDefinition = "datetime(3) COMMENT '등록 일시'")
	private LocalDateTime createdAt;

	@Column(length = 100, columnDefinition = "VARCHAR(100) COMMENT '등록자 아이디'")
	private String createdBy;

	@Column(length = 100, columnDefinition = "VARCHAR(100) COMMENT '등록자 아이피'")
	private String createdIp;

	@LastModifiedDate
	@Column(columnDefinition = "datetime(3) COMMENT '수정 일시'")
	private LocalDateTime modifiedAt;

	@Column(length = 100, columnDefinition = "VARCHAR(100) COMMENT '수정자 아이디'")
	private String modifiedBy;

	@Column(length = 100, columnDefinition = "VARCHAR(100) COMMENT '수정자 아이피'")
	private String modifiedIp;
}
