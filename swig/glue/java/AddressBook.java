/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opentransactions.jni.core;

import java.util.ArrayList;
import java.util.List;

public class AddressBook extends Storable {
  private long swigCPtr;

  protected AddressBook(long cPtr, boolean cMemoryOwn) {
    super(otapiJNI.AddressBook_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AddressBook obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        otapiJNI.delete_AddressBook(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }
// ------------------------
	/*@SWIG:otapi/OTAPI.i,338,OT_CONTAINER_TYPE_MEMBERS@*/
	private List elementList = new ArrayList();
/*@SWIG@*/
	/*@SWIG:otapi/OTAPI.i,419,OT_ADD_ELEMENT@*/  // THIS BLOCK CONTAINS JAVA CODE.
private long removeRefContact(long lIndex) {
	// 
	// loop through the elements in the actual container, in order to find the one
	// at lIndex. Once it is found, then loop through the reference list and remove
	// the corresponding reference for that element.
	//
	Contact refActualElement = GetContact(lIndex);

	if (refActualElement == null)
		return lIndex; // oh well.
	
	// Loop through the reference list and remove the corresponding reference
	// for the specified element.
	//
	for(int intIndex = 0; intIndex < elementList.size(); intIndex++)
	{
		Object theObject = elementList.get(intIndex);
		
		if ((theObject == null) || !(theObject instanceof Contact))
			continue;

		Contact tempRef = (Contact)(theObject);
		
		if ((Contact.getCPtr(tempRef) == Contact.getCPtr(refActualElement)))
		{
			elementList.remove(tempRef);
			break;
		}
	}
	
	return lIndex;
}

private long getCPtrAddRefContact(Contact element) {
	// Whenever adding a reference to the list, I remove it first (if already there.)
	// That way we never store more than one reference per actual contained object.
	//
	for(int intIndex = 0; intIndex < elementList.size(); intIndex++)
	{
		Object theObject = elementList.get(intIndex);

		if ((theObject == null) || !(theObject instanceof Contact))
			continue;
		
		Contact tempRef = (Contact)(theObject);
		
		if ((Contact.getCPtr(tempRef) == Contact.getCPtr(element)))
		{
			elementList.remove(tempRef); // It was already there, so let's remove it before adding (below.)
			break;
		}
	}
	// Now we add it...
	//
	Contact tempLocalRef = element;
	elementList.add(tempLocalRef);
	return Contact.getCPtr(element);
}	// Hope I get away with overloading this for every type. Otherwise,
/*@SWIG@*/
  public long GetContactCount() { return otapiJNI.AddressBook_GetContactCount(swigCPtr, this); }

  public Contact GetContact(long nIndex) {
    long cPtr = otapiJNI.AddressBook_GetContact(swigCPtr, this, nIndex);
    return (cPtr == 0) ? null : new Contact(cPtr, false);
  }

  public boolean RemoveContact(long nIndexContact) {
    return otapiJNI.AddressBook_RemoveContact(swigCPtr, this, removeRefContact(nIndexContact));
  }

  public boolean AddContact(Contact disownObject) {
    return otapiJNI.AddressBook_AddContact(swigCPtr, this, Contact.getCPtr(disownObject), disownObject);
  }

  public static AddressBook ot_dynamic_cast(Storable pObject) {
    long cPtr = otapiJNI.AddressBook_ot_dynamic_cast(Storable.getCPtr(pObject), pObject);
    return (cPtr == 0) ? null : new AddressBook(cPtr, false);
  }

}
