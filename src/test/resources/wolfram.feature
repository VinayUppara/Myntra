Feature: Searching about a person or any other thing you're interested

Scenario Outline: Search about anything in WolframeAplha

		  Given URL of WolframeAlpha
		  
		  When  user logged in as "<USERNAME>" with "<PASSWORD>"
		  And 	login is succesfull
		  And user searchs for a "<TOPIC>"
		  
		  
		  Then Results are displayed in creative way
  
 Examples: 
 		|USERNAME|PASSWORD|TOPIC|
 		|user	 |password|IDOL |