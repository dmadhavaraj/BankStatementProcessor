# BankStatementProcessor
Rabobank Customer Statement Processor

Rabobank receives monthly deliveries of customer statement records. This information is delivered in two formats, CSV and XML. 
These records need to be validated.

# Technologies used:
JAXB - XML processing
  
Apache Commons - CSV processing
  
Apache Velocity - HTML template generation
  
JUnit/Mockito - Unit testing and mocking external objects

# To Run:
This is Maven based project . The pom.xml is available in project root directory.
Import pom.xml in your IDE once you cloned the repo.

Monthly statements to be processed are kept in "statements" directory. 
This path can be configured using config.properties file.
Applcation will generate reports under root directory with name results_[timestamp].html format.

# Open issues:

1.  Few negative unit test cases are yet to be implemented
2.  The report format is yet to be enhanced to show the invalid mutation amount
3.  Yet to define custom exception for few use cases

