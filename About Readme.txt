This is maven based Project Where i have used the TestNG Library to run . Property file has been used as Object Repository and as storing the Test Data

Under src/main/java , there is Package "Keyword". This package contains three classes
   1. Written few methods which has been used in test Script
2. In generic Class , there are metho related to browser activity
2. INvalidTempDiffException : in this class i have defind the user Custom Exception

Under src/test/java , there is package "project_Script". This package contains 3 classes 
1. BaseTest : In this beforeMethod and AfterMehtod is defind
2. Ndtv : this is main test script which fetches the Temperature from NDTV website, Calling the Wether API class Method to fetch the temperature 
3. Weather: In this class we are hitting the Weather API using RestAssured librart and returning the temperature value

testng.xml : this xml contains the which class file need to run.

to run the project just run testng.xml.