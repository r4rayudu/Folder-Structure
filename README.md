<h1>Recursive	File Structure</h1>

  - To run the program on any computer JDK need to be installed and to save the data MySQL should be installed change application.proporties to configure remote database.
  - Read a file structure from text file and to stored in MySQL.
  - It's just a war file that can be executed and configured using the java command.
  - Follow each step to build from scratch, or skip to the end get the source for this article.

<h2>Prerequisites</h2>

  - To run the project using command line arguments below software is required
    - JDK
    - MySQL

  - To run the project in Eclipse need below software.
    - Java
    - MySQL
    - Maven

<h2>Steps to Run</h2>

  - To run using command line arguments
    - Download the war file i.e. java_project_ds-0.0.1-SNAPSHOT.war and text file i.e testfile.txt. 

  - Run the below command in cmd or terminal. Please provide text to store file structure in database.
    - `java -jar java_project_ds-0.0.1-SNAPSHOT.war`
    OR
    - `mvn clean package`
    - `mvn spring-boot:run`
    
 <h2>URL</h2>
 http://localhost:8080/findPathPage
