package com.wipro.ums.service;

import com.wipro.ums.bean.SchoolStudentBean;
import com.wipro.ums.bean.CollegeStudentBean;
import com.wipro.ums.bean.StudentBean;
import com.wipro.ums.dao.StudentDAO;

public class StudentService {

    private static final String STUD_SEQ = "12345";

    public String generateID(String studentName, int studentAdmNo) {
        String initials = studentName.substring(0, 2).toUpperCase();
        String studentId = initials + STUD_SEQ;
        return studentId;
    }

    public String validateStudent(String sName, char sType, int sAge, int sAdmNo, int[] sMarks) {
        if (sName == null || sMarks == null) {
            return "Invalid Student Details";
        }

        if (sAge <= 0 || sAdmNo <= 0 || (sType != 'S' && sType != 'C')) {
            return "Invalid Student Details";
        }

        for (int mark : sMarks) {
            if (mark < 0 || mark > 100) {
                return "Invalid Marks";
            }
        }

        if (String.valueOf(sAdmNo).length() > 10) {
            return "Incorrect Admission No";
        }

        if (sAge < 0 || sAge > 26) {
            return "Invalid Age";
        }

        return "SUCCESS";
    }

    public String addStudent(String sName, char sType, int sAge, int sStudentAdmNo, int[] sMarks) {
        String validationMessage = validateStudent(sName, sType, sAge, sStudentAdmNo, sMarks);

        if (!validationMessage.equals("SUCCESS")) {
            return "Invalid Input";
        }

        StudentBean studentBean;
        if (sType == 'S') {
            studentBean = new SchoolStudentBean(sName, sType, sAge, sStudentAdmNo, sMarks);
        } else {
            studentBean = new CollegeStudentBean(sName, sType, sAge, sStudentAdmNo, sMarks);
        }

        String studentId = generateID(sName, sStudentAdmNo);
        studentBean.setStudentId(studentId);

        int studentGP = studentBean.calcGradePoints();
        String studentGrade = studentBean.calcGrade(studentGP);
        studentBean.setStudentGP(studentGP);
        studentBean.setStudentGrade(studentGrade);

        StudentDAO studentDAO = new StudentDAO();
        String addResult = studentDAO.addStudent(studentBean);

        return addResult.equals("SUCCESS") ? "SUCCESS" : "FAILURE";
    }
}

