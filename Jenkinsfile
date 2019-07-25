pipeline {
  agent any
  stages {
    stage('Compile') {
      steps {
        sh 'mvn clean compile'
      }
    }
    stage('Build') {
      steps {
        sh 'mvn clean install'
      }
    }
    stage('Install') {
      steps {
        sh 'mvn clean install'
      }
    }
    stage('Deploy') {
      steps {
        sh '''mvn deploy:deploy-file \\
-Dfile=/var/lib/jenkins/workspace/custom-petclinic_master/petclinic-web/target/petclinic-web-1.1.jar \\
-DrepositoryId=releases \\
-Durl=http://35.224.94.229:8081/repository/custom-petclinic-releases/ \\
-DgroupId=org.ademchenko \\
-DartifactId=custom-petclinic \\
-Dversion=1.1'''
      }
    }
  }
}