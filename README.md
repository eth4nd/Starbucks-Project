# CMPE 172 Project Journal

**NOTE: ALL PROJECT FILES IN STARBUCKS-PROJECT FOLDER**

**Journal Entry 1 - 5/1/23:**

Challenges: Setup for project and working with MySQL DB

*Accomplishments/Resolved Issues:*
1. First, here is a screenshot of my Docker
<img width="684" alt="1_Docker" src="https://user-images.githubusercontent.com/32950100/235574909-a1ac43da-5f85-49c9-880d-6f57ac07cc57.png">
As you can see, I am able to have the mysql and spring-starbucks-api running on Docker, however, at the moment I need to run the spring-cashier locally on my terminal for now


2. I was able to log into the cashier’s app and create a new order for a specific store/register
<img width="667" alt="2_RunningSpringCashier" src="https://user-images.githubusercontent.com/32950100/235574919-0cfd461a-abc0-41a2-a5aa-38c491476006.png">
<img width="668" alt="3_LoginIntoSpringCashier" src="https://user-images.githubusercontent.com/32950100/235574920-ad8243aa-38e2-4bb0-924a-48c02c027188.png">
<img width="654" alt="4_PlaceOrderOnSpringCashier" src="https://user-images.githubusercontent.com/32950100/235574922-dc81bd18-d0c8-4f5d-946f-5e3d0a8cb210.png">

3. I was able to query the MySQL DB, to verify and show that the order matches up with what is displayed on the cashier’s app (as shown by the mysql terminal)
<img width="651" alt="5_CheckOrderOnMySQLDB" src="https://user-images.githubusercontent.com/32950100/235574923-52e32965-d2ef-4205-ac7d-954083977f8b.png">

4. I then paid for the order using the Starbucks mobile app, and in the screenshot below, you can see the remaining card balance
<img width="654" alt="6_PayOnStarbucksMobileApp" src="https://user-images.githubusercontent.com/32950100/235574926-97b35566-e03f-4450-93df-58651a2ee912.png">

5. Then, I did a query of the MySQL DB to show the status of both the order and card balance
<img width="659" alt="7_StatusOfOrderAndCardBalance" src="https://user-images.githubusercontent.com/32950100/235574927-42629682-c02b-4f9c-b7d1-e1a116e5de74.png">

Link to Code Commit: https://github.com/nguyensjsu/cmpe172-eth4nd/commit/4cc03929380419f6cbebf12e2793412932e66c51

________________________________________________________________________________________________________________________________________________________________________________________________


**Journal Entry 2 - 5/2/23:**

Challenges: Updating status of cashier page

*Accomplishments/Resolved Issues:*

1. I have now implemented code to allow the spring cashier app to refresh with the updated order status after paying for the order with the Starbucks mobile app
<img width="670" alt="1_UpdatedOrderStatusOnSpringCashier" src="https://user-images.githubusercontent.com/32950100/235764005-3ef17d71-6364-4555-b837-22b8a7163429.png">
In the screenshot above, you can see that when I refresh the order page by clicking the ‘Get Order’ button, the order status becomes updated to ‘paid with card’ to match the order status as shown in the MySQL DB

Link to Code Commit: https://github.com/nguyensjsu/cmpe172-eth4nd/commit/1b637a64f4fd3cc17bc62311e31f584c93e2b5d6

________________________________________________________________________________________________________________________________________________________________________________________________

**Journal Entry 3 - 5/6/23:**

Challenges: Preventing orders from getting saved twice

*Accomplishments/Resolved Issues:*

1. Created kong docker network

2. Ran starbucks API using docker 

<img width="1790" alt="1_StarbucksAPIUsingDocker" src="https://user-images.githubusercontent.com/32950100/236656116-ced9e49c-7346-4550-9dee-d8c309bfeed8.png">

3. Ran kong docker in DB-less mode
<img width="1792" alt="2_DockerrDBLessMode" src="https://user-images.githubusercontent.com/32950100/236656117-8ec8fbea-34c4-436f-b463-7ba46f94a0fb.png">
<img width="1792" alt="3_UpdatedDockerContainers" src="https://user-images.githubusercontent.com/32950100/236656118-2fc963c1-6bd9-4f2a-a281-5d149439ebdd.png">

4. Altered ‘Order.java’, ‘SpringCashierController.java’, and deleted the ‘SpringCashierRepository.java’, so that orders don’t get saved twice, and instead use the API to save the orders just once 
<img width="1792" alt="4_PlaceOrder" src="https://user-images.githubusercontent.com/32950100/236656119-15961432-a7bd-43e0-9205-4499cf783f93.png">
<img width="1792" alt="5_GetOrder" src="https://user-images.githubusercontent.com/32950100/236656120-778137a8-0322-4dcb-87fd-f7121bc13d55.png">
<img width="1792" alt="6_ClearOrder" src="https://user-images.githubusercontent.com/32950100/236656121-19eada13-74a7-4e91-ad1c-08c4604c88db.png">

Also modified the ‘PlaceOrder’, ‘GetOrder’, and ‘ClearOrder’ methods to use the correct ‘resourceURL’ from the kong API 

Link to Code Commit: https://github.com/nguyensjsu/cmpe172-eth4nd/commit/6fc2f93be52f22bec71fd4e95eac012395e4a730

________________________________________________________________________________________________________________________________________________________________________________________________

**Journal Entry 4 - 5/7/23:**

Challenges: Working with Kong and switching between registers to get orders

*Accomplishments/Resolved Issues:*

1. Finished implementing kong API by updated starbucks-client to use the kong API 
<img width="1792" alt="1_ClientApplicationProperties" src="https://user-images.githubusercontent.com/32950100/236696894-fc08de54-cf09-4cb8-bcf9-8c6588943efd.png">
<img width="1792" alt="2_ClientConsoleController" src="https://user-images.githubusercontent.com/32950100/236696898-ae0d4e5c-6471-4246-8cd6-c4051da8c393.png">
<img width="1789" alt="3_Postman" src="https://user-images.githubusercontent.com/32950100/236696899-d4507cea-f624-4a98-abaa-b9398db65651.png">

2. Updated logic in ‘SpringCashierController.java’ so that instead of only obtaining the register information from the first register regardless of what register you choose, now you are able to switch between different registers and place and get orders from them, while using the kong API 
<img width="1792" alt="4_UpdatedSpringCashierController" src="https://user-images.githubusercontent.com/32950100/236696900-7a6c3b03-84ff-4942-8f60-c6e13ad91414.png">
<img width="1792" alt="5_PlaceOrder1" src="https://user-images.githubusercontent.com/32950100/236696902-a197b799-6260-4b7c-8af4-0b0a0dba650c.png">
<img width="1788" alt="6_PlaceOrder2" src="https://user-images.githubusercontent.com/32950100/236696903-9d564fb4-1bb3-495e-b47a-da20ff9c1a59.png">

Link to Code Commit: https://github.com/nguyensjsu/cmpe172-eth4nd/commit/69378701fc3f07a8e777e710f59b04f3bb641baf

________________________________________________________________________________________________________________________________________________________________________________________________

**Journal Entry 5 - 5/13/23:**

Challenges: Issues with place order function

*Accomplishments/Resolved Issues:*

1. Started on initial setup of GKE by creating a ‘starbucks-cashier-worker’
<img width="610" alt="1_GKESetup" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/64ed3fb1-11f9-4f3c-9b9e-40f9be875427">

2. Had to fix my ‘SpringCashierController.java’ since I had issues with my PlaceOrder function, so I fixed it to handle the correct resourceURL, and added a try catch to handle any potential errors that it may throw when the user clicks the button on the page
<img width="631" alt="2_FixedSpringCashierController" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/893cb78f-62f6-4f9f-83e0-fe6b4c4c4e36">

Link to Code Commit: https://github.com/nguyensjsu/cmpe172-eth4nd/commit/e8fd1a9db5baf557bb87ea44fb76c2ea0e9d64e8

________________________________________________________________________________________________________________________________________________________________________________________________

**Journal Entry 6 - 5/14/23:**

Challenges: Implementing feature to choose drink, milk, and size

*Accomplishments/Resolved Issues:*

1. Added the feature so that users are able to specify the type of drink, milk, and size before they place an order
<img width="1792" alt="1_OptionsFeatOrder" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/c8fa025c-6a89-4a32-9083-4afe0a8eb165">
<img width="1792" alt="2_OptionsFeatHTML" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/ad4eee4a-d143-4e92-9e78-0459e302ea72">
<img width="1792" alt="3_OptionsFeatController" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/68631fb9-b6e4-45f8-9d2e-9a73af85f990">
<img width="1792" alt="4_OptionsFeat" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/1f081ea7-ab57-4720-a5c9-648108a12d53">
As you can see in the image above, the user can choose an option for drink, milk, and size now, and it isn’t hard coded in the Order.java file


2. Also updated the ‘PlaceOrder” feature for now so that if more than 1 order is placed at a register then it will say ‘only 1 order per register allowed’
<img width="1792" alt="5_KongFix" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/7c5d865e-a957-49b2-8be7-6f254d59b4e3">

3. Also fixed up kong, so that my code uses the kong api, here is the evidence from Postman 
<img width="1792" alt="6_MoreThan1Order" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/d3d0b40b-64b5-4b7f-9117-bc44defae5bf">

Link to Code Commit: https://github.com/nguyensjsu/cmpe172-eth4nd/commit/035ace050df8524108753d101a802c0f18cc3696

________________________________________________________________________________________________________________________________________________________________________________________________

**Journal Entry 7 - 5/15/23:**

Challenges: Register and Sign out features not working

*Accomplishments/Resolved Issues:*

1. Worked on the ‘templates’ folder by adding html files, and altering existing html files to support features for a user to sign out of the cashier and register their account in addition to logging in. Currently, it is in-progress and still needs some more work done on files for it to be fully functional
<img width="1792" alt="Screenshot 2023-05-15 at 10 36 00 PM" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/474d0fa3-04ea-4884-b1a2-357047aeb151">

Link to Code Commit: https://github.com/nguyensjsu/cmpe172-eth4nd/commit/f3449a5ceee91b28f293230e7e9cde2ce69c22b2

________________________________________________________________________________________________________________________________________________________________________________________________

**Journal Entry 8 - 5/16/23:**

Challenges: Allowing user to sign in with same credentials after signing out 

*Accomplishments/Resolved Issues:*

1. Finished the implementation of the register for user function on the login page 
<img width="1792" alt="1_Register" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/ef8c557e-34fb-41b7-b917-01ebf65a0e20">

Now after the user registers for their account, they can use the same credentials to login to the cashier

2. Also added implementation for a log out button, so that when clicked on, the user will return back to the login page
<img width="1792" alt="2_SignOut" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/d6e8cec3-a4d9-4aa6-8084-2611f2e1f683">

Link to Code Commit: https://github.com/nguyensjsu/cmpe172-eth4nd/commit/ecf7c246f4ab8577a5c7603450c9ab5f59f99d3e

________________________________________________________________________________________________________________________________________________________________________________________________

**Journal Entry 9 - 5/17/23:**

Challenges: Working with RabbitMQ, having troubling getting messages to queue

*Accomplishments/Resolved Issues:*

1. Implemented in progress work for rabbitmq
<img width="1792" alt="1_CodeChangesSpringCashierWorker" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/647f509c-6030-45ff-9aa4-8f98c7573e98">
<img width="1792" alt="2_CodeChangesStarbucksAPI" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/222ce4ae-cfc9-4951-b935-20052847796b">
<img width="1792" alt="3_RabbitMQQueue" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/272dd01d-7d47-43ec-b362-2c12c816120d">

As you can see, I was able to make changes to the spring-cashier-worker and starbucks api folders by adding model and repository classes to manage the payment from cashier, queue, and information in the database. However, this work is still in progress, because my RabbitMQ queues still don’t get populated with the send messages that it is expecting 

Link to Code Commit: https://github.com/nguyensjsu/cmpe172-eth4nd/commit/b5cfd37f90973f94b6f2b79634152f49f91bdee9

________________________________________________________________________________________________________________________________________________________________________________________________


**Journal Entry 10 - 5/18/23:**

Challenges: Getting RabbitMQ fully functional

*Accomplishments/Resolved Issues:*

1. I was able to finalize the implementation for RabbitMQ:

<img width="1792" alt="1_PaidWithCard" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/bc646a1f-058b-4155-aab3-e43d8ffa240d">
As you can see from the screenshot above, I am able to pay for an order

<img width="1792" alt="2_CashierWorkerDocker" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/937dc805-e529-4185-a7cb-d729480b9d95">
Then, from the screenshot above, we can see that the cashier worker is able to receive and process the order, from the cashier worker logs in its docker container

<img width="1792" alt="3_RabbitMQQueue" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/26df0496-39aa-403e-b82f-7d5da074ce10">
Then, we can also see the queue in the RabbitMQ queue from localhost:8080

Link to Code Commit: https://github.com/nguyensjsu/cmpe172-eth4nd/commit/c0bb4440aea428bfd0901537d3622067cd1b0504

________________________________________________________________________________________________________________________________________________________________________________________________

**Journal Entry 11 - 5/19/23:**

Challenges: Allowing html pages to access css files

*Accomplishments/Resolved Issues:*

1. Added css to the login page so it is more aesthetically pleasing
<img width="1792" alt="1_LoginPageCSS" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/94765050-ceee-43e3-b2b9-54cdf3e8ba55">

2. Also added css to the starbucks cashier page so that the sign out button is more centered at the top of the page 
<img width="1792" alt="2_CashierPageCSS" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/c28844f5-9261-41a7-afee-694e7c8ecb24">

Link to Code Commit: https://github.com/nguyensjsu/cmpe172-eth4nd/commit/d554376f228334d182ffa46ae31cb10c78d2c20f

________________________________________________________________________________________________________________________________________________________________________________________________

**Journal Entry 12 - 5/22/23:**

Challenges: No challenges

*Accomplishments/Resolved Issues:* Was able to put final touches on project, deploy everything to GKE, and created kubernetes folder

Link to Code Commits: 
https://github.com/nguyensjsu/cmpe172-eth4nd/commit/c816e6d620199b67087772a1e15954a9350fce3e

https://github.com/nguyensjsu/cmpe172-eth4nd/commit/b6fe8411a379cee94e232beed01e11e5e3935cb7

*Technical Requirements:*

1. Cashier's App 

a. Port Node.js App to Spring MVC (required)

- Web rendering must be done in View Templates
<img width="1792" alt="1 1" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/54723b2b-459b-4137-b086-8a36c5e4c89e">
All of the rendering is done in a templates folder of my spring cashier 
   
- Controller must process JSON responses from API and pass to View via Models
<img width="1792" alt="1 2" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/9dbfa610-a533-43cc-affe-405644e2eab1">
In my ‘SpringCashierController.java’ I use the ‘apiHost’ and ‘apiKey’ variables within my ‘resourceURL’ to process JSON responses from the API and pass it to the View via the Models

- Output and "Look and Feel" of Web UI must match that of Node.js App
<img width="1792" alt="1 3 1" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/902d2af8-5281-4a4f-bb38-0f2bfc3d69dd">
<img width="1792" alt="1 3 2" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/5ce0bb71-0e0b-4ab1-9aaf-bd282e6636e2">
As shown by the UI from the login and cashier pages, they have a look and feel that matches that of a Node.js application 

- Implementation must not just use Rest Client example code (from instructor) as-is
<img width="1792" alt="1 4 1" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/7b2386de-e7b9-4ea7-8e4c-d02eb05cf7c9">
<img width="1792" alt="1 4 2" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/5b318c5a-1114-4476-964e-1ed3e997e868">
<img width="1792" alt="1 4 3" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/7295c407-0a40-4c00-856e-762b4d524879">
In my implementation, I don’t simply use the Rest Client example code from the instructor. I remove the old hashmap that represented the orders, and instead used a list that would find an order and delete an order by register id, using an orders repository 

b. Support Admin Logins for Starbucks Employees 

- Must not store credentials in memory or hard code in source code
<img width="1791" alt="2 1" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/f7e5107f-552b-472e-acbd-47e99ebc7a3c">
In my implementation, I have config and login folders which contain code to process for security and user/admin information (as shown with code snippet from ‘User.java’) which prevents any credentials from being hard coded in source code 

- Should also include New Account Registration and Logout
<img width="1792" alt="2 2 1" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/8b6b227b-1d88-47c4-be8c-a885ea08cd3f">
<img width="1792" alt="2 2 2" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/825164ba-29cc-46f7-9408-261c321c7f74">
From here, you can see the templates for the register and log out buttons on the cashier’s app

- Support In Store Order Processing
<img width="1791" alt="3 1" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/558d2cec-0af3-4040-b390-510987958492">
<img width="1792" alt="3 2" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/de5374fa-45e4-4c1e-b453-941f65782cf2">
<img width="1792" alt="3 3" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/db29da92-1271-41cf-ab1d-3385c2f83b98">
In the above screenshots, we can see that at the Dub-C store, we are able to place an order (caffe latte, whole milk, tall), pay for the order, get the order and show that it has been paid for, and clear the order

<img width="1792" alt="3 4" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/82d73856-522c-4a3d-9f9b-670bdaaa5dc8">
<img width="1792" alt="3 5" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/e6c2e489-27f4-4503-946b-17e94130b26d">
<img width="1792" alt="3 6" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/076f3c3f-1352-4d0e-9061-fed8e1dbfa19">
Similarly, in these above screenshots, we can see that we can also switch stores (in this example we switched to The City), and do the same functions of placing an order (caffe mocha, nonfat milk, grande), paying for the order, getting the order and show that it has been paid for, and clearing the order

2. Scalable Cloud Deployment on GCP

a. External Load Balancer as Ingress for Cashier's App and Internal Load Balancer for Starbucks API behind Kong API Gateway 
<img width="1792" alt="4" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/defc53b8-ce4e-4ef7-a757-1a084eb7b5a0">
The external load balancer as ingress for Cashier’s App is shown by the ‘spring-cashier-ingress’, and the internal load balancer for starbucks api behind kong api gateway is shown by the ‘starbucks-api’

3. Implementation Uses Required Cloud Databases 

a. MySQL Database 8.0 

- Must use Cloud SQL (MySQL Option)
<img width="1792" alt="5" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/fe4f788e-6f26-4f7e-8ea8-4c427beea277">
In the screenshot above we can see that my implementation uses CloudSQL as shown by my ‘starbucks’ instance id in SQL, which represents the ‘starbucks’ database

- Update Starbucks API to use JPA with MySQL
<img width="1792" alt="6" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/9538cea6-dad2-48f8-bd01-a81d5739e344">
We can see that Starbucks API uses JPA with MySQL as shown by the output of ‘SELECT * FROM `SPRING_SESSION`; which shows all of the spring sessions in the ‘starbucks’ database table

b. RabbitMQ 

- Must use GKE RabbitMQ Operator
<img width="1792" alt="7" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/7d17fe6c-f1ce-447f-8354-4b3da5bcdf1e">
I use the GKE RabbitMQ operator as shown by the ‘rabbitmq-console’ and ‘rabbitmq-service’ in the image above and how their status is ‘ok’

- Extend the Starbucks API to support async order processing (to use RabbitMQ)
<img width="1792" alt="8" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/daa323c0-18a8-4121-a324-01c4d448bce8">
Within my starbucks-api code implementation, it supports async order processing by using the highlighted line in the screenshot above, which converts the ‘orderNumber’ and sends it to the queue that is specified

4. Starbucks API for Mobile App and Store Front

a. Deployed with Kong API Gateway with API Key Authentication 
<img width="1792" alt="9 1" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/f14d62a0-5de7-4d63-ac1e-ad48ea8d7133">
In the command to run the starbucks mobile app, it is deployed with the kong api gateway as specified by the ‘Dapiurl’, and the api key authentication is specified by the ‘Dapikey’

b. Implement RabbitMQ Check Order Status for "Drinks Available"

- Async Request API to "Make the Drink" once Order has been Paid (i.e. put request into a Queue)
<img width="1792" alt="9 2 1" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/6e891bcd-e89a-4665-8401-3f043c967489">
Once the order has been paid for, the request is put into the queue as shown by the rabbitmq page, and the status ‘paid’ from the ‘SELECT * FROM `orders`; command in the MySQL DB terminal
<img width="1792" alt="9 2 2" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/b1a291a8-3016-42b1-9a44-ed80cafd878c">
After it waits for a minute, and is done ‘making the drink’, the total the rabbitmq page goes to 0, and the status updates to ‘fulfilled’ from the ‘SELECT * FROM `orders`; command in the MySQL DB terminal

- Async Check Order Status API to "Check Status of Drink" in the Starbucks Database

In the images for the *‘Async Request API to "Make the Drink" once Order has been Paid’* above, we can also see the status of the orders on the left side of the images. Once the order is paid for, its status will start off as ‘paid. Then after it ‘makes the drink’, its status will update to ‘fulfilled’

- Will need a Background Worker Job (i.e. Spring Scheduler) to pick up Orders and Make Drinks / Background Worker should be a "Single Resilient POD" which auto restarts on crashes
<img width="1792" alt="10 1" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/a8fe1e00-c627-426f-a0e1-02e08e4f61cb">
<img width="1791" alt="10 2" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/f0ebbdd4-ec7c-4e93-9e91-dd2cb75c7a11">
The images above show the background worker as shown by the ‘spring-cashier-worker-service’ pod, and its logs show that it is able to receive and process orders that have been paid for

________________________________________________________________________________________________________________________________________________________________________________________________

**(Final) Journal Entry 13 - 5/22/23:**

Challenges: No challenges

*Accomplishments/Resolved Issues:* Added cloud deployment architecture diagram

Link to Code Commits: https://github.com/nguyensjsu/cmpe172-eth4nd/commit/cdb52f577c582f4c80a2434eb8d27c73d8def026

*Overall Architecture Diagram of your Cloud Deployment:*
<img width="1095" alt="Screenshot 2023-05-22 at 9 18 59 PM" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/daadcb74-0102-4b70-9b11-d23abc86c714">

*A section for each of the following discussing the features implemented with Screenshot "Demos" of the Feature:*

1. Cashier's App
<img width="1792" alt="11 1" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/1782a9a9-19c3-48e1-8bd2-6a6f81398696">
<img width="1792" alt="11 2" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/c9ed410b-a425-4554-b503-6f53f7231d26">
<img width="1792" alt="11 3" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/fbc0e52e-f7ec-4436-90da-3f7c4b99bf2c">
As you can see from the screenshots demos of the Cashier’s app above, in my implementation, I am able to select the ‘Dub-C’ store, ‘Caffe Latte’ drink, ‘Whole Milk’ milk type, and ‘Tall’ drink size. Then, I am able to place an order with these specified selections. After paying for the order using the Starbucks Mobile App, I can then get the order to display that the order has been paid for. Lastly, I can then clear the order to remove any orders on the register and update the status of the register to ‘ready for new order’

2. Starbucks REST API
<img width="1792" alt="12" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/5f29e305-5fac-4c35-ada8-a67c7d93c4a6">
As you can see by the image above, we can see that the Starbucks REST API is in use because of its logs within the ‘spring-starbucks-api-deployment’ pod. In the pod’s logs, we can see all of the instances where an order has been placed through the cashier’s app, and paid for using the Starbucks mobile application. It also displays all of its information for the order, and indicates when an order is ‘active’

3. Cloud Deployments

a. Design Notes on GitHub an Architecture Diagram of the overall Deployment
<img width="1792" alt="13 1" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/ccb323b1-5484-4886-bb26-0641fa9f1b83">
<img width="1792" alt="13 2" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/6f9d6e04-dea6-473b-8419-02a5f0ab6bce">
<img width="1792" alt="13 3" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/c78303d1-83cb-41ce-910f-559f6f268e5f">
<img width="1792" alt="13 4" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/7fc8c009-160e-4a98-ac69-7adc58da4280">
<img width="1792" alt="13 5" src="https://github.com/nguyensjsu/cmpe172-eth4nd/assets/32950100/a7949bf8-55f2-4fbb-b570-1b5ef6b7bda4">
For my design, as shown through my architecture diagram of my cloud deployment above, it starts with the google chrome window and accessing the spring cashier ingress at IP 34.110.244.230/*. This ingress then accesses the spring cashier service at port 90, which depends on the spring cashier pod at port 9090. This spring cashier pod ultimately depends on CloudSQL at IP 10.76.112.3. The google chrome window also accesses the RabbitMQ console and service at the same time at ports 6060, and IPs 34.133.42.50 and 10.2.131.146 respectively. These depend on the RabbitMQ pod at port 15672. After a user places an order from the cashier, the user can then pay for the order using the starbucks mobile application, which uses the kong proxy at IP 34.67.88.85, and depends on the starbucks API ingress at port 8080 and IP 34.67.88.85/api. The ingress then accesses the spring starbucks API service at IP 10.2.129.64, and depends on the spring starbucks API pod at port 8080. This spring Starbucks API pod ultimately depends on CloudSQL. After an order is paid for, the spring cashier worker service depends on the spring cashier worker pod which will access the information from CloudSQL. The worker will then depend on the RabbitMQ pod to process the order and mark the order as fulfilled 

b. How does your Solution Scale? Can it handle > 1 Million Mobile Devices? Explain.

The solution is able to scale by incorporating the Google Cloud Platform, which uses both external and internal load balancers to handle multiple instances of the cashier’s app and Starbucks API. My solution also uses CloudSQL for the backend database which handles the users and queries. Next, it also uses RabbitMQ for asynchronous order processing, and Kong API gateway to allow for authentication of the API key. Lastly, it is able to scale by also using the background worker, which process orders after getting them from the queues

Based on these different components, my solution should be able to handle more than 1 million mobile devices because it is able to horizontally scale each component depending on its load. This process would be able to handle numerous devices and should remain the same for user experience no matter the amount of devices 
