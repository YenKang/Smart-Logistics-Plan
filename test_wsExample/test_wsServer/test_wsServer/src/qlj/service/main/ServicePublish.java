package qlj.service.main;

import javax.xml.ws.Endpoint;

import qlj.service.impl.ServiceImpl; 

public class ServicePublish {
	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:9092/test", new ServiceImpl());
	}
}


// C:\Users\yen\Desktop

// wsimport -d C:\Users\yen\Desktop -keep -verbose http://127.0.0.1:9092/test?wsdl