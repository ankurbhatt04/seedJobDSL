multibranchPipelineJob(ApplicationName){
    description("Multi-branch job for Application $ApplicationName")
    
    // branchSources {
    //     git {
            // Sets credentials for authentication with the remote repository.
            // credentialsId(String credentialsId)
            
            // Specifies a unique ID for this branch source.
            // id('123456789')
            // Sets the Git remote repository URL.
            
            // remote(String remote)
    //     }
    // }
    // triggers {
    //       urlTrigger(String crontab = null) {
    //           url(String url){
    //               check(lastModified)  // Check the lastModified and trigger automatically this job
    //           }
    //       }
    // } 
}