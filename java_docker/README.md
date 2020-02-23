# ${artifactId}

MicroService .
========================================

## Definition ##

<-- Set Description -->

## Installation ##
If necesary connect us Firebase, it will be download the project Architecture of github and update the parent in pom this project with the last version of Architecture.

        <parent>
            <groupId>com.globant.inkafarma</groupId>
            <artifactId>inkafarma-parent</artifactId>
            <version>x.x.x</version>
        </parent>

 1.inkafarma/Architecture
 
 Search pom version branch.
 
 Open cmd in \Architecture\inkafarma-parent and execute:
 
	mvn clean install -f ..\Architecture\inkafarma-parent\pom.xml
	
	mvn clean install -f ..\Architecture\inkafarma-util\pom.xml
	
	mvn clean install -f ..\Architecture\inkafarma-firebase\pom.xml
	
	mvn clean install -f ..\Architecture\inkafarma-firebase-canonical\pom.xml
	
	mvn clean install -f ..\Architecture\inkafarma-security\pom.xml
	
	mvn clean install -f ..\Architecture\inkafarma-cors-origin\pom.xml
	
	mvn clean install -f ..\Architecture\inkafarma-health-check\pom.xml 

 2.inkafarma/uS-Configuration
	
	mvn clean install ${artifactId}\pom.xml

## Docker ##

To install docker container in your pc.

Pre requirements:

	* Install Docker in your pc. download from: https://docs.docker.com/docker-for-windows/install/

 	* Install AWSCLI.

	* Login with AWSCLI:

		Open cmd and execute "aws configure"
		you should input AWS Access Key Id, Secret Access Key and Region: us-west-2.
		then execute "aws ecr get-login --region us-west-2 " in console bash

 	* Compile project:

		1. inkafarma/Architecture
		
		2. Open cmd in /${artifactId} and execute:
			mvn clean install
 
Installation:

 	1. Open bash in /${artifactId}/devops and execute: ./install-local.sh