package cn.sky.test.service;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisShardPool {

	static ShardedJedisPool pool;
	private static int index = 1;

	static {
		JedisPoolConfig config = new JedisPoolConfig();// Jedis池配置
		config.setMaxTotal(50);
		config.setMaxIdle(300);
		config.setMaxWaitMillis(5000);
		config.setTestOnBorrow(true);
		config.setTestOnReturn(true);
		List<JedisShardInfo> jdsInfoList = new ArrayList<JedisShardInfo>(2);
		//
		String hostA = "localhost";
		int portA = 6379;
		JedisShardInfo infoA = new JedisShardInfo(hostA, portA);
		infoA.setPassword("abcde12345");
		jdsInfoList.add(infoA);
		//
		String hostB = "localhost";
		int portB = 6379;
		JedisShardInfo infoB = new JedisShardInfo(hostB, portB);
		infoB.setPassword("abcde12345");
		jdsInfoList.add(infoB);
		//
		pool = new ShardedJedisPool(config, jdsInfoList);
	}

	public static String generateKey() {
		return String.valueOf(Thread.currentThread().getId()) + "_" + (index++);
	}

	public static ShardedJedis getJedis() {
		return pool.getResource();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			String key = generateKey();
			ShardedJedis jds = null;
			try {
				jds = pool.getResource();
				System.out.println(key + ":" + jds.getShard(key).getClient().getHost());
				System.out.println(jds.set(key, Math.random() + ""));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				jds.close();
			}
		}
	}
}