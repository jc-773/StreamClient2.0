SportRadar has a hyperlink to a downloadable stream library that consumes some hot publisher (found here: https://developer.sportradar.com/football/reference/ufl-push-feeds)

I recreated it in fewer lines of code using the Project Reactor framework

Noticable differences:
	1. No blocking calls
	2. Completely reactive using a Flux from Project Reactor
	3. Error handling
