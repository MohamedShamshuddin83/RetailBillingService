# RetailBillingService
Retail Billing Service for a Web Portal
------------------------------------------------------------------------------------

This Serivce is SprintBoot based RESTful Microservice which deals with generating the Billing Invoice based on the different
types of User/Customer.

As given in the problem statement, the User can be an Employee, an Affiliate to store or can be a Customer over a period of time and hence based on them the discount percentage is calculated. 

So, this MicroService takes care of generating the invoice based on the different types of users and their shopped products and generates a final bill amount to be paid.

Service details and Executing it:
---------------------------------

As mentioned, this is RESTful Microservice which exposes a POST endpoint and consumes/takes shopping and customer details to generate the bill.

Note:This service is Gradle based project and require gradle version >= 4.8  before running it.

Running it:
-----------
1. Download the git repo by clonning it : https://github.com/MohamedShamshuddin83/RetailBillingService.git

2. GoTo project folder and run command -> gradle build

    a. This will download all the dependencies, executes the JUnit Test cases 
    and generates a jar file under <ProjectFolder>\build\libs

3. GoTo the libs folder and run command -> java -jar RetailBillingService-0.0.1-SNAPSHOT.jar

4. Use any REST client for Eg: Postman for calling the rest endpoint as below:
   
   Endpoint : http://localhost:9090/billing/generateBillingInvoice
   
   a. As this is POST endpoint, it expects body as raw and content type as JSON(application/json)
      
      Body: 
        
        {
          "cartId": 1,
          "customerId": 4,
          "products": [
            {
              "productId": 1,
              "productName": "Television",
              "quantity": 1,
              "productType": "ELECTRONICS",
              "unitPrice": "50000.0"
            },
            {
              "productId": 2,
              "productName": "Laptop",
              "quantity": 1,
              "productType": "ELECTRONICS",
              "unitPrice": "50000.0"
            }
          ]
        }
            
     b. Hit send button and you will get the BillInvoice for the above shopping details.




