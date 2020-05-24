pipeline {
    agent { label 'master'}

        stages {
 
            stage ('test') {
                steps {
                  dir("build_java"){
                        echo "mvn clean compile test"
                  }
                   
                   
                }
            }

            stage ('Build application') {
                steps {
                    dir("build_java"){

                        sh "mvn -f pom.xml clean install -Dmaven.test.skip=true"
                        sh "tree"
                    }   
                }
            }
  
            stage ('Create docker image') {
                steps {
                 echo "creando docker"
                }

            }
        }
}
