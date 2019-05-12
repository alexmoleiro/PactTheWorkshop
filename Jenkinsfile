pipeline {
    agent any
    stages {
            stage('Compile') {
                    steps {
                        sh "./consumerA/gradlew build"
                    }
            }
            stage('Test') {
                                steps {
                                    sh "cd consumerA && ./gradlew test"
                                }
                        }
            stage('Publish pacts') {
                                            steps {
                                                sh "./consumerA/gradlew pactPublish"
                                                sh "./consumerA/gradlew pactPublish"
                                            }
                                    }
    }
}