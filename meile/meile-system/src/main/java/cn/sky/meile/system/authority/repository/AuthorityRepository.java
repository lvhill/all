package cn.sky.meile.system.authority.repository;

import cn.sky.meile.system.authority.entity.SystemMember;

public interface AuthorityRepository {

	/***
	 * 通过用户名查询用户
	 * 
	 * @return user
	 */
	public SystemMember getMemberByName(String name);
}
