package cn.sky.meile.system.authority.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "system_member")
public class SystemMember {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GenericGenerator(name = "increment", strategy = "increment")
	@GeneratedValue(generator = "increment")
	private int id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "password", nullable = false)
	private String password;

	/** 权限 */
	@Column(name = "level", nullable = false)
	private int level;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
