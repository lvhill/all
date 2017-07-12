package cn.sky.meile.system.authority.service;

import cn.sky.meile.system.authority.vo.UserVo;

public interface AuthorityService {

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 */
	public boolean login(UserVo user);

}
