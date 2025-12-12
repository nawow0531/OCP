@Library('ocp@main') _   // 또는 @Library('ocp') _ 도 가능

ocpPodTemplate {
  stage('Checkout') {
    checkout scm
  }
  stage('Build') {
    sh 'echo hello'
  }
}
