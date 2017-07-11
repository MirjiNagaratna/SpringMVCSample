/**
 * 
 */

package au.com.cnw.facades.process.email.context;

import de.hybris.platform.acceleratorservices.model.cms2.pages.EmailPageModel;
import de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.model.process.StoreFrontCustomerProcessModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.util.Config;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import au.com.bgw.pim.core.util.EmailUtility;
import au.com.bgw.pim.facades.constants.BgwpimFacadesConstants;
import au.com.cnw.core.model.ContactProcessModel;
import au.com.cnw.facades.constants.CnwfacadesConstants;


/**
 * 
 * Velocity context for a Contact Us email to generate email context .
 * 
 * @author navya.n
 * 
 */

public class ContactEmailContext extends AbstractEmailContext<StoreFrontCustomerProcessModel>
{
	private String yourName;
	private String emailAddress;
	private String postCode;
	private String contactNumber;
	private String enquiry;

	private String helpLinkUrl;
	private String termsAndConditionsUrl;
	private String contactUsLinkUrl;

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



	/**
	 * @return the helpLinkUrl
	 */

	public String getHelpLinkUrl()
	{
		return helpLinkUrl;
	}

	/**
	 * @param helpLinkUrl
	 *           the helpLinkUrl to set
	 */

	public void setHelpLinkUrl(final String helpLinkUrl)
	{
		this.helpLinkUrl = helpLinkUrl;
	}

	/**
	 * @return the termsAndConditionsUrl
	 */

	public String getTermsAndConditionsUrl()
	{
		return termsAndConditionsUrl;
	}

	/**
	 * @param termsAndConditionsUrl
	 *           the termsAndConditionsUrl to set
	 */

	public void setTermsAndConditionsUrl(final String termsAndConditionsUrl)
	{
		this.termsAndConditionsUrl = termsAndConditionsUrl;
	}

	/**
	 * @return the contactUsLinkUrl
	 */

	public String getContactUsLinkUrl()
	{
		return contactUsLinkUrl;
	}

	/**
	 * @param contactUsLinkUrl
	 *           the contactUsLinkUrl to set
	 */

	public void setContactUsLinkUrl(final String contactUsLinkUrl)
	{
		this.contactUsLinkUrl = contactUsLinkUrl;
	}

	/**
	 * @param businessProcessModel
	 * @return BaseSiteModel
	 * 
	 */
	@Override
	protected BaseSiteModel getSite(final StoreFrontCustomerProcessModel businessProcessModel)
	{
		return businessProcessModel.getSite();
	}

	/**
	 * @param businessProcessModel
	 * @return CustomerModel
	 * 
	 */
	@Override
	protected CustomerModel getCustomer(final StoreFrontCustomerProcessModel businessProcessModel)
	{
		return businessProcessModel.getCustomer();
	}

	/**
	 * @return LanguageModel
	 * @param businessProcessModel
	 */
	@Override
	protected LanguageModel getEmailLanguage(final StoreFrontCustomerProcessModel businessProcessModel)
	{
		return businessProcessModel.getLanguage();
	}

	/**
	 * call to generate email context
	 * 
	 * @param storeFrontCustomerProcessModel
	 * @param emailPageModel
	 * 
	 */
	@Override
	public void init(final StoreFrontCustomerProcessModel storeFrontCustomerProcessModel, final EmailPageModel emailPageModel)
	{
		super.init(storeFrontCustomerProcessModel, emailPageModel);
		if (storeFrontCustomerProcessModel instanceof ContactProcessModel)
		{
			setYourName(((ContactProcessModel) storeFrontCustomerProcessModel).getYourName());
			setEmailAddress(((ContactProcessModel) storeFrontCustomerProcessModel).getEmialAddress());
			setPostCode(((ContactProcessModel) storeFrontCustomerProcessModel).getPostCode());
			setContactNumber(((ContactProcessModel) storeFrontCustomerProcessModel).getContactNumber());
			setEnquiry(((ContactProcessModel) storeFrontCustomerProcessModel).getEnquiry());
		}

		final String email = Config.getString(CnwfacadesConstants.CONTACT_TO_ADDRESS_EMAILID, StringUtils.EMPTY);
		final String toAddress = EmailUtility.getInstance().getToAddressEmail(email);
		if (StringUtils.isNotEmpty(toAddress) && isValidEmail(toAddress))
		{
			put(EMAIL, toAddress);
		}
		put(DISPLAY_NAME, emailPageModel.getFromName(Locale.getDefault()));
		setHelpLinkUrl(getBaseUrl().concat(Config.getString(CnwfacadesConstants.HELP_LINK_URL, null)));
		setTermsAndConditionsUrl(getBaseUrl().concat(Config.getString(CnwfacadesConstants.TERMS_AND_CONDIOTIONS_URL, null)));
		setContactUsLinkUrl(getBaseUrl().concat(Config.getString(CnwfacadesConstants.CONTACT_US_LINK_URL, null)));

	}

	/**
	 * To check valid email or not
	 * 
	 * @param email
	 * @return boolean
	 */
	private boolean isValidEmail(final String email)
	{
		final Pattern pattern = Pattern.compile(BgwpimFacadesConstants.EMAIL_REGEX);
		final Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

}
