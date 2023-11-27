# SpringMVCFilmSite
The purpose of this project's functionality is to exercise all the skills learned using multiple technologies and disciplines learned so far which includes: Java Object Oriented Programming, Connections to MySQL via JDBC, HTML/CSS, Spring Framework with Servlet to JSP functionality. The business solution was implemented using a pseudo business application (a Video Rental Business) the application includes a database layer, Java application layer and the web page presentation layer which is a JSP.  

# Description
At runtime the user can expect that the SpringMVCFilmSite will respond with a home page, greeting the user with a page with heading "Welcome to Diego's Film Site". Here at this web page the user will have the option to fill out one of two forms to obtain movie information for VHS rentals. Form option one allows the user to enter a numeric film number to search by a film's numeric ID as listed in the Film Database. The secondary search option allows the user to search by a search string which searches for both film names and any matching string patterns in the film description. Results get loaded to a .jsp page which lists out fill details of one film or a hyper linked listing of the search results returned. 

# Technologies Used
1) Java version 1.8
2) Object Oriented Programming
3) Mysql-connector-java (JDBC) version 8.0.30
4) Spring Framework version 5.3.22
5) Model View Controller Architecture
6) Tomcat Web Server
7) Java Servlet and .jsp
8) JavaServer Pages Standard Tag Library version 1.2
9) Eclipse Integrated Development Environment

# Lessons Learned
The biggest take away from this exercise was the usage of the Spring framework and how the servlet handler plumbing. The Servlet connects to the controller, the Data Access Object which map to the relevant objects and how these objects get returned to the modelAndView as well as how the corresponding tailored JSP with custom JSTL tags and HTML, how this JSP is added to the modelAndView. And finally how the modelAndView gets resolved to the servlet handler and displayed to the client browser.  