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
                sh 'mvn clean install'
            }
        }
        
        stage('Test') {
            steps {
                // Run tests using Maven
                sh 'mvn test'
            }
        }
        
        stage('Package') {
            steps {
                // Create executable JAR or WAR
                sh 'mvn package'
            }
        }
        
        stage('Deploy') {
            steps {
                // Example: Deploy to an application server (Tomcat)
                sh 'cp target/your-app.war/path/to/tomcat/webapps/'

                // Example: Restart the application server
                sh '/path/to/tomcat/bin/shutdown.sh'
                sh '/path/to/tomcat/bin/startup.sh'
            }
        }
    }
