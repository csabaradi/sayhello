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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.TestCase;

public class SimpleTest extends TestCase {

  @Test
  public void testHelloWorld() throws InterruptedException {
	  // Optional, if not specified, WebDriver will search your path for chromedriver.
	  System.setProperty("webdriver.chrome.driver", "/home/csabi/.local/bin/chromedriver");

	  WebDriver driver = new ChromeDriver();
	  driver.get("http://localhost:9898/");
	  Thread.sleep(5000);  // Let the user actually see something!
      WebElement who = driver.findElement(By.id("who"));
      who.sendKeys("Hello World!");
      WebElement send = driver.findElement(By.id("send-btn"));
      send.click();

      
	  Thread.sleep(5000);  // Let the user actually see something!
	  WebElement response = driver.findElement(By.id("response"));
	  assertEquals("Hello Hello World!", response.getText());
	  driver.quit();
  }
}
