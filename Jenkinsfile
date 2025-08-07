pipeline {
    agent any
    
    tools {
        jdk 'jdk-17'
        maven 'maven'
        sonarscanner 'SonarScanner'
    }
    
    environment {
        APP_NAME = "sua-api-spring-boot"
        SONAR_PROJECT_KEY = "algafood-api"
        SONAR_PROJECT_NAME = "AlgaFood API"
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/doodohrafael/algafood-api.git'
            }
        }
        
        stage('Build') {
            steps {
                sh 'chmod +x ./mvnw'
                sh './mvnw clean package'
            }
        }
        
        stage('Test') {
            steps {
                sh './mvnw test'
            }
            
            post {
                always {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') { // 'SonarQube' deve bater com o nome configurado no Jenkins
                    sh '''
                    ./mvnw sonar:sonar \
                      -Dsonar.projectKey=${SONAR_PROJECT_KEY} \
                      -Dsonar.projectName="${SONAR_PROJECT_NAME}" \
                      -Dsonar.java.binaries=target/classes \
                      -Dsonar.junit.reportPaths=target/surefire-reports
                    '''
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true // Falha o pipeline se a qualidade não passar
                }
            }
        }
        
        stage('Deploy') {
            when {
                branch 'main'
            }
            steps {
                echo 'Deploy realizado com sucesso'
            }
        }
    }
    
    post {
        always {
            echo 'Pipeline concluída'
        }
        success {
            echo 'Build e testes executados com sucesso!'
        }
        failure {
            echo 'Ocorreu um erro na pipeline'
        }
    }
}