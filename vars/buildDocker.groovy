// vars/buildDocker.groovy
def call(String imageName, String tag, Map options = [:]) {
    def dockerfile = options.get('dockerfile', 'Dockerfile')
    def context = options.get('context', '.')
    
    echo "Building Docker image: ${imageName}:${tag}"
    sh "docker build -t ${imageName}:${tag} -f ${dockerfile} ${context}"
}
