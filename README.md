# DEMO Test Automation Project

This project demonstrates automated testing for various components using the following technologies:

- **UI Testing:** [OrangeHRM](https://opensource-demo.orangehrmlive.com/)
- **API Testing:** [GoRest API](https://gorest.co.in/public/v2/users)
- **Database:** MySQL with a schema created

## Technologies Used

- IntelliJ Idea
- Java
- Selenium Webdriver
- Behavior-driven development (BDD)
- Maven
- JUnit
- Cucumber
- TestNG
- Page Object Model (POM)
- MySQL
- Rest Assured
- Log4j
- Extent Report
- GitHub

## Environment

- MacOS

## UI Testing Description

This suite includes Gherkin acceptance tests covering login, employee operations, and navigation. The project structure comprises feature files, a POM with locators, a Runner class, Step Definitions, and a Base Driver class with integrated reporting for a comprehensive evaluation of the application's UI features.

## API Testing Description

The API testing suite covers positive and negative scenarios for creating, updating, retrieving, and deleting users. It enhances the reliability and functionality of the API. Follow the provided testing order in the script to understand and validate the API's behavior.

## Database JDBC Testing Description

This JDBC testing suite verifies the "Customers" table in the "classicmodels" schema. The tests cover aspects such as checking the table's existence, validating naming conventions, verifying the number and types of columns, and assessing null constraints, ensuring a thorough examination of the database schema.

## **HOW TO START**

### Prerequisites

1. **Java Development Kit (JDK):**
   - Install JDK 8 or later. Download it [here](https://www.oracle.com/java/technologies/javase-downloads.html).

2. **MySQL Database:**
   - Download and install MySQL. Download MySQL Community Server [here](https://dev.mysql.com/downloads/mysql/).
   - During the installation, set a password for the MySQL root user.

### Installation

1. **Clone the Repository:**
   - Clone this repository to your local machine.

2. **Database Configuration:**
   - Open MySQL Workbench or any MySQL client of your choice.
   - Create a new database named `your_database_name`.
   - **Import Database Dump:**
      - Find the `database_dump.sql` file in the project: `DB/database_dump.sql`
      - Import this file into the `your_database_name` database using your MySQL client.
   - **Database Configuration:**
      - Open the `src/test/java/Utilities/JDBC_Utilities.java` file.
      - Modify the following properties with your database connection details:
        ```java
        String url = "jdbc:mysql://your_database_url:your_port/your_database_name";
        String username = "your_username";
        String password = "your_password";
        ```

3. **Build the Project:**
   - Open your project in your preferred Java IDE (IntelliJ IDEA, Eclipse).
   - Build the project using the IDE's build functionality.

### Usage

1. **Run the Application:**
   - Run the Runner Class for UI and DataBase Testing and XML file for API Testing.
