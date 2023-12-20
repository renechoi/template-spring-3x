package kr.rene.template.sampledomain1.common.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author : Rene Choi
 * @since : 2023/12/20
 */
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractAuditDto {
	private LocalDateTime createdAt;
	private String createdBy;
	private String createdIp;
	private LocalDateTime modifiedAt;
	private String modifiedBy;
	private String modifiedIp;
}
