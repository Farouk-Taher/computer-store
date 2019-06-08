# Computer Store

This prject made for IN3 company as a step of the hiring proccess

# To build this project & Run it: 

1- Please run maven clean install command
2- Please run npm install command inside the webapp folder you can find it in this path ~src\main\resources\webapp
3- Run the Server application -Spring application- either with command or with ide it will run on port 8080 -defualt-
4- Run the webapp application -Angular 7 application- using command "ng serve --o" it will run on port 4200 -defualt-


# What This App do? 

1- In the home page you will find all the computers in the store
2- To search for a specific PC please press on the link on your write hand it will take you to the search page
3- You must enter at least one value in the search query, and your search results will appear on the right in the table.

# How it works in deep? 

1- Spring boot application reads CSV file from the resources folder and insert it in the H2 database.
2- Server expose some APIs: - /getProducts : this API returns all computers paginated 
							- /getSearchCriteria: this API returns all values needed to fill a search query	
							- /getSearchResult: this API returns all results from the search
							
3- CORS handeled for localhost only -for testing- -i could add WebConfigurationSecurity but i didn't need it-
4- The angular application is using angular router to route between components.
5- The Angular application have 3 main page, the home page "/store" that view all the computers,
	"/search" page that helps you finding your computer faster and easier,
	also a defualt page to handle bad routes.

# Some Libraries Used:

- Jest, ng-select, bootstrap
- Hibernate, JPA

# Pros and Cons

- Pros: 

1- You will find the code will structred and self documented.
2- This application is maintainable, editable, scalable and reusable.
3- The Java code considered serialization.
4- The application considered big amount of data cases.

- Cons:

Cons are quite a lot becuase nothing is perfect and time is relative :D

1- Bad UI becuase i'm not an UI expert to be honest
2- Could be a lot more test cases but i didn't had time.
3- I didn't create DockerFile or build a Docker image becuase the time.
4- I docmented the function in the server but not the angular application, both should be documented.
5- Logs are very important i should add it.
6- Exception handling could be better.