FROM jenkins/jenkins:lts
 #https://updates.jenkins.io/download/plugins/
 #docker build -t jenkins .
 #docker run  -p "80:8080" jenkins
USER root
#si sabes trabajar con los plugin usa el comando siguiente
RUN /usr/local/bin/install-plugins.sh \  
   docker-workflow:1.26
#   dashboard-view:2.9.10 \  
#   pipeline-stage-view:2.4 \  
#   parameterized-trigger:2.32 \  
#   bitbucket:1.1.5 \  
#   git:3.0.5 \  
#   github:1.26.0 \
#   sonarqube-generic-coverage:1.0 \
#   ssh-slaves:1.31.0 \
#   ec2-fleet:1.17.0 \
#   configuration-as-code-groovy:1.1 \
#   pipeline-maven:3.8.2

RUN apt-get update -qq \
    && apt-get install -qqy apt-transport-https ca-certificates curl gnupg2 software-properties-common 
RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -
RUN add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/debian \
   $(lsb_release -cs) \
   stable"
RUN apt-get update  -qq \
    && apt-get install docker-ce=17.12.1~ce-0~debian -y


#RUN apt install maven -y
RUN apt install awscli -y
RUN apt-get install python3-pip -y
RUN pip3 install --upgrade awscli


RUN apt-get install -y gnupg
RUN curl -fsSL https://apt.releases.hashicorp.com/gpg | apt-key add -
RUN apt-add-repository "deb [arch=amd64] https://apt.releases.hashicorp.com $(lsb_release -cs) main"
RUN apt-get update && apt-get install terraform
    
RUN usermod -aG docker jenkins




