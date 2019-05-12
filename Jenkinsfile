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
                               sh "cd consumerA && ./gradlew pactPublish --stacktrace"
                            }
                    }

              stage('Check Pact Verifications') {
                  steps {
                    sh 'curl -LO https://github.com/pact-foundation/pact-ruby-standalone/releases/download/v1.61.1/pact-1.61.1-linux-x86_64.tar.gz'
                    sh 'tar xzf pact-1.61.1-linux-x86_64.tar.gz'
                    dir('pact/bin') {
                      sh "./pact-broker can-i-deploy --retry-while-unknown=12 --retry-interval=10 -a consumera -b http://pactbroker -e add_width"
                    }
                  }
                }
    }
}