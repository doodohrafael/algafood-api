pipeline {
    agent any
    
    tools {
        jdk 'jdk-17'
        maven 'maven'
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
                    withSonarQubeEnv('SonarQube') {
                        sh './mvnw sonar:sonar -Dsonar.host.url=http://sonarqube:9000'
                    }
                }
            }

        stage('Quality Gate') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
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