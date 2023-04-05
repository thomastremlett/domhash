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
          def dockerImage = docker.build("my_image:latest", "--build-arg JAR_FILE=./app/build/libs/init-0.0.1-SNAPSHOT.jar .")
          docker.withRegistry("http://registry:5000") {
            dockerImage.push("my_image:latest")
          }
        }
      }
    }
    stage('Deploy to Docker Container') {
      steps {
        script {
          def docker = dockerUtils.getDocker()
          docker.withRegistry("http://registry:5000") {
            def container = docker.image("my_image:latest").run("-p 8080:8080", "--name my_container --network my_network registry:latest")
            println "Container ID: ${container.id}"
          }
        }
      }
    }
  }
}
