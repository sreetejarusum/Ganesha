package com.teja.ddt;

import java.io.IOException;
import java.util.ArrayList;



public class TestPOI {

	public static void main(String[] args) throws IOException {
		
		DataDrivenTestUsingPOI dataDriver=new DataDrivenTestUsingPOI();
		ArrayList res=dataDriver.getTestData("td2","TC's","Checkout");
		
		System.out.println(res.get(0));
		System.out.println(res.get(1));
		System.out.println(res.get(2));
		System.out.println(res.get(3));
		System.out.println(res.get(4));
			
		}

	}


