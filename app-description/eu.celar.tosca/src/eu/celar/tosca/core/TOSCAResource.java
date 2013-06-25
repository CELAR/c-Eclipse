/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Stalo Sofokleous - initial API and implementation 
 ************************************************************/

package eu.celar.tosca.core;

import java.io.File;
import java.util.Enumeration;
import java.util.Hashtable;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.IOWrappedException;

import eu.celar.core.model.ICloudApplicationDescription;
import eu.celar.core.model.impl.ResourceCloudContainer;
import eu.celar.tosca.PoliciesType1;
import eu.celar.tosca.TBoundaryDefinitions;
import eu.celar.tosca.TPolicy;
import eu.celar.tosca.ToscaFactory;
import eu.celar.tosca.elasticity.GlobalElasticityRequirementsType1;
import eu.celar.tosca.elasticity.TBoundaryDefinitionsExtension;
import eu.celar.tosca.elasticity.TGlobalElasticityRequirement;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;

public class TOSCAResource extends ResourceCloudContainer implements ICloudApplicationDescription {
  
  private TOSCAModel model;
  protected ToscaFactory toscaFactory = ToscaFactory.eINSTANCE;
  protected Tosca_Elasticity_ExtensionsFactory elasticityFactory = Tosca_Elasticity_ExtensionsFactory.eINSTANCE;
  
  public TOSCAResource(final IFile file) {
    super (file);
    try {
      this.model = new TOSCAModel( new File( file.getLocation().toOSString() ) );
    } catch( IOWrappedException e ) {
      e.printStackTrace();
    }
  }

  @Override
  public String getApplicationName() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getApplicationDescription() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getApplicationVersion() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getApplicationExecutable() {
    // TODO Auto-generated method stub
    return null;
  }
  
  /**
   * @param name
   */
  public void setApplicationName(final String name) {
    this.model.getServiceTemplate().setName( name );
  }
  
  public void setOptimizationPolicy( final String optimizationPolicy ){
       
    TBoundaryDefinitions boundaryDef = this.model.getServiceTemplate().getBoundaryDefinitions();
    
    PoliciesType1 boundaryPolicies = this.toscaFactory.createPoliciesType1();
        
    boundaryDef.setPolicies( boundaryPolicies );
    
    EList<TPolicy> policy = boundaryPolicies.getPolicy();
        
    policy.add( this.toscaFactory.createTPolicy() );
    
    policy.get( 0 ).setName( optimizationPolicy );     
  }
  
  public void setGlobalElasticityRequirements(final Hashtable<String, String> requirementList){
              
    GlobalElasticityRequirementsType1 globalElasticityRequirementsList = this.elasticityFactory.createGlobalElasticityRequirementsType1();
      
    Enumeration<String> enumKey = requirementList.keys();
    while(enumKey.hasMoreElements()) {
        String key = enumKey.nextElement();
        String val = requirementList.get(key);
        
    TGlobalElasticityRequirement requirement = this.elasticityFactory.createTGlobalElasticityRequirement();
    
    requirement.setName( key );
    requirement.setValue( val );
    
    globalElasticityRequirementsList.getGlobalElasticityRequirements().add( requirement );
    
    }
    
    TBoundaryDefinitionsExtension boundaryDef = ( TBoundaryDefinitionsExtension )this.model.getServiceTemplate().getBoundaryDefinitions();
    
    boundaryDef.setGlobalElasticityRequirements( globalElasticityRequirementsList );
  }
  
  public void setUpBasicTOSCAStructure() {
    this.model.setUpBasicStructure();
  }
  
  public void save() {
    writeModelToFile( this.model.getDocumentRoot() );
  }
  
  private void writeModelToFile( final EObject toscaRoot ) {
    this.model.writeModelToFile( toscaRoot );
    try {
      this.getResource().refreshLocal( 0, new NullProgressMonitor() );
    } catch( CoreException exc ) {
      exc.printStackTrace();
    }
  }
 
}
