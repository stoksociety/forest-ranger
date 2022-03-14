hi, Stoksociety here

this is an application for identitying endagered animals and also knowing who identified the animal. That's where the ranger will input his/her name

Demo key

the live link is not availble yet because of technical issues

to see the code you can fork my project or clone it using the link given
https://github.com/stoksociety/forest-ranger.git


Then run gradle build to download the needed dependencies

gradle build
* after everything set up our Postgres Database by :

Create the database called forest-ranger;

Create the two tables
CREATE TABLE animals (id SERIAL  PRIMARY KEY, name VARCHAR, age VARCHAR, health VARCHAR);

CREATE TABLE sightings (id SERIAL  PRIMARY KEY, name VARCHAR, age VARCHAR, health VARCHAR, location VARCHAR, rangerName VARCHAR);
Run the server using the command

gradle run

Technology Used 
Java

Spark

Postgres

HandleBars

thanks, for your time
Stoksociety

adhere to the license rules of 
MIT