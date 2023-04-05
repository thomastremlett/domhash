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
    stage('Build and Push Docker Image') {
      steps {
        script {
          def dockerImage = docker.build("${dockerImageName}:${dockerImageTag}", "--build-arg JAR_FILE=./app/build/libs/init-0.0.1-SNAPSHOT.jar .")
          docker.withRegistry(dockerRegistryUrl) {
            dockerImage.push("${dockerImageName}:${dockerImageTag}")
          }
        }
      }
    }
    stage('Deploy to Docker Container') {
      steps {
        script {
          def docker = dockerUtils.getDocker()
          docker.withRegistry(dockerRegistryUrl) {
            def container = docker.image("${dockerImageName}:${dockerImageTag}").run("-p 8080:8080", "--name ${dockerContainerName} --network ${dockerNetworkName} registry:latest")
            println "Container ID: ${container.id}"
          }
        }
      }
    }
  }
}
