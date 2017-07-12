package cn.sky.meile.system.menu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 后台菜单节点
 * 
 * @author gaofu
 *
 */
@Entity
@Table(name = "system_menu")
public class SystemMenu {

	/*** 菜单id */
	@Id
	@Column(name = "menuid", unique = true, nullable = false)
	@GenericGenerator(name = "assigned", strategy = "assigned")
	@GeneratedValue(generator = "assigned")
	private long menuid;

	/*** 父菜单id */
	@Column(name = "parent_menuid")
	private long parentMenuid;

	/** 名称 */
	@Column(name = "name")
	private String name;

	/** 路径 */
	@Column(name = "url")
	private String url;

	/** 注释 */
	@Column(name = "annotation")
	private String annotation;

	/** 状态:是否开启 */
	@Column(name = "status")
	private int status;

	/** 排序 */
	@Column(name = "order")
	private int order;

	public long getParentMenuid() {
		return parentMenuid;
	}

	public void setParentMenuid(long parentMenuid) {
		this.parentMenuid = parentMenuid;
	}

	public long getMenuid() {
		return menuid;
	}

	public void setMenuid(long menuid) {
		this.menuid = menuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
