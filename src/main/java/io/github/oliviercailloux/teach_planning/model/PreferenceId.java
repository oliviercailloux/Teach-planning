package io.github.oliviercailloux.teach_planning.model;

import java.io.Serializable;

public class PreferenceId implements Serializable{
	private static final long serialVersionUID = 1L;
	private int teacherId;
	private int teachingId;
	private Choice choice;

	@Override
	public int hashCode() {
		return teacherId + teachingId;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof PreferenceId) {
			PreferenceId otherId = (PreferenceId) object;
			return (otherId.teacherId == this.teacherId) && (otherId.teachingId == this.teachingId) && (otherId.choice == this.choice) ;
		}
		return false;
	}
}
