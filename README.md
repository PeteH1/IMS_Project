
<h1>IMS Project</h1>

<h3>Welcome to my Inventory Management System (IMS) Project.</h3>
This project is a culmination of things that I've learned over the previous weeks/months including: Java, Git, Jira, SQL & MySQL, Maven, JUnit & Mockito.

You can view the Jira board that was used to manage this project here: https://petehutchison.atlassian.net/jira/software/projects/IP/boards/2

## How to use

You can run and test this application from within [Eclipse](https://www.eclipse.org/downloads/packages/) by importing the project as an existing Maven project. You can right click on the project within Eclipse's package explorer and select "Run As" -> "Java Application". You can also run the tests by right clicking on the project and selecting "Coverage As" -> "JUnit Test".

You will need to have [MySQL](https://www.mysql.com/downloads/) installed, and the schema needed for the application to function correctly can be found in src/main/resources.

You can also run the application from the command line if you have [Java](https://www.oracle.com/java/technologies/downloads/) installed correctly with the correct path variables added. To do this on windows, open a command prompt within the project and enter "java -jar ims-0.0.1-jar-with-dependencies.jar".

You can run all the tests in a similar way by entering "mvn test" instead.
