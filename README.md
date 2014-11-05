##c-Eclipse

c-Eclipse is an ongoing project, part of the EU [CELAR](http://www.celarcloud.eu/) project. The c-Eclipse plugin consists of several modules, enabling the description of the structure, elasticity requirements and other behavioral features of an application to be run over a Cloud platform. The description is translated on the fly into [TOSCA](http://docs.oasis-open.org/tosca/TOSCA/v1.0/cs01/TOSCA-v1.0-cs01.html) xml.

###Installation

Install c-Eclipse Plugin by adding the following URL in Eclipses' Available Software Sites.
http://snf-153388.vm.okeanos.grnet.gr/ceclipse/p2/

 * Open Eclipse
 * Help -> Install New Software -> Add
 * Give a name for the c-Eclipse plugin (i.e. c-Eclipse )
 * Give the location of the c-Eclipse repository, which is http://snf-153388.vm.okeanos.grnet.gr/ceclipse/p2/ -> OK
 * Check c-Eclipse box
 * Next -> Next -> Accept -> Finish -> OK -> Restart Eclipse

###Getting Started

##### Open c-Eclipse Prespective 
 * Window -> Open Perspective -> Other -> c-EclipsePerspective -> OK

#####Create a new c-Eclipse Project
 * Right Click in Cloud Project View -> New -> Other -> CELAR / CELAR Project
 * Give the project a name i.e. myProject -> Next -> Edit Cloud Providers -> Add -> Generic Cloud Provider -> Next
 * Give a name for the Cloud provider -> Finish -> OK -> Finish

#####Create a new Application Description
 * Right click on the "Application Descriptions" folder under the CELAR project you have just created -> New -> Other -> CELAR / Application Description
 * Give the description a name -> Finish
 * Application file is stored under "Application Descriptions" folder
 * Drag-and-drop elements from the Palette onto the center Canvas to create a graphical description of an application
 * Use the tabs in the Properties View to give additional details to your graphical description
 * Right click -> Import on "Artifacts" / "Deployment Scripts" folder to import any custom configuration scripts (Might need to re-open graphical  description for the newly imported files to be presented in the Palette)
 * To open graphical description: Right click on the application file -> Open With -> Tosca Diagram Editor
 * To open xml tosca description: Right click on the application file -> Open With -> Text Editor
 
 
#####Submit application to Cloud provider
* To submit an application to a Cloud provider, a [CELAR Server](https://github.com/CELAR/celar-server) must be first installed and configured for the specific provider
* Right click on the application description file (with extension .tosca) under the "Application Descriptions" folder 
* Select the "Application Submission" action from the pop up menu
* Give a name for the submited file -> Next
* Edit Cloud Providers -> Add -> Generic Cloud Provider -> Next
* Give the name of the Cloud provider
* Give the uri and port of the CELAR Server installed on the given provider
* Finish -> OK -> Finish
* The application submission file is created under the "Application Submissions" folder. It is the same file, with the application description created at the previous step, and it can be customized with details for the selected Cloud provider

#####Deploy a described application
* Right click on the application submission file (with extension .tosca) under the "Application Submissions" folder
* Select the "Application Deployment" action from the pop up menu
* Select the Cloud provider to deploy the application -> Finish
 
###Website
http://linc.ucy.ac.cy/CELAR/ceclipse/

###Contact Us
Please contact Nicholas Loulloudes (loulloudes.n@cs.ucy.ac.cy) or Stalo Sofokleous (stalosof@cs.ucy.ac.cy) for any issue
