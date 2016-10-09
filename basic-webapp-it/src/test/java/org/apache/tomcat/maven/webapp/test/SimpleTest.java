package org.apache.tomcat.maven.webapp.test;
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.TestCase;

public class SimpleTest extends TestCase {

	@Test
	public void testHelloWorld() throws InterruptedException {
		String serverUrl = System.getProperty("serverUrl");
		assertNotNull(serverUrl, "serverUrl was not found");

		WebDriver driver = new ChromeDriver();
		driver.get(serverUrl);
//		driver.get("http://localhost:8080/");

		WebDriverWait wait = new WebDriverWait(driver, 5 );
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("who"))));

		driver.findElement(By.id("who")).sendKeys("Hello World!");
		driver.findElement(By.id("send-btn")).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("response"))));

		assertEquals("Unexpected response", "Hello Hello World!", driver.findElement(By.id("response")).getText());
		driver.quit();
	}
}
