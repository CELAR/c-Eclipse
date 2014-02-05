/************************************************************
 * Copyright (C), 2014 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.connectors.aws;

import org.eclipse.core.runtime.NullProgressMonitor;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.RegionUtils;
import com.amazonaws.services.ec2.AmazonEC2Client;

import eu.celar.connectors.aws.auth.AWSAuthToken;
import eu.celar.connectors.aws.auth.AWSAuthTokenDescription;
import eu.celar.core.auth.AbstractAuthTokenProvider;
import eu.celar.core.auth.AuthTokenRequest;
import eu.celar.core.model.CloudModel;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudProviderManager;
import eu.celar.core.reporting.ProblemException;


/**
 * @author Nicholas Loulloudes
 *
 */
public class EC2Client {
  private static AmazonEC2Client ec2;
  
  public static AmazonEC2Client getEC2() {
    if ( ec2 == null) {
      AWSCredentials awsCredentials = getAWSAuthCredentials();
      if( awsCredentials != null ) {        
        ec2 = new AmazonEC2Client( awsCredentials );
        ec2.setRegion( RegionUtils.getRegion( "eu-west-1" ) );         //$NON-NLS-1$        
      }

    }
    return ec2;
  }
  
  private static AWSCredentials getAWSAuthCredentials()  {
    AWSCredentials awsCredentials = null;
    ICloudProviderManager cpManager = CloudModel.getCloudProviderManager();
    ICloudElement[] children;
    try {
      children = cpManager.getChildren( new NullProgressMonitor() );
      String accessId = null;
      for( ICloudElement CloudElement : children ) {
        if( CloudElement instanceof AWSCloudProvider ) {
          AWSCloudProvider awsCp = ( AWSCloudProvider )CloudElement;
          accessId = awsCp.getProperties().getAwsAccessId();
        }
      }
      if( accessId != null ) {
        // get the auth token
        AWSAuthTokenDescription awsAuthTokenDesc = new AWSAuthTokenDescription( accessId );
        AuthTokenRequest request = new AuthTokenRequest( awsAuthTokenDesc,
                                                         "AmazonAWSFetch", //$NON-NLS-1$
                                                         "Fectch AWS Info" ); //$NON-NLS-1$
        AWSAuthToken awsAuthToken = ( AWSAuthToken )AbstractAuthTokenProvider.staticRequestToken( request );
        if( awsAuthToken != null ) {
          awsCredentials = new BasicAWSCredentials( awsAuthTokenDesc.getAwsAccessId(),
                                                    awsAuthTokenDesc.getAwsSecretId() );
        }
      }
    } catch( ProblemException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    
    return awsCredentials;
  }
}
