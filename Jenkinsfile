pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout your source code from version control (e.g., Git)
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Use Maven to build your Java project
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Run tests using Maven
                sh 'mvn test'
            }
        }

        stage('Deploy') {
           
        }
    }

    post {
        always {
            // Archive the generated artifacts, e.g., JAR files
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
        }
    }
}
