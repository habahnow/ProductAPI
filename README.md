# ProductAPI

### Purpose

This practice project would allow users to add products(miniPCs) and their characteristics to a 
database through a csv file, and allow users to edit and view the products that are added. Users 
would be able to view the products through a an html interface on a web browser . This should 
help facilitate managing the pricing of several products, while also providing users the ability 
to view a filtered list of products. 

### Installation

The tools you need are: 
Java 1.8 (or higher)
IntelliJ (with Maven installed)
MySQL 
Spring Boot 
git



#### To install MySQL, start up MySQL Server, create a User and set up a Database
Download the installer from:
https://dev.mysql.com/downloads/installer/

Only MySQL server is required under the setup type and ensure to remember or write down the root password, 
as well as the admin credentials.

After downloading MySQL Server, start MySQL server (there's a software that appears in the task bar 
that allows you to start it easily).

If that software is not installed for some reason, go to the services window in Windows
Look up MySQL on the list and right click on it and select start. 

Open up the command prompt and login to MySQL using the command
```-u root -p```
Enter the root password that was used when MySQL was downloaded. 

To create a user use the command:
```create user 'developer1'@'localhost' identified by 'password';```

Create a database using: 
```create database icop_pricing;```

Grant the correct permissions to the user "developer1":
```grant create, drop, delete, insert, select, update on icop_pricing.* to 'developer1'@'localhost';```

Clone the project through git. 

Intellij will ask whether you want it to download the maven build files after cloning the repository. 
Select yes

Project should be ready to run. 
Run ProductionPricingApplication.java

To view the index page for the MiniPCs, go to 
```http://localhost:8080/minipc/```
On your machine's web browser

License: GNU General Public License
