# Computer Store

This prject made for IN3 company as a step of the hiring proccess

# To build this project & Run it: 

1- Please run maven clean install command<br />
2- Please run npm install command inside the webapp folder you can find it in this path ~src\main\resources\webapp<br />
3- Run the Server application -Spring application- either with command or with ide it will run on port 8080 -defualt-<br />
4- Run the webapp application -Angular 7 application- using command "ng serve --o" it will run on port 4200 -defualt-<br />


# What This App do? 

1- In the home page you will find all the computers in the store<br />
2- To search for a specific PC please press on the link on your write hand it will take you to the search page<br />
3- You must enter at least one value in the search query, and your search results will appear on the right in the table.<br />

# How it works in deep? 

1- Spring boot application reads CSV file from the resources folder and insert it in the H2 database.<br />
2- Server expose some APIs: - /getProducts : this API returns all computers paginated <br />
							- /getSearchCriteria: this API returns all values needed to fill a search query	<br />
							- /getSearchResult: this API returns all results from the search<br />
							
3- CORS handeled for localhost only -for testing- -i could add WebConfigurationSecurity but i didn't need it-<br />
4- The angular application is using angular router to route between components.<br />
5- The Angular application have 3 main page, the home page "/store" that view all the computers,<br />
	"/search" page that helps you finding your computer faster and easier,<br />
	also a defualt page to handle bad routes.<br />

# Some Libraries Used:

- Jest, ng-select, bootstrap<br />
- Hibernate, JPA<br />

# Pros and Cons

- Pros: <br />

1- You will find the code will structred and self documented.<br />
2- This application is maintainable, editable, scalable and reusable.<br />
3- The Java code considered serialization.<br />
4- The application considered big amount of data cases.<br />

- Cons:

Cons are quite a lot becuase nothing is perfect and time is relative :D<br />

1- Bad UI becuase i'm not an UI expert to be honest<br />
2- Could be a lot more test cases but i didn't had time.<br />
3- I didn't create DockerFile or build a Docker image becuase the time.<br />
4- I docmented the function in the server but not the angular application, both should be documented.<br />
5- Logs are very important i should add it.<br />
6- Exception handling could be better.<br />
