stage('Git Flow: Checkout') {
    steps {
        sh 'git checkout main'
        sh 'git pull origin main'
    }
}

stage('Git Flow: Build and Test') {
    steps {
        sh 'mvn clean install'
        sh 'mvn test'
    }
}
