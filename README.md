Instructions to Run Java Selenium Code
Prerequisites:

Ensure you have Java Development Kit (JDK) installed on your system.

Install an Integrated Development Environment (IDE)  Eclipse.

Download and set up the latest version of Selenium WebDriver.

Install Google Chrome browser and download the corresponding ChromeDriver.

Setup:

Clone or download the project repository from GitHub.

Open the project in your preferred IDE.

Configure Dependencies:

Add Selenium WebDriver dependencies to your project.

If using Maven, add the following dependency in the pom.xml file:

<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.23.1</version>
<dependency>

Download the ChromeDriver executable from ChromeDriver and place it in a suitable directory.

Set Up WebDriver Path:

Set the path to the ChromeDriver executable in your code:

System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
