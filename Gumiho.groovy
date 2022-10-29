#!/usr/bin/env groovy

pipeline {
    agent {
        label 'ci'
    }

    parameters {
        string(name: 'FIRST_NAME', defaultValue: '', description: 'First name of a person', trim: true)
        string(name: 'SECOND_NAME', defaultValue: '', description: 'Second name of a person', trim: true)
    }

    options {
        timestamps()
    }

    stages {
        stage('validate value parameters') {
            steps {
                script {
                    if (params.FIRST_NAME == '') {
                        error 'Missing FIRST NAME'
                        echo "Missing FIRST NAME"
                    }
                    if (params.SECOND_NAME == '') {
                        error 'Missing SECOND NAME'
                        echo "Missing SECOND NAME"
                    }
                    echo "valid parameters"
                }
            }
        }

        stage('Print input parameter values to console'){
            steps {
                script {
                    echo "Your First name is ${params.FIRST_NAME}"
                    echo "Your Second name is ${params.SECOND_NAME}"
                    echo "End of param"
                }
            }
        }

        stage('Print full name') {
            steps {
                script {
                    echo "Full name is ${params.FIRST_NAME} ${params.SECOND_NAME}"
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}