stage('build'){
	node {
    	mvnHome = tool 'M3'
    	JAVA_HOME = tool 'java 8'
    	checkout scm
    	sh "'${mvnHome}/bin/mvn' clean compile -Pci -Dmaven.test.skip"
    	archive 'target/*.war'
    }
}
