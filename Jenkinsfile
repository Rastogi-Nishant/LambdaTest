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
                // Build the Java project using Maven
                sh 'mvn clean package'
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
                // Example: Deploy to an application server (Tomcat)
                sh 'cp target/your-app.war /path/to/tomcat/webapps/'

                // Example: Restart the application server
                sh '/path/to/tomcat/bin/shutdown.sh'
                sh '/path/to/tomcat/bin/startup.sh'
            }
        }
    }
    
    post {
        always {
            // Archive the generated artifacts (JAR, WAR, etc.)
            archiveArtifacts artifacts: '**/target/*.{jar,war}', allowEmptyArchive: true
        }
        success {
            // Example: Send a success notification
            echo 'Build and deployment successful!'
        }
        failure {
            // Example: Send a failure notification
            emailext (
                to: 'nishantr@lambdatest.com',
                subject: "Failed: ${currentBuild.fullDisplayName}",
                body: "The build ${currentBuild.fullDisplayName} has failed. Check the Jenkins console output for details.",
            )
        }
    }
}
