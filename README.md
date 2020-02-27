# TodoMVCTestProject

Prerequisites: 
Selenium Webdriver
TestNG 
Eclipse IDE
----------------------------------------------------------------------------------------------------------
Instructions on how to run automated test suite: 

1. Download the Maven project to the local drive
 example: D:\\MavenProject
2.Open the MavenProject in the Eclipse IDE
3.Run the tests located under folder “MavenProject\src\test\java\Tests” as Run as TestNG tests
4.Executed test report can be found at the location \MavenProject\test-output\Suite\Test.html
5.Source code for the tests can be found at \MavenProject\src\test\java\Tests
TodoMvc.java
TodoMvcPage.java
ToDoMvcTests.java

--------------------------------------------------------------------------------------------------------
Answer the following questions:
If you joined a team of six engineers as the only engineer with testing experience and could implement any process you would like, 
how would you ensure that the team delivers high quality software?

1.Plan the testing and QA processes
Test processes should be well planned, defined, and documented. 
Good documentation is the tool that builds efficient communication within the software team. 
So, effective planning entails the creation of the quality and test plans for a project.

2.Test early and Test often with Test Left
a)Involve the dedicated QA team from the beginning to start testing early.
b)Testing should be done by a dedicated team. In this case, QA will be assured that testing is done professionally. 
Making quality improvements must be part of the team members  goals. 
Testers must be involved in the software design process from the start. It helps ensure that they will be able to solve any problems.

3.Implement quality controls from the beginning
     Quality control starts from the beginning, which is an ongoing process throughout the delivery.
     Quality controls like maximum test coverage , daily test report generation etc are in place since the beginning.
     
---------------------------------------------------------------------------------------------------------------------
If you were tasked with writing testing notes for this acceptance criteria (point 1 and 2), what would you write?
According to Given/When/Then,the acceptance criteria would be the following: 

Scenario 1: Add a todo item to the todo list
Given  todo application is opened
When user adds a todo item called ‘Buy Milk” 
Then an item called ’Buy Milk’ is added to todo list
And buttons like All, Completed, Active and  ‘1 item left’ summary is visible in application

Scenario 2 : Remove a todo item from the todo list
Given  todo application is opened 
And “Buy Milk” is added to todo list
When user removes an item called “Buy Milk” 
Then  “Buy Milk” todo item is removed from todo list
And buttons like All, Completed, Active and  ‘1 item left’ summary is removed in application

Scenario 3 : Item marked as completed from todo list 
Given todo application is opened
When the first item “Buy Milk” is marked as completed 
Then item  “Buy Milk” is striked through from todo list 
And button like ‘Clear completed’ and ‘ n item left’ summary is available 

Scenario 4 : Edit an item from todo list
Given todo application is opened
When an item called  “Read the book” is selected and edited as “Buy the new book”
Then an item is edited successfully 
And the Todo is changed to “Buy the new book”

Scenario 5: Show completed from todo list
Given todo application is opened
When ‘Completed’ button is clicked
Then completed items are listed in todo list

------------------------------------------------------------------------------------------------------------------
Optinal deliverables:
1. Tell us what you thought of the test and how long it took you to complete. This will help us improve the test over time!
Ans: The test covers the knowledge area required for writing automation tests.I took around 5 to 6 hours of efforts to think and 
plan writing of test scenarios and automation tests. 

2 Tell us what else you might have done for the test if you had more time.
Ans : If I had more time, I would have written instructions to execute autoamted test cases through command prompt.
Unfortunately I was getting several issues while setting the classpath of my jar files. 




