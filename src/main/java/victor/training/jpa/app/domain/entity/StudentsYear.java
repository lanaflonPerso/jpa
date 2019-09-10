package victor.training.jpa.app.domain.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class StudentsYear  extends AbstractEntity {

	private String code;
	
	@OneToMany
	@JoinColumn
	private List<StudentsGroup> groups = new ArrayList<>();

	@OneToMany(mappedBy = "year")
	private Set<CourseActivity> courses = new HashSet<>();

	public StudentsYear() {
		
	}
	
	public StudentsYear(String code) {
		this.code = code;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<StudentsGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<StudentsGroup> groups) {
		this.groups = groups;
	}

	public Set<CourseActivity> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseActivity> courses) {
		this.courses = courses;
	}
	
	

	
}
