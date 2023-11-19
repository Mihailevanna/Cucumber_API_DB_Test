# DEMO Test Automation Project

In this project used:
For UI Testing: https://opensource-demo.orangehrmlive.com/
For API Testing:https://gorest.co.in/public/v2/users
For DataBase: Mysql with a schema created

**UI Testing Description:**
This UI testing suite comprises Gherkin acceptance tests covering login, employee operations, and navigation.
The project structure includes feature files, a POM with locators, a Runner class,
Step Definitions, and a Base Driver class with integrated reporting for a comprehensive evaluation of the application's
UI features.

**API Testing Description :**
The tests cover positive and negative scenarios for creating, updating, retrieving, and deleting users.
Enhancing the reliability and functionality of the API. Follow the provided testing order in the script
to understand and validate the API's behavior.

**DataBase JDBC Testing Description:**
This JDBC testing suite verifies the "Customers" table in the "classicmodels" schema.
The tests cover aspects such as checking the table's existence, validating naming conventions,
verifying the number and types of columns, and assessing null constraints,
ensuring a thorough examination of the database schema.

**Technologies used:**
IntelliJ Idea
Java
Selenium Webdriver
Behavior-driven development(BDD)
Maven
JUnit
Cucumber
TestNG
POM
Mysql
Rest Assured
Log4j
Extent Report
GitHub
Jenkins

**Environment :**
MacOS

**HOW TO START**
Follow these steps to set up and run the project on your local machine.

### Prerequisites

1. **Java Development Kit (JDK):**
    - Install JDK 8 or later. You can download
      it [here](https://www.oracle.com/java/technologies/javase-downloads.html).

2. **MySQL Database:**
    - Download and install MySQL. You can download MySQL Community
      Server [here](https://dev.mysql.com/downloads/mysql/).

    - During the installation, set a password for the MySQL root user.

### Installation

1. **Clone the Repository:**
    - Clone this repository to your local machine.

2. **Database Configuration:**
    - Open MySQL Workbench or any MySQL client of your choice.
    - Create a new database named `your_database_name`.
   **Import Database Dump:**
    - Find the `database_dump.sql` file in the project:
      DB/database_dump.sql
    - Import this file into the `your_database_name` database using your MySQL client.
   **Database Configuration:**
    - Open the src/test/java/Utilities/JDBC_Utilities.java file.
    - Modify the following properties with your database connection details:
       String url = "jdbc:mysql://your_database_url:your_port/your_database_name";
       String username = "your_username";
       String password = "your_password";

3. **Build the Project:**
    - Open your project in your preferred Java IDE (IntelliJ IDEA, Eclipse).
    - Build the project using the IDE's build functionality.

### Usage

1. **Run the Application:**
    - Run the Runner Class for UI and DataBase Testing and xml file for API Testing. 




