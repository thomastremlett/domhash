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
          def imageName = "domhash"
          def registryUrl = registry:5000"
          def tag = "latest"
          def qualifiedImageName = "${registryUrl}/${imageName}:${tag}"
          def dockerImage = docker.build(qualifiedImageName, "--build-arg JAR_FILE=./app/build/libs/init-0.0.1-SNAPSHOT.jar .")
          docker.withRegistry(registryUrl) {
            dockerImage.push()
          }
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
