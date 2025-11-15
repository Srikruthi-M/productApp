pipeline {
    agent any

    tools {
        jdk 'jdk17'
        maven 'maven3'
    }

    environment {
        DOCKERHUB_REPO = "kruthim/product-app"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/Srikruthi-M/productApp.git'
            }
        }

        stage('Build with Maven') {
            steps {
                bat "mvn clean package -DskipTests=false"
            }
        }


        stage('Build Docker Image') {
            steps {
                bat "docker build -t product-app ."
            }
        }

        stage('Tag & Push to DockerHub') {
            steps {
                bat "docker tag product-app %DOCKERHUB_REPO%:latest"
                bat "docker push %DOCKERHUB_REPO%:latest"
            }
        }
    }

    post {
        success {
            echo "BUILD SUCCESSFUL"
        }
        failure {
            echo "BUILD FAILED"
        }
    }
}
