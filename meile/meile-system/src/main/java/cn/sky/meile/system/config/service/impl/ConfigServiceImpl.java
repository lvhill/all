package cn.sky.meile.system.config.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sky.meile.system.config.repository.ConfigRepository;
import cn.sky.meile.system.config.service.ConfigService;

/**
 * 公共配置
 * 
 * @author gaofu
 * @see CurrentConfig
 *
 */
@Service
public class ConfigServiceImpl implements ConfigService {

	@Autowired
	private ConfigRepository configRepository;

	@Override
	public String queryTheme() {
		return configRepository.queryTheme();
	}

	@Override
	public void updateTheme(String theme) {
		configRepository.updateTheme(theme);
	}

}
