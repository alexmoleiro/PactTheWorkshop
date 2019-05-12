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
                                    sh "cd consumer A"
                                    sh "./consumerA/gradlew test"
                                }
                        }
            stage('Publish pacts') {
                                            steps {
                                                sh "cd consumer A"
                                                sh "./consumerA/gradlew pactPublish"
                                            }
                                    }
    }
}