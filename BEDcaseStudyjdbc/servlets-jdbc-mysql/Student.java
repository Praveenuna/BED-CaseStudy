package net.javaguides.AssignmentCategory.model;

import java.io.Serializable;
public class AssignmentCategory implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String SerialNo;
    private String StudentName;
    private String Subject;
    private String AssignmentCategory;
    private String Dataofsubmission;
    private String Points;
    public String getSerialNo() {
        return SerialNo;
    }
    public void setSerialNo(String SerialNo) {
        this.SerialNo = SerialNo;
    }
    public String getStudentName() {
        return StudentName;
    }
    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }
    public String getSubject() {
        return Subject;
    }
    public void setSubject(String Subject) {
        this.Subject = Subject;
    }
    public String getAssignmentCategory() {
        return AssignmentCategory;
    }
    public void setAssignmentCategory(String AssignmentCategory) {
        this.AssignmentCategory = AssignmentCategory;
    }
    public String getDataofsubmission() {
        return Dataofsubmission;
    }
    public void setDataofsubmission(String Dataofsubmission) {
        this.Dataofsubmission = Dataofsubmission;
    }
    public String getPoints() {
        return Points;
    }
    public void setPoints(String Points) {
        this.Points = Points;
    }
}
