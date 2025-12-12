def call(Closure body) {
  podTemplate(
    cloud: 'OCP',
    namespace: 'jenkins',
    serviceAccount: 'jenkins',
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
