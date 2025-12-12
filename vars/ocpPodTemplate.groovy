def call(Closure body) {
  podTemplate(
    cloud: 'OCP',
    namespace: 'jenkins',
    serviceAccount: 'jenkins',
    jnlpImage: 'bastion.bccard.local:5000/jenkins/ose-jenkins-agent-base:4.12',
    containers: [
      containerTemplate(
        name: 'oc',
        image: 'registry.redhat.io/openshift4/ose-cli:latest',
        command: 'cat',
        ttyEnabled: true
      )
    ]
  ) {
    node(POD_LABEL) {
      body()
    }
  }
}
