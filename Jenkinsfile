def gitUrl = 'git@github.com:thomastremlett/domhash.git'
def gitBranch = 'main'
def gitCredentialsId = 'jenkins'

pipeline {
  agent {
    docker {
      image 'thomastremlett/jenkins-build-image:latest'
      args '-u root'
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
        sh 'mvn clean install -f DOMHASH/pom.xml'
      }
    }

    // stage('TestMicroservice') {
    //   // steps {
    //   //   // sh "./DOMHASH/mvnw test"
    //   //   // junit '**/target/surefire-reports/*.xml'
    //   // }
    // }

    stage('Build Docker image') {
      steps {
        sh 'cd ../'
        sh 'docker build -t domhash .'
        sh "docker tag domhash domhash:${BUILD_NUMBER}"
      }
    }

    stage('Deploy Docker image') {
      steps {
        sh "docker stop domhash"
        sh "docker rm domhash"
        sh "docker run -d --name domhash -v /var/run/docker.sock:/var/run/docker.sock domhash:${BUILD_NUMBER}"
      }
    }
  
  }
}