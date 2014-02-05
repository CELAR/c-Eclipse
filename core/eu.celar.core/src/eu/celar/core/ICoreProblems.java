/*****************************************************************************
 * Copyright (c) 2008 g-Eclipse Consortium 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the
 * g-Eclipse project founded by European Union
 * project number: FP6-IST-034327  http://www.geclipse.eu/
 *
 * Contributors:
 *    Mathias Stuempert - initial API and implementation
 *    Ariel Garcia      - added more strings
 *    Pawel Wolniewicz  - added more strings
 *    Nicholas Loulloudes - code adapter for CELAR project, 2013 
 *****************************************************************************/
 
package eu.celar.core;


/**
 * This interface contains the ProblemID strings for accessing the core's
 * problems. These problem-ID's cover the issues expected to be common to
 * different plug-ins or middlewares, which can (and should) therefore be
 * reused by the whole CELAR framework and specific implementations.
 * The middleware dependent or the plug-in specific problems should be
 * declared by the affected plug-in.
 */
public interface ICoreProblems {
  
  // Cloud Model
  public static final String MODEL_CONTAINER_CAN_NOT_CONTAIN
    = "eu.celar.core.problem.model.containerCanNotContain"; //$NON-NLS-1$
  public static final String MODEL_ELEMENT_CREATE_FAILED
    = "eu.celar.core.problem.model.elementCreateFailed"; //$NON-NLS-1$
  public static final String MODEL_ELEMENT_DELETE_FAILED
    = "eu.celar.core.problem.model.elementDeleteFailed"; //$NON-NLS-1$
  public static final String MODEL_ELEMENT_LOAD_FAILED
    = "eu.celar.core.problem.model.elementLoadFailed"; //$NON-NLS-1$
  public static final String MODEL_ELEMENT_NOT_MANAGEABLE
    = "eu.celar.core.problem.model.elementNotManageable"; //$NON-NLS-1$
  public static final String MODEL_ELEMENT_SAVE_FAILED
    = "eu.celar.core.problem.model.elementSaveFailed"; //$NON-NLS-1$
  public static final String MODEL_FETCH_CHILDREN_FAILED
    = "eu.celar.core.problem.model.fetchChildrenFailed"; //$NON-NLS-1$
  public static final String MODEL_PREFERENCE_CREATION_FAILED
    = "eu.celar.core.problem.model.preferenceCreationFailed"; //$NON-NLS-1$
  public static final String MODEL_REFRESH_FAILED
    = "eu.celar.core.problem.model.refreshFailed"; //$NON-NLS-1$
  
  // IO
  public static final String IO_CORRUPTED_FILE
    = "eu.celar.core.problem.io.corruptedFile"; //$NON-NLS-1$
  public static final String IO_FILE_EXISTS
    = "eu.celar.core.problem.io.fileExists"; //$NON-NLS-1$
  public static final String IO_FILE_NOT_FOUND
    = "eu.celar.core.problem.io.fileNotFound"; //$NON-NLS-1$
  public static final String IO_OPERATION_FAILED
    = "eu.celar.core.problem.io.operationFailed"; //$NON-NLS-1$
  public static final String IO_UNSPECIFIED_PROBLEM
    = "eu.celar.core.problem.io.unspecified"; //$NON-NLS-1$
  
  // Auth
  public static final String AUTH_CERTIFICATE_LOAD_FAILED
    = "eu.celar.core.problem.auth.certificateLoadFailed"; //$NON-NLS-1$
  public static final String AUTH_CREDENTIAL_CREATE_FAILED
    = "eu.celar.core.problem.auth.credentialCreateFailed"; //$NON-NLS-1$
  public static final String AUTH_CREDENTIAL_SAVE_FAILED
    = "eu.celar.core.problem.auth.credentialSaveFailed"; //$NON-NLS-1$
  public static final String AUTH_INVALID_TOKEN_DESCRIPTION
    = "eu.celar.core.problem.auth.invalidTokenDescription"; //$NON-NLS-1$
  public static final String AUTH_KEY_LOAD_FAILED
    = "eu.celar.core.problem.auth.keyLoadFailed"; //$NON-NLS-1$
  public static final String AUTH_LOGIN_FAILED
    = "eu.celar.core.problem.auth.loginFailed"; //$NON-NLS-1$
  public static final String AUTH_PERMISSION_DENIED
    = "eu.celar.core.problem.auth.permissionDenied"; //$NON-NLS-1$  
  public static final String AUTH_TOKEN_ACTIVATE_FAILED
    = "eu.celar.core.problem.auth.tokenActivateFailed"; //$NON-NLS-1$
  public static final String AUTH_TOKEN_NOT_YET_VALID
    = "eu.celar.core.problem.auth.tokenNotYetValid"; //$NON-NLS-1$
  public static final String AUTH_TOKEN_REQUEST_CANCELED
    = "eu.celar.core.problem.auth.tokenRequestCanceled"; //$NON-NLS-1$
}
