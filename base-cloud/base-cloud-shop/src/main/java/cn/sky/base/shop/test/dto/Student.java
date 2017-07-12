package cn.sky.base.shop.test.dto;

import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Student", description = "学生")
public class Student {

	@ApiModelProperty(value = "名字")
	private String name;

	@ApiModelProperty(value = "年级")
	private String grades;

	@ApiModelProperty(value = "老师")
	private List<String> teacher;

	@ApiModelProperty(value = "成绩")
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
