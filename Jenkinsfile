def gitUrl = 'git@github.com:thomastremlett/domhash.git'
def gitBranch = 'main'
def gitCredentialsId = 'githubcreds'


pipeline {
  agent {
    docker {
      image 'maven:latest'
      args '-v /var/run/docker.sock:/var/run/docker.sock'
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
        apt install maven
        sh './mvn clean install -Pprod'
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

