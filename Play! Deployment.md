#Deploying a Java Play! Application
by Jacob Merook
<hr />

**NOTE** credential data and installation location information are located at the bottom of this tutorial. 


This tutorial was created with the use of the Java Play! documentation. 
https://www.playframework.com/documentation/2.4.x/Production
**You will need to follow the **Installing Java Play! and Creating A New Application** **before completing this process.***

This process has been broken down into a 3 step process:
1. Preparation
2.  Installation
3. Building



####**Creating An Application Key - Preparation**
Before a Play! application can be deployed, the application must have an **application secret** configured. This can be done in <code>application.conf</code>. This key will be used to secure cryptography functions. The current password is <code>thisneedstobechanged</code>

There are multiple options to create and store an application secret, but we will use an auto generated method that we can store in <code>application.conf</code>. To auto generate a key open a command window in the projects directory and type the command:
<code>activator playGenerateSecret</code>. This script should compute a key, and display it on the screen. 

####**Installing An Application Key - Preparation**

Assuming the methods above were followed and the application secret was generated via command line, the new application secret can also be **set** using the command line. To do this (after running the command above generating the key) run the command <code>activator playUpdateSecret</code>. This command will update the <code>play.crypto.secret</code>variable in application.conf

####**Packaging A Binary Version of The Application - Preparation**

This step takes all of the code that has been completed on the project and creates a binary version of the project. This step also removes all sbt or activator dependencies from the project so that serves are only required to interact with Java. 

To create this package open a command window in the projects directory and type the command <code>activator dist</code> this automated process will produce a ZIP folder of all JAR files necessary to run the application. The ZIP folder will be located at <code>application_directory_name/target/universal</code>.

####**Delivering and Installing The (Binary) Application - Installation**

Now that the ZIP file has been created, it can then be uploaded to a server and unzipped by opening a command window on the server and running the command <code>unzip the-name-of-my-play-application-1.0.zip</code> 

Once the application has been unzipped there will be a script in <code>the-name-of-my-play-application-1.0/bin</code> folder that has the same name as your application. Execute this script by traveling to the bin folder, and run the command <br />
<code>bash play-java-intro -Dhttp.port=9000 -Dhttp.address=192.168.2.83</code>
This command will install the application on the server, and run the application at 192.168.2.83:9000 


Notes: The information below is related to our specific installation. 

Server: 192.168.2.83
Backup: 192.168.2.84 & GitHub
Database: ussi_mdm_test 
DB username: postgres
DB password: postgres

FTP server creds
host: mdmplus.com
uname: utilitysware
pword: @ir_1snot_fr33


path to backup on 84:
USSI/general/other/*.zip

play installation on 83:
mdm/admin/utilities/ussi_apps/playzip.zip
