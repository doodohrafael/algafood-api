pipeline {
    agent any
    
    tools {
        jdk 'jdk-17'
        maven 'maven'
    }
    
    environment {
        APP_NAME = "sua-api-spring-boot"
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/doodohrafael/algafood-api.git'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
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