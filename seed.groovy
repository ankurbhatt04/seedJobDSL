def createTestJob(ApplicationName, repoUrl) {
    multibranchPipelineJob(ApplicationName) {
        branchSources {
            git {
                id('12342343r434fe2')
                credentialsId('')    
                remote(repoUrl)
                includes('jenkinsFileTest')
            }
        }
        
        // triggers {
        //     urlTrigger(String crontab = null) {
        //         url(String url){
        //             check(lastModified)  // Check the lastModified and trigger automatically this job
        //         }
        //     }
        // }
        
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

buildPipelineJobs("abc")


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


