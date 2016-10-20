# IS2545_DELIVERABLE_3

##Introduction

Three user stories have been realized in three different java files. Every user story tests one functionality. Three java files, LoginTest,java, SeachTest.java and CartTest.java are created to test three different storeis, which can be seen in edu.pitt.test pakcage.


Since the first story comes into my mind is about testing the problem of login, and when I test it, it's my first time to write code relevant to selenium. High frequent test for logining makes my IP blocked.

NOTICE: The version of selenium java I used is below 3.0, which seems that less code should be written: No code like "System.setProperty("webdriver.gecko.driver", "libs\\geckodriver.exe")" should be written.

## Stories and Scenarios

### Story 1 
As a user    
I want to log in    
So that I can buy items online    

#### Scenario -1     
Given I am in the login in page, that is http://store.demoqa.com/products-page/your-account/,       
And I have successfully registered with username qic921015, password 123     
When I login in without inputting username and password        
Then I should receive an error message         
    
#### Scenario -2
Given I am in the login in page, that is http://store.demoqa.com/products-page/your-account/,     
And I have successfully registered with username qic921015, password 123    
When I login in with incorrect username and correct password          
Then I should receive an error message    
    
#### Scenario -3    
Given I am in the login in page, that is http://store.demoqa.com/products-page/your-account/,     
And I have successfully registered with username qic921015, password 123    
When I login in with correct username and incorrect password       
Then I should receive an error message.    

### Story 2    
As a user       
I want to search some wanted Items   
So that I can see if I could buy them on this website   
    
#### Scenario – 1    
Give I am in the first page    
And I type “mouse” in the search box     
When I type “enter” in my keyboard    
Then I can see there is only “magic mouse” in the list the system response with.    

#### Scenario – 2    
Give I am in the first page    
And I type some meaningless word, like “ssjdisjdi” in the search box     
When I type “enter” in my keyboard    
Then I can see nothing in the list the system response with.    

#### Scenario – 3    
Give I am in the first page    
And I type “Apple” in the search box     
When I type “enter” in my keyboard    
Then I can see there is many products about “Apple” in the list the system response with.    

### Story 3    
As a user    
I want to check my cart    
So that I can pay or cancel the items I have added into cart    

#### Scenario – 1    
Give I am in the page where I can checkout, and I have added a “mouse” into my cart    
When I type “remove” button     
Then the cart should be empty.    

#### Scenario – 2    
Give I am in the page where I can checkout, and I have added a “mouse” into my cart    
When I type “5” in quantity item textbox and click “update”    
Then the total sub should be $750 ( = $150 * 5)    

#### Scenario – 3    
Give I am in the page where I can checkout, and I have added a “mouse” into my cart    
When I type “-1” in quantity item textbox and click “update”    
Then the cart should be empty or I can receive an error message.    


