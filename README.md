Demoblaze E-Commerce Automation Project
This repository contains a professional end-to-end automation framework designed for the Demoblaze e-commerce platform. The project demonstrates a robust implementation of the Page Object Model (POM) design pattern, focusing on scalability, maintainability, and clean code principles.

 Tech Stack & Tools
Language: Java 11

Automation Tool: Selenium WebDriver

Test Framework: TestNG

Build Management: Maven

Design Pattern: Page Object Model (POM)

Data Generation: Java Faker

Version Control: Git & GitHub

 Technical Highlights & Framework Architecture
 Page Object Model (POM)

To ensure high maintainability, I separated the UI elements (Locators) from the test logic. Each page (Home, Login, Cart) is represented by its own class, reducing code duplication and making the scripts more readable.

 Test Lifecycle Management

I utilized TestNG annotations to manage the execution flow effectively:

@BeforeMethod: Initializes the WebDriver and sets up the environment before each test case, ensuring a clean state for every execution.

@AfterMethod: Ensures the browser is closed securely after each test execution to optimize system resources and prevent memory leaks.

 Dynamic Wait Strategies

Instead of using brittle static waits (Thread.sleep), I implemented Explicit Waits (WebDriverWait). Bu approach makes the automation suite more stable by handling asynchronous page loads and dynamic elements effectively.

 Data-Driven Approach with Java Faker

To simulate real-world scenarios, I integrated the Java Faker library. This allows the framework to generate unique user data (names, emails, addresses) for every registration test, preventing "already registered" errors and ensuring dynamic test coverage.

📂 Project Structure
Plaintext
src
 ├── main/java
 │    └── pages        # Page classes with @FindBy locators and page-specific methods
 ├── test/java
 │    └── tests        # Test scripts containing the actual test scenarios
 └── resources         # Configuration files and drivers
pom.xml                # Project dependencies and configurations

Clone the repository:

Bash
git clone https://github.com/Beyzakaragulle/DemoblazeAutomationProject.git
Open with IntelliJ IDEA (or any Java IDE).

Reload Maven Project to download all dependencies.

Run tests by right-clicking the test class or using the testng.xml file.
