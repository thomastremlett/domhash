pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        script { 
          git url: 'git@github.com:thomastremlett/domhash.git', branch: 'main', credentialsId: 'githubcreds'
          
        }
      }
    }
    stage('Build and Push Docker Image') {
      steps {
        script {
          docker.build('domhash').push('domhash:latest')
        }
      }
    }
    stage('Deploy to Docker Container') {
      steps {
        script {
          def docker = dockerUtils.getDocker()
          docker.withRegistry('http://registry:5000') {
            docker.image('domhash:latest').withRun('-p 8080:8080') { c ->
              // Container is running
            }
          }
        }
      }
    }
  }
}
