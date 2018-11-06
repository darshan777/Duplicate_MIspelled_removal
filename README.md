# Validity_Retest 
Darshan Sanghavi(sanghavi.da@husky.neu.edu)
# Application
- Takehome Re-test for Validity.
- The Application is built using Restful Architecture
- Front-End of the application is developed using Angular 6
- Backend of the application is built using Spring Boot
# Explaination
- A data is considered unique if its firstname, email and phone are unique
- A data is considered mispell if the mistake is upto 3 letters
# Application Steps
* In your Browser: localhost:4200
* Select CSV
* 4 buttons
- Noduplicate: data with no exact duplicates
- Nomispelled: data with no exact duplicate and no mispell words
- Duplicate: duplicate data from the datalist
- Mispell: mispelled data from the datalist
 

# Steps to run the Application
# Front-End
- Open the application 
- Go to Validity_Retest_Frontend
- Comands:
```
cd frontend
 npm install
 npm start
```
- The Application wil be Started on port 4200
 # Backend
 - Go to validity_Retest folder
 - Command:
 ```
./mvnw clean install
```
 Application will be started on port 8000
 - For just unit test
 - Command: 
 ```
./mvnw clean test
```
