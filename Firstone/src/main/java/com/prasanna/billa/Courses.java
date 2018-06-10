package com.prasanna.billa;

import org.springframework.beans.factory.annotation.Required;

public class Courses {
    private Integer courseId;
    private String courseName;

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
    @Required
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public Integer getCourseId() {
        return courseId;
    }
    public String getCourseName() {
        return courseName;
    }
}
