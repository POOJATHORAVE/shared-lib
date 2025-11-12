@Library('build-tools') _

pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }

    stage('Build Docker') {
      steps {
        script {
          // Just builds locally — no push
          buildDocker('myorg/basic-java-app', "${env.BUILD_NUMBER}", [dockerfile: 'Dockerfile', context: '.'])
        }
      }
    }
  }
}
 