package cn.sky.test.webservice.impl;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import cn.sky.test.webservice.Location;
import cn.sky.test.webservice.client.entity.City;

public class LocationImpl implements Location {

	public City city() {
		return City.getCity();
	}

	public static void main(String args[]) {
		Location location = new LocationImpl();
		// Service instance
		JAXRSServerFactoryBean restServer = new JAXRSServerFactoryBean();
		restServer.setServiceBean(location);
		restServer.setAddress("http://localhost:9999/");
		restServer.create();
	}
}
