package com.wipro.ums.dao;

import com.wipro.ums.bean.StudentBean;

public class StudentDAO {
    private static final String STUD_TABLE = "STUD_TABLE";

    public String addStudent(StudentBean studBean) {
        
        try {
           
            return "SUCCESS";
        } catch (Exception e) {
            
            return "FAILURE";
        }
    }
}