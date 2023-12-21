package kr.rene.template.sampledomain1.api.infrastructure.persistence.impl;

import jakarta.persistence.PostPersist;
import kr.rene.template.sampledomain1.common.model.persistence.ActivityAudit;

/**
 * @author : Rene Choi
 * @since : 2023/12/19
 */
public class EntityAutoAuditListener {

	/**
	 * 수정자 아이디, 수정자 아이피, 수정일시가 초기 엔티티 생성시 등록자 아이디, 등록자 아이피, 등록일시로 등록되도록 합니다.
	 */
	@PostPersist
	public void postPersist(ActivityAudit target) {
		syncModifiedAtWithCreatedAt(target);
		syncModifiedByWithCreatedBy(target);
		syncModifiedIpWithCreatedIp(target);
	}

	private void syncModifiedByWithCreatedBy(ActivityAudit target) {
		if (target.getModifiedBy() == null || "".equals(target.getModifiedBy().trim())) {
			target.setModifiedBy(target.getCreatedBy());
		}
	}

	private void syncModifiedAtWithCreatedAt(ActivityAudit target) {
		if (target.getModifiedAt() == null) {
			target.setModifiedAt(target.getCreatedAt());
		}
	}

	private void syncModifiedIpWithCreatedIp(ActivityAudit target) {
		if (target.getModifiedIp() == null || "".equals(target.getModifiedIp().trim())) {
			target.setModifiedIp(target.getCreatedIp());
		}
	}

}
