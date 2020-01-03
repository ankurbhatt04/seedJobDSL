def createDeploymentJob(jobName, repoUrl) {
    pipelineJob(jobName) {
        definition {
            cpsScm {
                scm {
                    git {
                        remote {
                            url(repoUrl)
                        }
                        branches('master')
                        extensions {
                            cleanBeforeCheckout()
                        }
                    }
                }
                scriptPath("Jenkinsfile")
            }
        }
    }
}

def createTestJob(jobName, repoUrl) {
    multibranchPipelineJob(jobName) {
        branchSources {
            git {
    
                remote(repoUrl)
                includes('*')
            }
        }
        triggers {
            cron("H/5 * * * *")
        }
    }
}

def buildPipelineJobs(ApplicationName) {
    def repo = "https://github.com/ankurbhatt04/DevOpsGit"
    // def repoUrl = repo + jobName + ".git"
    // def deployName = jobName + "_deploy"
    // def testName = jobName + "_test"

    createDeploymentJob(ApplicationName, repo)
    createTestJob(ApplicationName, repo)
}

buildPipelineJobs(ApplicationName)


// branchSources {
//     git {
        // Sets credentials for authentication with the remote repository.
        // credentialsId(String credentialsId)
        
        // Specifies a unique ID for this branch source.
        // id('123456789')
        // Sets the Git remote repository URL.
        
        // remote(String remote) // defines the git repository where the Jenkinsfile is located
//     }
// }
// triggers {
//       urlTrigger(String crontab = null) {
//           url(String url){
//               check(lastModified)  // Check the lastModified and trigger automatically this job
//           }
//       }
// } 