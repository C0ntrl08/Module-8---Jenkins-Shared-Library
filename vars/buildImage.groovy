#!/user/bin/env groovy

/* import com.example.Docker
def call(String imageName) {
    return new Docker(this).buildDockerImage(imageName)
} */

def buildImage() {
echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t nanatwn/demo-app:jma-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push nanatwn/demo-app:jma-2.0'
}
