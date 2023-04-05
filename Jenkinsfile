def gitUrl = 'git@github.com:thomastremlett/domhash.git'
def gitBranch = 'main'
def gitCredentialsId = 'githubcreds'
def dockerRegistryUrl = 'http://registry:5000'
def dockerImageName = 'myimage'
def dockerImageTag = 'latest'
def dockerContainerName = 'mycontainer'
def dockerNetworkName = 'my_network'

pipeline {
  agent {
    docker {
      image 'docker:20.10.10'
      args '-v /var/run/docker.sock:/var/run/docker.sock'
    }
  }
  stages {

    stage('Checkout') {
      steps {
        script {
          git url: gitUrl, branch: gitBranch, credentialsId: gitCredentialsId
        }
      }
    }

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
    // stage('Deploy Docker image') {
    //   steps {
    //     sh 'scp my-image.tar tremo@:/path/to/my-image.tar'
    //     sshagent (credentials: ['my-ssh-key']) {
    //       sh 'ssh user@target-machine "docker load < /path/to/my-image.tar"'
    //     }
    //   }
    // }
  }
}
