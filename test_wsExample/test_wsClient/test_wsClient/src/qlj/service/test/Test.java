package qlj.service.test;
import qlj.service.impl.ServiceImpl;
import qlj.service.impl.ServiceImplService;
public class Test {
	public static void main(String[] args) {
		ServiceImpl serviceImpl = new ServiceImplService().getServiceImplPort();
		System.out.println(serviceImpl.testHello(" Po1"));
	}

}
