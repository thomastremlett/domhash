def gitUrl = 'git@github.com:thomastremlett/domhash.git'
def gitBranch = 'main'
def gitCredentialsId = 'githubcreds'

pipeline {
  agent {
    docker {
      image 'docker:20.10.10'
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

    stage('Install Maven and OpenJDK17') {
      steps {
        sh '''
          apt-get update
          apt-get install -y openjdk-17-jdk
          apt-get install -y maven
        '''
      }
    }

    stage('Build Java Microservice') {
      steps {
        sh 'mvn clean install -f DOMHASH/pom.xml'
      }
    }


    // stage('TestMicroservice') {
    //   // steps {
    //   //   // sh "cd ./app"
    //   //   // sh "./mvnw test"
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
        sh "docker run -d --name domhash -v /var/run/docker.sock:/var/run/docker.sock domhash:${BUILD_NUMBER}"
      }
    }
  
  }
}