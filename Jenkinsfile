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
                                    sh "cd consumerA && ./gradlew test --stacktrace"
                                }
                        }
            stage('Publish pacts') {
                                            steps {
                                               sh "cd consumerA && ./gradlew pactPublish"
                                            }
                                    }
    }
}