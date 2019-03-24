node{
    stage("Remove Container"){
        try{
            sh "ssh root@${IP} docker rm -f myapp"
        }
        catch(exc){
            sh "echo container deleted"
        }
    }

    stage("Run Container"){
        sh "ssh root@${IP}  docker run -d --name myapp -p 6000:4000 azaa1/python_app"
    }

}

