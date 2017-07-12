package cn.sky.meile.mobile.system.config.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 配置
 * 
 * @author gaofu
 *
 */
@Entity
@Table(name = "config")
public class ConfigEntity {
	/** 键 */
	@Id
	@Column(name = "config_key", unique = true, nullable = false)
	@GenericGenerator(name = "assigned", strategy = "assigned")
	@GeneratedValue(generator = "assigned")
	private String key;

	/** 值 */
	@Column(name = "config_value")
	private String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
