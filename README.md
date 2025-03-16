This application is a rewrite of SportsRadar's StreamClient for their reactive based push service. Simply call the stream(String url) method from the StreamingClient class with the stream feed enpoint as a parameter. 


Noticable differences:
	1. No blocking calls
	2. Completely reactive using a Flux from Project Reactor
	3. Error handling
