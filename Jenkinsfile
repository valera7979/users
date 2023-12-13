pipeline {
    agent any
    tools {
        gradle 'Gradle-7.5'
    }
    stages {

        stage('Clean') {
            steps {
                dir("${env.WORKSPACE}"){
                    echo "Cleaning the workspace..."

                    bat 'gradle clean'
                }
            }
        }

        stage('Build') {
            steps {
                dir("${env.WORKSPACE}"){
                    echo "Creating the JAR file..."

                    bat 'gradle build -x test'
                }
            }
        }

        stage('Test') {
            steps {
                dir("${env.WORKSPACE}"){
                    echo "Running tests..."

                    bat 'gradle test'
                    junit '**/*.xml'
                }
            }
        }




    }
    post {
        always {
            echo "Collecting jUnit test results..."
            // Add jUnit report collection here...
            junit allowEmptyResults: true, testResults: 'build/test-results/test/*.xml'


            echo "Archiving the JAR file..."

            archiveArtifacts allowEmptyArchive: true,
            artifacts: 'build/libs/user-manager.jar',
            fingerprint: true,
            followSymlinks: false, onlyIfSuccessful: true
        }
    }
}
