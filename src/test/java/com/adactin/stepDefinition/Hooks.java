package com.adactin.stepDefinition;

import java.io.IOException;

import com.adactin.baseclass.Base_Class;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;

public class Hooks extends Base_Class {
	
	@Before
	public void beforeHook(Scenario scenario) {
		String name = scenario.getName();
          System.out.println("Scenario Name : "+name);
	}
	@After
	public void afterHook(Scenario scenario) throws Throwable {
		Status status = scenario.getStatus();
        System.out.println("Scenario Status : "+status);
        
        if (scenario.isFailed()) {
			takescreenShot("C:\\Users\\Manimaran\\eclipse-workspace\\Hotel.Adactin\\ScreenShot\\img.png");
		}
	}

}
