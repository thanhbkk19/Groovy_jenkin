def JENKIN_APP_REPO = "${GITHUB_SSH_URL}:${GITHUB_CLIENT_ORGANIZATION}/nicv_bootcamp_jobs_groovy.git"
pipelineJob('Starcamp-3/Gumiho-exercise-2') {
    displayName('Test jenkin using DSL job')
    logRotator { numToKeep(20) }
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        name 'nicv_bootcamp_jenkins_jobs'
                        url(JENKIN_APP_REPO)
                        credentials('GITHUB_PRIVATE_KEY')
                    }
                    branches('master')
                    scriptPath('Starcamp-3/Gumiho_main.groovy')
                }
            }
            lightweight()
        }
    }
}