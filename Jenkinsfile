def gitUrl = 'git@github.com:thomastremlett/domhash.git'
def gitBranch = 'main'
def gitCredentialsId = 'githubcreds'
def dockerRegistryUrl = 'http://registry:5000'
def dockerImageName = 'myimage'
def dockerImageTag = 'latest'
def dockerContainerName = 'mycontainer'
def dockerNetworkName = 'my_network'

pipeline {
  agent any
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
        sh 'docker build -t my-image .'
        sh 'docker tag my-image my-image:1.0'
        sh 'docker save my-image:1.0 > my-image.tar'
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
