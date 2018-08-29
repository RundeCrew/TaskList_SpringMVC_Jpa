package co.grandcircus.TaskList.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name= "task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String description;
	String dueDate;
	Boolean complete;
	
	@ManyToOne
	private User user;
		
	public Task() {
		
	}
	
	public Task(Long id, User user, String description, String dueDate, Boolean complete) {
			this.id = id;
			this.description = description;
			this.dueDate = dueDate;
			this.complete = complete;
}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public Boolean getComplete() {
		return complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
