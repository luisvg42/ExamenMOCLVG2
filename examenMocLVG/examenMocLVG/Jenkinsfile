pipeline {
    agent any

    // Definición de herramientas. 
    // Asegúrate de que los nombres 'Maven 3.9.11' y 'Java 17' coinciden 
    // con los que configuraste en: Administrar Jenkins -> Tools.
    // Si usaste nombres automáticos, verifica cómo se llaman allí.
    tools {
        maven 'Maven3.9.11' 
        jdk 'jdk-21' // O el nombre que le hayas puesto a tu Java en Jenkins
    }

    environment {
        // Requisito: una constante con la versión del proyecto
        PROJECT_VERSION = '1.0.2' 
        // TIP: Asegúrate de que esta versión coincida con la de tu pom.xml
        
        // Pon aquí el nombre del jar que genera tu pom (artifactId)
        JAR_NAME = 'examenMocLVG' 
    }

     stages {
        stage('Build') {
            steps {
                bat 'echo Limpiando y compilando el proyecto con Maven'
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'echo Ejecutando tests con Maven'
                bat 'mvn test'
            }
        }

        stage('Move jar') {
            steps {
                bat """
                  echo Eliminando directorio versiones
                  if exist versiones rmdir /S /Q versiones
                  echo Se crea el directorio versiones con la última versión de la API
                  mkdir versiones
                  copy target\\${env.JAR_NAME}-${env.PROJECT_VERSION}.jar versiones\\
                """
            }
        }
    }

    post {
        success {
            bat 'echo Pipeline completado correctamente.'
        }
        failure {
            bat 'echo Ha ocurrido un error durante la ejecución del pipeline.'
        }
    }
     
}