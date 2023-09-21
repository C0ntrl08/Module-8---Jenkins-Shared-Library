#!/user/bin/env groovy

/* import com.example.Docker
def call(String imageName) {
    return new Docker(this).buildDockerImage(imageName)
} */

def buildImage() {
echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-c0ntrl08', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t c0ntrl08/module8-java-maven-app-for-dockerinjenkins:jma-3.1 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push c0ntrl08/module8-java-maven-app-for-dockerinjenkins:jma-3.1'
}
