stage('Run Tests') {
    steps {
        script {
            // Example: Run tests only if the build was successful
            def testResult = sh script: 'mvn test', returnStatus: true
            if (testResult == 0) {
                sh 'mvn verify'
            } else {
                echo 'Tests failed, skipping further steps.'
            }
        }
    }
}
