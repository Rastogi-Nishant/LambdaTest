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
            steps {
                // You can add deployment steps here, e.g., deploying to a server
            }
        }
    }

    post {
        always {
            // Archive the generated artifacts, e.g., JAR files
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
        }
    }
}
