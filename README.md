# Info      
SportRadar has a hot publisher consumer library found here: https://developer.sportradar.com/football/reference/ufl-push-feeds

This project I created is a cleaner solution using Project Reactor and has fewer lines of code

# Noticable differences   
	1. No blocking calls  
	2. Completely reactive with Flux and Mono support from Project Reactor  
	3. Error handling  

# To use as a lib    
I recently built a very simple workflow on github actions that builds my application on every push to master and publishes the JAR as an artifact. Making it easier for people like you to access my latest code easily. Head over to the actions tab in this repo to get the artifact, then add it as a dependency in your project (i.e. pom file)

~~Fork > Open in IDE > run "mvn clean install" > JAR will be added to your local maven repo > use as a dependency in your other projects (i.e. add to pom file with groupId, artifactId, and version)~~

