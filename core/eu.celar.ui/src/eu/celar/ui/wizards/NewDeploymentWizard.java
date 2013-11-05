package eu.celar.ui.wizards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class NewDeploymentWizard extends Wizard implements INewWizard{

  private IStructuredSelection selection;
  private NewSubmissionWizardSecondPage secondPage;
  
  private IFile deploymentFile;
  private String deploymentString;
  
  @Override
  public void init( IWorkbench workbench, IStructuredSelection selection ) {
    setWindowTitle( Messages.getString( "NewApplicationSubmissionWizard.windowTitle" ) ); //$NON-NLS-1$
    this.selection = selection;
    Object tempFile = this.selection.getFirstElement();
    this.deploymentFile = (IFile) tempFile;
  }
  
  @Override
  public void addPages() {
    
    this.secondPage = new NewSubmissionWizardSecondPage( Messages.getString( "NewSubmissionWizardSecondPage.pageName" )); //$NON-NLS-1$
    this.secondPage.setTitle( Messages.getString( "NewSubmissionWizardSecondPage.pageTitle" ) ); //$NON-NLS-1$
    this.secondPage.setDescription( Messages.getString( "NewSubmissionWizardSecondPage.pageDescription" ) ); //$NON-NLS-1$
    addPage( this.secondPage );

  }
  
  @Override
  public boolean performFinish() {
	  
    //Convert Deployment file to String

	    Object tempFile = this.selection.getFirstElement();
	    this.deploymentFile = (IFile) tempFile;
	    
	    //Convert TOSCA Application Description file to String
	    BufferedReader br = null;
	    StringBuilder sb = new StringBuilder();
	    String line;
	    
	    try {
	      br = new BufferedReader(new InputStreamReader(this.deploymentFile.getContents()));
	    } catch( CoreException e1 ) {
	      // TODO Auto-generated catch block
	      e1.printStackTrace();
	    }

	    try {
	      while ((line = br.readLine()) != null) {
	          sb.append(line);
	      }
	    } catch( IOException e1 ) {
	      // TODO Auto-generated catch block
	      e1.printStackTrace();
	    }
	    
	    this.deploymentString = sb.toString();
    
	    String ycsbPattern = "ycsbmulti="+"\"";
	    String[] ycsb = this.deploymentString.split(ycsbPattern);
	    Integer ycsbMulti1 = Integer.parseInt(ycsb[1].substring(0, ycsb[1].indexOf("\"")));
	    Integer ycsbMulti2 = Integer.parseInt(ycsb[2].substring(0, ycsb[2].indexOf("\"")));    
	    Integer ycsbMulti;
	    if (ycsbMulti1!=1)
	    	ycsbMulti = ycsbMulti1;
	    else if (ycsbMulti2!=1)
	    	ycsbMulti = ycsbMulti2;
	    else
	    	ycsbMulti = 1;
	    
	    String casPattern = "casmulti="+"\"";
	    String[] cas = this.deploymentString.split(casPattern);
	    Integer casMulti1 = Integer.parseInt(cas[1].substring(0, cas[1].indexOf("\"")));
	    Integer casMulti2 = Integer.parseInt(cas[2].substring(0, cas[2].indexOf("\"")));   
	    Integer casMulti;
	    if (casMulti1!=1)
	    	casMulti = casMulti1;
	    else if (casMulti2!=1)
	    	casMulti = casMulti2;
	    else
	    	casMulti = 1;
	    
    //Deploy Cassandra application using HTTP
    URL url = null;
    HttpURLConnection connection = null;
    try {
      url = new URL ("http://83.212.116.50:8080/celar-server-api/deployment/deploy/?" + "casmulti=" + casMulti + "&ycsbmulti=" + ycsbMulti);
      int x=0;
      connection = (HttpURLConnection) url.openConnection();

      connection.setRequestMethod( "GET" );
      
      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
          System.out.println(inputLine);
      }
      in.close();
      
      connection.disconnect();
      
    } catch( MalformedURLException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return true;
    
  }

}
