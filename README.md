# Tracking Number Generator API

#### Description : 
This application will generate the unique tracking number with to accept required parameter and return the json response along with tracking number and created date. 

### Note : 
This api is insecure because of there is no security configuration implemented.
### Application local setup in IDE/run
    1. Minimum Java 17 required to run this application.
    2. Extract zip file then Import any IDE.
    3. Use 'mvn clean install' cmmand to build the project.
    4. Start the application using right click on 'TrackingNumberGeneratorApplication.java'
    5. Application started on port 8080.
    6. Sample Request :-
        curl --location 'localhost:8080/next-tracking-number?origin_country_id=IN&destination_country_id=US&weight=1.987&created_at=2024-12-07T23%3A55%3A07%2B05%3A30&customer_id=56553625weywetwhgs&customer_name=Alex&customer_slug=test%20mesage'


### Run with command line
    1. Extract zip file.
    2. Goto /tracking-number-generator/target path
    3. Run this cmd : java -jar traking-number-generator-0.0.1-SNAPSHOT.jar
    4. Application started on port 8080.

### Sample Request : 
    curl --location 'localhost:8080/next-tracking-number?origin_country_id=IN&destination_country_id=US&weight=1.987&created_at=2024-12-07T23%3A55%3A07%2B05%3A30&customer_id=56553625weywetwhgs&customer_name=Alex&customer_slug=test%20mesage'
### Sample Response : 
    {
    "trackingNumber": "TW87NFCMU3IH7DI3",
    "createdAt": "2024-12-07T23:55:07 05:30"
    }

### H2 DB local connect
    URL : http://localhost:8080/h2-console/login.do?jsessionid=da0f9f7c6aed499919ff4848ff901405
    username: sa
    password: password