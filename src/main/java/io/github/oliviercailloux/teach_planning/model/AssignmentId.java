package io.github.oliviercailloux.teach_planning.model;

import java.io.Serializable;

public class AssignmentId implements Serializable{
	private static final long serialVersionUID = 1L;
	private int teacherId;
	private int teachingId;

	@Override
	public int hashCode() {
		return teacherId + teachingId;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof AssignmentId) {
			AssignmentId otherId = (AssignmentId) object;
			return (otherId.teacherId == this.teacherId) && (otherId.teachingId == this.teachingId);
		}
		return false;
	}
}
