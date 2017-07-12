package cn.sky.meile.system.authority.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sky.meile.system.authority.entity.SystemMember;
import cn.sky.meile.system.authority.repository.AuthorityRepository;
import cn.sky.meile.system.authority.service.AuthorityService;
import cn.sky.meile.system.authority.vo.UserVo;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityRepository authorityRepository;

	public boolean login(UserVo user) {
		SystemMember systemMember = authorityRepository.getMemberByName(user.getUsername());
		if (systemMember == null)
			return false;
		if (systemMember.getPassword().equals(user.getPassword()))
			return true;
		return false;
	}

}
