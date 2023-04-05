pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        sshagent(credentials: ['847d0dca-c893-48b9-9b96-ba0046889e9f']) {
          git url: 'git@github.com:thomastremlett/domhash.git', branch: 'main'
        }
      }
    }
    stage('Build and Push Docker Image') {
      steps {
        script {
          docker.build('domhash').push('registry:5000/domhash')
        }
      }
    }
    stage('Deploy to Docker Container') {
      steps {
        script {
          def docker = dockerUtils.getDocker()
          docker.withRegistry('http://registry:5000', 'docker-registry-credentials') {
            docker.image('registry:5000/domhash').withRun('-p 8080:8080') { c ->
              // Container is running
            }
          }
        }
      }
    }
  }
}
