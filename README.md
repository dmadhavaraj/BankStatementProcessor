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


