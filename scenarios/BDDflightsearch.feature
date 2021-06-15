Feature: Validation Flight Search Scenarios 

Scenario Outline: User want to Search flights with origin city, destination city, departure date and return dates, use can select nth result on result page 

Given User navigate to Kayak flight page
When User enters origin "<origin>" and nearby "<origin_airport>" city
When User enters destination "<destination>" and nearby "<destination_airport>" city
When User departure "<departure_date>" date and return "<return_date>" date
When User click search button
Then User click on nth <nthresult> result on results page

Examples:
    | origin  					| origin_airport |destination   					| destination_airport 	|departure_date   | return_date 	|nthresult  |
    | Bangalore, India 	| 						| Chicago, IL						| 						|5/20/2021 				|7/30/2021 			|3 					|
    | Bangalore, India 	| 						| New York, NY					| 						|5/20/2021 				|7/30/2021 			|2 					|
    | New York, NY			| 			| Chicago, IL						| 									|7/20/2021 				|11/30/2021 		|4 					|
		| Chicago, IL 			| 						| Bangalore, India			| 									|5/20/2021 				|8/30/2021 			|8 					|
    
    
    
Scenario Outline: User want to Search flights with origin city, destination city, departure date and return dates

Given User navigate to Kayak flight page
When User enters origin "<origin>" and nearby "<origin_airport>" city
When User enters destination "<destination>" and nearby "<destination_airport>" city
When User departure "<departure_date>" date and return "<return_date>" date
When User click search button
Then User click on nth <nthresult> result on results page

Examples:
    | origin  					| origin_airport |destination   					| destination_airport 	|departure_date   | return_date 	|nthresult  |
    | Bangalore, India 	| 						| Bangalore, India			| 						|5/20/2021 				|7/30/2021 			|4 					|

    
    