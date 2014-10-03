package eu.celar.ui.PropertyTesters;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;


public class SubmissionsFolderTester extends PropertyTester{

  @Override
  public boolean test( Object receiver,
                       String property,
                       Object[] args,
                       Object expectedValue )
  {
//    IFolder folder=(IFolder)receiver;
//    String folderPath=folder.getProjectRelativePath().toString();
//    String arr[]=folderPath.split("/");     
//    try {
//        if(folder.getProject().hasNature(expectedValue.toString()))
//        {
//            if(arr[0].equals("XYZ"))
//            {
//                return true;
//            }
//        }
//    } catch (CoreException e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//    }
//
//    return false;
    return true;
  }
}
