package qlj.service.impl;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;


@WebService
public class ServiceImpl {
	@WebResult(name="helloResult")
	public String testHello(@WebParam(name="name") String name){
		System.out.println("name="+name);
		return "Hello"+name;
	}
}