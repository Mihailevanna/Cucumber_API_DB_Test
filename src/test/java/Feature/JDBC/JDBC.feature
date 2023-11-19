Feature: Table Customers.

  Scenario: Check Table presence in classicmodels schema
    Given Send "show tables;" as a query
    And Check data If its in Database
      | customers |

  Scenario: Check table name conventions
    Given Send "show tables;" as a query
    And Check that there are no spaces in table names

  Scenario: Check number of columns in Customers
    Given Send " select count(*) COLUMN_NAME from information_schema.columns where table_name='customers';" as a query
    And Check data If its in Database
      | 13 |

  Scenario: Check column names in Customers
    Given Send "select column_name from information_schema.columns where table_name='customers';" as a query
    And Check data If its in Database
      | addressLine1           |
      | addressLine2           |
      | city                   |
      | contactFirstName       |
      | contactLastName        |
      | country                |
      | creditLimit            |
      | customerName           |
      | customerNumber         |
      | phone                  |
      | postalCode             |
      | salesRepEmployeeNumber |
      | state                  |

  Scenario: Check data type of columns in Customers
    Given Send "select column_name,data_type from information_schema.columns where table_name='customers';" as a query
    And Check information on column
      | addressLine1           | varchar |
      | addressLine2           | varchar |
      | city                   | varchar |
      | contactFirstName       | varchar |
      | contactLastName        | varchar |
      | country                | varchar |
      | creditLimit            | decimal |
      | customerName           | varchar |
      | customerNumber         | int     |
      | phone                  | varchar |
      | postalCode             | varchar |
      | salesRepEmployeeNumber | int     |
      | state                  | varchar |

  Scenario: Check column type of columns in Customers
    Given Send "select column_name, column_type from information_schema.columns where table_name='customers';" as a query
    And Check information on column
      | addressLine1           | varchar(50)   |
      | addressLine2           | varchar(50)   |
      | city                   | varchar(50)   |
      | contactFirstName       | varchar(50)   |
      | contactLastName        | varchar(50)   |
      | country                | varchar(50)   |
      | creditLimit            | decimal(10,2) |
      | customerName           | varchar(50)   |
      | customerNumber         | int           |
      | phone                  | varchar(50)   |
      | postalCode             | varchar(15)   |
      | salesRepEmployeeNumber | int           |
      | state                  | varchar(50)   |


  Scenario: Check null field in Customers
    Given Send "select column_name, is_nullable from information_schema.columns where table_name='customers';" as a query
    And Check information on column
      | addressLine1           | NO  |
      | addressLine2           | YES |
      | city                   | NO  |
      | contactFirstName       | NO  |
      | contactLastName        | NO  |
      | country                | NO  |
      | creditLimit            | YES |
      | customerName           | NO  |
      | customerNumber         | NO  |
      | phone                  | NO  |
      | postalCode             | YES |
      | salesRepEmployeeNumber | YES |
      | state                  | YES |


