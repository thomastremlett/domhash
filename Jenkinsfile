def gitUrl = 'git@github.com:thomastremlett/domhash.git'
def gitBranch = 'main'
def gitCredentialsId = 'githubcreds'


pipeline {
  agent {
    docker {
      image 'maven:3.8.4-openjdk-17'
      args '-u root'
      beforeAgent true
      label 'docker'
    }
  }
  stages {

    stage('Checkout Git Repo') {
      steps {
        script {
          git url: gitUrl, branch: gitBranch, credentialsId: gitCredentialsId
        }
      }
    }

    stage('Build Java Microservice') {
      steps {
        sh 'mvn clean installs'
      }
    }

    // stage('TestMicroservice') {
    //   steps {
        // sh './mvnw test'
        // junit '**/target/surefire-reports/*.xml'
    //   }

    stage('Build Docker image') {
      steps {
        sh 'docker build -t domhash .'
        sh "docker tag domhash domhash:${BUILD_NUMBER}"
      }
    }

    stage('Deploy Docker image') {
      steps {
        sh "docker run -d --name domhash -v /var/run/docker.sock:/var/run/docker.sock domhash:${BUILD_NUMBER}"
      }
    }
  
  }
  }

