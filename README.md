# Running the AmazonAutomation Java Selenium Script

To run the Java Selenium script locally, follow these steps:

## Prerequisites

1. **Install Java**: Ensure you have the Java Development Kit (JDK) installed. You can download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase-downloads.html).
2. **Set up Selenium**: Add Selenium Java bindings to your project. You can get them from [Selenium's official website](https://www.selenium.dev/downloads/).
3. **Install ChromeDriver**: Download ChromeDriver from [ChromeDriver's official website](https://sites.google.com/a/chromium.org/chromedriver/downloads) and place it in a known directory.
4. **Configure Build Tool**: If you're using a build tool like Maven or Gradle, include Selenium dependencies in your `pom.xml` or `build.gradle` file.

## Steps

1. **Clone the Repository**:
    
    git clone https://github.com/msuday48/Uday_assiangment.git
    cd your-repo


2. **Open the Project**: Open the project in your preferred Integrated Development Environment (IDE) (e.g., IntelliJ IDEA, Eclipse).

3. **Build the Project**: Build the project to ensure all dependencies are properly configured.

Setting up the Project
1. Install Dependencies
This project uses Maven to manage dependencies. Use the following command to install required dependencies, including Selenium WebDriver:

mvn clean install
Ensure the pom.xml contains the following dependencies for Selenium:

add this Dependencies to pom.xml


4. **Set Up ChromeDriver**: Ensure that ChromeDriver is in your system’s PATH or specify its location in the script. For example:
   
    System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");



5. **Run the Script**: Execute the Selenium script using your IDE eclipse or intellj

To execute the script, follow these steps:

Open the project in an IDE (e.g., IntelliJ IDEA, Eclipse).

Navigate to the AmazonAutomation.java file located in the src/main/java/Automation_task directory.

Right-click on the file and select "Run" to start the automation script. Alternatively, 

To run it via Maven:
mvn test



The script will:

Open a Chrome browser.
Navigate to Amazon India.
Search for "Wrist Watches".
Apply the "Leather" material and "Fastrack" brand filters.
Select a product.
Add the selected product to the cart.
Optionally handle a protection plan popup if it appears.
Verify the item was added to the cart.
