@Library('build-tools') _   // the name you register in Jenkins for the shared lib

pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps { checkout scm }    // gets your App.java + Dockerfile
    }
    stage('Build Docker') {
      steps {
        script {
          // build image using shared library step
          buildDocker('myorg/basic-java-app', "${env.BUILD_NUMBER}", [dockerfile: 'Dockerfile', context: '.'])
        }
      }
    }
  }
}
 