Start with:
```
mvn archetype:generate -DarchetypeGroupId=org.apache.tomcat.maven -DarchetypeArtifactId=tomcat-maven-archetype -DarchetypeVersion=2.0-beta-1
```
Download chromedriver from https://sites.google.com/a/chromium.org/chromedriver/downloads
Extract it into /usr/local/bin
Update basic-webapp-it/src/test/java/ort/apache/tomcat/maven/webapp/test/SimpleTest.java
Edit chromedriver path

Update basic-webapp-it/pom.xml
Change selenium-remote-driver into selenium-chrome-driver.