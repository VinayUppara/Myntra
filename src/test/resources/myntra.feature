Feature: Shopping a product in Myntra

Scenario Outline: Searching for Mens Top wear in Myntra
	
				Given "<url>" of Myntra
				
				When User logged in with "<username>" and "<password>"
				And Selects a category
				And Search for a "<brand>"
				
				Then Results are displayed
		
				  	
Examples:
		|url|username|password|brand|
		|URL|kumarvinayu@gmail.com|Vinay@123|Tommy Hilfiger|	