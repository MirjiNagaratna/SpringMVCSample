/**
 * 
 */
package au.com.cnw.core.event;

import de.hybris.platform.commerceservices.event.AbstractCommerceUserEvent;


/**
 * This Event class is used while triggering event to send conatct us email to admin
 * 
 * @author navya.n
 * 
 */
public class ContactEvent extends AbstractCommerceUserEvent
{

	String yourName;
	String emailAddress;
	String postCode;
	String contactNumber;
	String enquiry;

	/**
	 * @param yourName
	 * @param emailAddress
	 * @param postCode
	 * @param contactNumber
	 * @param enquiry
	 */
	public ContactEvent(final String yourName, final String emailAddress, final String postCode, final String contactNumber,
			final String enquiry)
	{
		this.yourName = yourName;
		this.emailAddress = emailAddress;
		this.postCode = postCode;
		this.contactNumber = contactNumber;
		this.enquiry = enquiry;
	}

	/**
	 * @return the yourName
	 */
	public String getYourName()
	{
		return yourName;
	}

	/**
	 * @param yourName
	 *           the yourName to set
	 */
	public void setYourName(final String yourName)
	{
		this.yourName = yourName;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress()
	{
		return emailAddress;
	}

	/**
	 * @param emailAddress
	 *           the emailAddress to set
	 */
	public void setEmailAddress(final String emailAddress)
	{
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the postCode
	 */
	public String getPostCode()
	{
		return postCode;
	}

	/**
	 * @param postCode
	 *           the postCode to set
	 */
	public void setPostCode(final String postCode)
	{
		this.postCode = postCode;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber()
	{
		return contactNumber;
	}

	/**
	 * @param contactNumber
	 *           the contactNumber to set
	 */
	public void setContactNumber(final String contactNumber)
	{
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the enquiry
	 */
	public String getEnquiry()
	{
		return enquiry;
	}

	/**
	 * @param enquiry
	 *           the enquiry to set
	 */
	public void setEnquiry(final String enquiry)
	{
		this.enquiry = enquiry;
	}
}
