package net.javaguides.AssignmentCategory.model;

/**
 * User.java
 * This is a model class represents a User entity
 * 
 */
public class Student {
	protected String assignmentcategory;
	protected String weight;
	
	public Student() {
	}
	
	public Student(String assignmentcategory, String weight) {
		super();
		this.assignmentcategory = assignmentcategory;
		this.weight = weight;
	}

	public Student(String assignmentcategory, String weight) {
		super();
		this.assignmentcategory = assignmentcategory;
		this.weight = weight;
	}

	public String getAssignmentCategory() {
		return assignmentcategory;
	}
	public void setAssignmentCategory(String AssignmentCategory) {
		this.AssignmentCategory = AssignmentCategory;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
}