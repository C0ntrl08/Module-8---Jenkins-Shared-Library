#!/user/bin/env groovy

import com.example.Docker
def call(String imageName) {
    return new Docker(this).buildDockerImage(imageName)
}

/*def call(String imageName) {
echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-c0ntrl08', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t $imageName ."
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh "docker push $imageName"
    }
}
*/
