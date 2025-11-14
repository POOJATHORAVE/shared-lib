@Library('my-shared-library') _

pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                buildStep("Compiling the application")
            }
        }

        stage('Test') {
            steps {
                testStep("Executing unit tests")
            }
        }

        stage('Deploy') {
            steps {
                deployStep("production")
            }
        }
    }
}
