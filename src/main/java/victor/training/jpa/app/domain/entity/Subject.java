package victor.training.jpa.app.domain.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import victor.training.jpa.app.util.MyTrackingEntityListener;
import victor.training.jpa.app.util.MyTrackingEntityListener.Trackable;

@Entity
public class Subject  {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private boolean active;
	@ManyToOne
	@JoinColumn(name = "TEACHER_ID")
	private Teacher holderTeacher;

	@OneToMany(mappedBy = "subject")
	private List<TeachingActivity> activities = new ArrayList<>();

	private LocalDateTime lastModifiedDate;
	
	private String lastModifiedBy;

	
//	@PrePersist
//	@PreUpdate
//	public void automaticUpdateTrackingColumns() {
//		System.out.println("Before persist/update Subject");
//		lastModifiedDate = LocalDateTime.now();
//		lastModifiedBy = MyUtil.getUserOnCurrentThread();
//	}
	
	
	
	public Subject() {
	}
	
	
	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public Subject(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getHolderTeacher() {
		return holderTeacher;
	}

	void setHolderTeacher(Teacher holder) {
		this.holderTeacher = holder;
	}

	public List<TeachingActivity> getActivities() {
		return activities;
	}

	public void setActivities(List<TeachingActivity> activities) {
		this.activities = activities;
	}
	
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	
	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	
	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
}
