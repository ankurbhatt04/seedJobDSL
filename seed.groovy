def createTestJob(ApplicationName, repoUrl) {
    multibranchPipelineJob(ApplicationName) {
        branchSources {
            git {
                id('12342343r434fe2')
                credentialsId('d594a6aa-4545-45fe-acca-d21d4088c63')    
                remote(repoUrl)
                includes('*')
            }
        }
        triggers {
            cron("H/5 * * * *")
        }
        
        orphanedItemStrategy {
        discardOldItems {
            numToKeep(5)
        }
    }
    }
}

def buildPipelineJobs(ApplicationName) {
    def repo = "https://github.com/ankurbhatt04/DevOpsGit.git"
    // def repoUrl = repo + jobName + ".git"
    // def deployName = jobName + "_deploy"
    // def testName = jobName + "_test"

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