package com.wipro.ums.bean;

public abstract class StudentBean {
    private String studentId;
    private String studentName;
    private int studentAge;
    private char studentType;
    private int studentAdmNo;
    private int[] studentMarks;
    private int studentGP;

    public StudentBean() {
        // Zero argument constructor
    }

    // Getters and setters for all attributes
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public char getStudentType() {
        return studentType;
    }

    public void setStudentType(char studentType) {
        this.studentType = studentType;
    }

    public int getStudentAdmNo() {
        return studentAdmNo;
    }

    public void setStudentAdmNo(int studentAdmNo) {
        this.studentAdmNo = studentAdmNo;
    }

    public int[] getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(int[] studentMarks) {
        this.studentMarks = studentMarks;
    }

    public int getStudentGP() {
        return studentGP;
    }

    public void setStudentGP(int studentGP) {
        this.studentGP = studentGP;
    }

    // Abstract methods
    public abstract int calcGradePoint(int[] marks);

    public abstract String calcGrade(int sGradePoint);

    public int calcGradePoints() {
        return 0;
    }

    public void setStudentGrade(String studentGrade) {
    }
}
