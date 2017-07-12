package cn.sky.test.webservice.client.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schoole {
	private String name;
	private List<Student> students;

	public static Schoole getSchoole() {
		Schoole schoole = new Schoole();
		schoole.setName("广东金融大学");
		List<Student> students = new ArrayList<Student>();
		Student gf = new Student();
		gf.setName("高甫");
		gf.setGrades("大四");
		Map<String, String> achievement = new HashMap<String, String>();
		achievement.put("计算机原理", "良");
		achievement.put("C语言编程基础", "优");
		achievement.put("java Web开发", "优");
		gf.setAchievement(achievement);
		List<String> teacher = new ArrayList<String>();
		teacher.add("董燕玲");
		teacher.add("吴匡威");
		gf.setTeacher(teacher);
		students.add(gf);

		Student wk = new Student();
		wk.setName("王孔");
		wk.setGrades("大六");
		Map<String, String> achievemen = new HashMap<String, String>();
		achievemen.put("市场原理", "良");
		achievemen.put("商场基础", "优");
		wk.setAchievement(achievemen);
		List<String> teachers = new ArrayList<String>();
		teachers.add("王珂");
		teachers.add("洛克");
		wk.setTeacher(teachers);
		students.add(wk);
		schoole.setStudents(students);
		return schoole;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
