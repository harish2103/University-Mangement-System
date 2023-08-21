package com.wipro.ums.bean;



public class CollegeStudentBean extends StudentBean {

    public CollegeStudentBean(String sName, char sType, int sAge, int sStudentAdmNo, int[] sMarks) {
        // Zero argument constructor
    }

    @Override
    public int calcGradePoint(int[] marks) {
        // Implementation of calcGradePoints based on the "Table for College Student"
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        int averageMarks = sum / marks.length;

        if (averageMarks >= 90 && averageMarks <= 100) {
            return 10;
        } else if (averageMarks >= 80 && averageMarks < 90) {
            return 9;
        } else if (averageMarks >= 70 && averageMarks < 80) {
            return 8;
        } else if (averageMarks >= 60 && averageMarks < 70) {
            return 7;
        } else if (averageMarks >= 55 && averageMarks < 60) {
            return 6;
        } else if (averageMarks >= 45 && averageMarks < 55) {
            return 5;
        } else if (averageMarks >= 40 && averageMarks < 45) {
            return 4;
        } else if (averageMarks < 40) {
            return 0;
        } else {
            return -1; // Return -1 for any case not specified in the table
        }
    }

    @Override
    public String calcGrade(int sGradePoint) {
        // Implementation of calcGrade based on the "Table for College Student"
        switch (sGradePoint) {
            case 10:
                return "A+";
            case 9:
                return "A";
            case 8:
                return "B+";
            case 7:
                return "B";
            case 6:
                return "C+";
            case 5:
                return "C";
            case 4:
                return "D";
            case 0:
                return "F";
            default:
                return null; // Return null for any case not specified in the table
        }
    }
}

