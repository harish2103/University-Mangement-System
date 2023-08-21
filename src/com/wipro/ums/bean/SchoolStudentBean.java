package com.wipro.ums.bean;


public class SchoolStudentBean extends StudentBean {

    public SchoolStudentBean(String sName, char sType, int sAge, int sStudentAdmNo, int[] sMarks) {
        // Zero argument constructor
    }

    @Override
    public int calcGradePoint(int[] marks) {
        // Implementation of calcGradePoints based on the "Table for School Student"
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
        } else if (averageMarks >= 50 && averageMarks < 60) {
            return 6;
        } else if (averageMarks >= 40 && averageMarks < 50) {
            return 5;
        } else if (averageMarks >= 32 && averageMarks < 40) {
            return 4;
        } else if (averageMarks >= 20 && averageMarks < 32) {
            return 3;
        } else if (averageMarks >= 0 && averageMarks < 20) {
            return 0;
        } else {
            return -1; // Return -1 for any case not specified in the table
        }
    }

    @Override
    public String calcGrade(int sGradePoint) {
        // Implementation of calcGrade based on the "Table for School Student"
        switch (sGradePoint) {
            case 10:
                return "A1";
            case 9:
                return "A2";
            case 8:
                return "B1";
            case 7:
                return "B2";
            case 6:
                return "C1";
            case 5:
                return "C2";
            case 4:
                return "D";
            case 3:
                return "E1";
            case 0:
                return "E2";
            default:
                return null; // Return null for any case not specified in the table

        }
    }
}
