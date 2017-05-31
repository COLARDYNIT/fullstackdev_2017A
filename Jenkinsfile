stage('build'){
	node {
    	mvnHome = tool 'M3'
    	JAVA_HOME = tool 'java 8'
    	checkout scm
    	sh "'${mvnHome}/bin/mvn' clean compile -Pprod -Dmaven.test.skip"
    }
}
stage ('test'){
    node {
        sh "'${mvnHome}/bin/mvn' test -Pprod"
    }
}

stage ('archive war'){
    node {
        sh "./mvnw -Pprod package"
        archiveArtifacts 'target/*.war'
    }
}
