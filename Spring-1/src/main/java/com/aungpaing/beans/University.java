package com.aungpaing.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class University {

	private Teacher teacher;

	public University() {

	}

	public University(Teacher teacherBean) {
		this.teacher = teacherBean;
	}

	public void show() {
		System.out.println("Show Uni");

	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
