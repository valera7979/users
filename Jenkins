pipeline {
    agent any

    tools {
        gradle 'Gradle'
        jdk 'Java'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
      
                bat 'gradle clean build'
            }
        }

        stage('Test') {
            steps {
                
                bat 'gradle test'
                junit 'build/test-results/test/*.xml'
            }
        }

        stage('Code Coverage') {
            steps {
               
                bat 'gradle jacocoTestReport'
                
                archiveArtifacts 'build/reports/jacoco/test/html/*'
            }
        }
    }

    post {
        always {
           
            junit 'build/test-results/test/*.xml'
            
            jacoco(execPattern: 'build/jacoco/test.exec', classPattern: '**/*.class', sourcePattern: 'src/main/java', minimumInstructionCoverage: 0, minimumBranchCoverage: 0, minimumComplexityCoverage: 0, minimumLineCoverage: 80, minimumMethodCoverage: 0, minimumClassCoverage: 0)
        }
    }
}
