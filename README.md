# insurance-boot

### how to execute this project
1. clone this repository
1. import the project into your workspace
1. execute App.java as a Java application
1. make a POST request (I suggest Postman tool for that) to http://localhost:8080
  1. send yoor payload as something like  ``` {
	"itemValue":200,
	"itemType":"BICICLE"
}```
  1. acceptable values for itemType: BICICLE, JEWELRY, ELECTRONICS, SPORTS_EQUIPMENT
1. Check the response with the object containing the insurance value or the HTTP error header if something goes wrong.
