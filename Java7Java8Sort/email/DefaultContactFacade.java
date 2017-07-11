/**
 * 
 */
package au.com.cnw.facades.contact.impl;

import javax.annotation.Resource;

import au.com.cnw.contact.email.ContactEmailData;
import au.com.cnw.core.services.impl.DefaultContactService;
import au.com.cnw.facades.contact.ContactFacade;


/**
 * 
 * This DefaultContactFacade Class has implemented method that is used to send the contact us email by setting the
 * captured user data from the storefront contact us form and publish the email event
 * 
 * @author navya.n
 * 
 */
public class DefaultContactFacade implements ContactFacade
{

	@Resource
	DefaultContactService contactService;

	/**
	 * @return the contactService
	 */
	public DefaultContactService getContactService()
	{
		return contactService;
	}

	/**
	 * @param contactService
	 *           the contactService to set
	 */
	public void setContactService(final DefaultContactService contactService)
	{
		this.contactService = contactService;
	}

	/**
	 * @param contactEmailData
	 * 
	 *           This method is used to send the contact us email by setting the user data and publish the email event
	 * 
	 */
	@Override
	public void contactEmail(final ContactEmailData contactEmailData)
	{
		contactService.contactEmail(contactEmailData);

	}

}
