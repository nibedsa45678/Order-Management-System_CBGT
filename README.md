CONTENTS:
----------
Set Up
Starting the Service Registry
Starting the Order Item Microservice Application
Starting the Order Microservice Application
Available REST API End Points in the application
Using the application
Design

SETUP
-------
This project is available in GitHub in the link below:

https://github.com/nibedsa45678/OrderManagementSystem_CBGT
Download the project -ServiceRegistry
Download the project -OrderItemService
Download the project -OrderService
Import the projects in eclipse and build all the projects and they are ready to be launched.

STARTING THE SERVICE REGISTRY
-------------------------------
ServiceRegistry is the main application which is the Eureka Server and this application has to be launched FIRST as a Spring Boot application on the localhost(Embedded Tomcat Server)

STARTING THE ORDER ITEM SERVICE
---------------------------------
OrderItemSrvice is registered as a Eureka Client with Eureka Server - Gateway Application and this application has to be launched SECOND as a Spring Boot application on the localhost(Embedded Tomcat Server)

STARTING THE ORDER SERVICE
----------------------------
OrderService is registered as a Eureka Client with Eureka Server - Gateway Application and this application has to be launched THIRD as a Spring Boot application on the localhost(Embedded Tomcat Server)

PRE-REQUISITES FOR TESTING API
----------------------------------
First Create the OrderItem and register the unit price for each item through "itemPrice" rest API(developed under OrderService)

AVAILABLE REST API END POINTS IN THE APPLICATION
--------------------------------------------------
Available Endpoints of OrderItem Microservice are:
---------------------------------------------------
/OrderItem/createOrderItem- This endpoint takes the required parameters(orderItemDto bject as request body) and create the orderItem at the begining

/OrderItem/showItems - It shows all Items available if not returns empty.

/OrderItem/showItems/{productCode}This endpoint takes productCode as path variable and returns specific item from the database if available, else returns "Could not find product with code: productCode" message

Available Endpoints of Order Microservice are:
------------------------------------------------
/order/createOrder - This takes orderDto object in Request Body and also internally called the called the (OrderItem service(inter-communication))to check whether product is available or not for which we are placing the order .if product is not available it will return "Could not find product with code: productCode" message.

/order/showAllOrders- This shows all orders information else emty.

/orders//showOrderById/{orderId} - This endpoint takes orderId as path variable and returns specific order from the database if available, else returns "Couldn't find a order with id: orderId" message

/itemPrice/SaveItemPrice- This endpoint takes itemPriceDto object as a requestBody and saves the unit price for each productcode.

USING THE APPLICATION
-----------------------
This is a backend application,so we can use tools like Postman or any Browser[for only get requests] to test this application. Service Registry Application runs on port number :8761 - http://localhost:8761/ Order Item Service Application runs on port number : 8085 - http://localhost:8085/ Order Service Application runs on port number : 8086 - http://localhost:8086/

DESIGN
--------
In this application, Order Service is the consumer of the order items from Order Item Service application. So, Order Service application is made a FeignClient for their communication To develop these applications,we use in memory H2 database and global exception handler is used to handle the Exception.
