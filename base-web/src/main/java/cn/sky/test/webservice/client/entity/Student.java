package cn.sky.test.webservice.client.entity;

import java.util.List;
import java.util.Map;

public class Student {

	private String name;
	private String grades;
	private List<String> teacher;
	private Map<String, String> achievement;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrades() {
		return grades;
	}

	public void setGrades(String grades) {
		this.grades = grades;
	}

	public List<String> getTeacher() {
		return teacher;
	}

	public void setTeacher(List<String> teacher) {
		this.teacher = teacher;
	}

	public Map<String, String> getAchievement() {
		return achievement;
	}

	public void setAchievement(Map<String, String> achievement) {
		this.achievement = achievement;
	}

}
