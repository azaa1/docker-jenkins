node{
    properties([parameters([string(defaultValue: '104.248.7.62', description: 'Enter the server IP', name: 'IP', trim: false), string(defaultValue: 'latest', description: 'Enter the app version', name: 'VER', trim: false), string(defaultValue: '4000', description: 'Enter the port to run the app on ', name: 'PORT', trim: false)])])
    stage("Remove Container"){
        try{
            sh "ssh root@${IP} docker rm -f myapp"
        }
        catch(exc){
            sh "echo container deleted"
        }
    }

    stage("Run Container"){
        sh "ssh root@${IP}  docker run -d --name myapp -p ${PORT}:4000 azaa1/python_app:${VER}"
    }

}

