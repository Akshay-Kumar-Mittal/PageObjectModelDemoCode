Feature: Application Login

	Background:
	Given User is landed on the home page

	Scenario Outline: Login with valid details
	Given User in the Home Page of the Application
	When Clicks on login button
	And Enters valid email <email> and password <password>
	Then User navigates to pricing page
	
	Examples:
	|	email						|	password	|
	|testuser27thapril@gmail.com	|	123456		|
