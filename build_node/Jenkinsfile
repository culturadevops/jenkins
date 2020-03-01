pipeline {
    agent { label 'master'}

        stages {
            stage ('install') {
                steps {
                    dir("build_node"){
                      sh "npm install"
                    } 
                }
            }
            stage ('test') {
                steps {
                  dir("build_node"){
                        sh "npm test"
                  }
                }
            }
             stage ('guardando artefacto') {
                steps {
                    dir("build_node"){
                     sh 'aws s3 cp --recursive public/ s3://culturadevops/public/ --grants read=uri=http://acs.amazonaws.com/groups/global/AllUsers'
                    }
                }
            }
          stage ('crear sam') {
                steps {

                    sh '/home/linuxbrew/.linuxbrew/bin/sam package   --template-file build_node/template.yml   --output-template-file package.yml   --s3-bucket culturadevops'
                }
            }
            stage ('crear deploy') {
                steps {
                    sh '/home/linuxbrew/.linuxbrew/bin/sam deploy   --template-file package.yml   --stack-name nodejstest  --region us-east-1 --capabilities CAPABILITY_IAM CAPABILITY_NAMED_IAM'
                }
            }
        }
}
