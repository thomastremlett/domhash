pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        withCredentials([sshUserPrivateKey(credentialsId: 'githubcreds', keyFileVariable: 'SSH_KEY', passphraseVariable: '', usernameVariable: 'SSH_USER')]) {
          sh """
            mkdir -p ~/.ssh
            chmod 700 ~/.ssh
            echo "$SSH_KEY" > ~/.ssh/id_rsa
            chmod 600 ~/.ssh/id_rsa
            ssh-keyscan github.com >> ~/.ssh/known_hosts
            git clone git@github.com:thomastremlett/domhash.git
          """
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
