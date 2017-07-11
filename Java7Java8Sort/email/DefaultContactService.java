/**
 * 
 */
package au.com.cnw.core.services.impl;

import de.hybris.platform.commerceservices.customer.impl.DefaultCustomerAccountService;
import de.hybris.platform.commerceservices.event.AbstractCommerceUserEvent;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.util.Config;

import org.apache.log4j.Logger;

import au.com.cnw.contact.email.ContactEmailData;
import au.com.cnw.core.constants.CnwcoreConstants;
import au.com.cnw.core.event.ContactEvent;
import au.com.cnw.core.services.ContactService;


/**
 * This class is used to publish the Contact Us Email event by passing the captured user data from the storefront
 * 
 * @author navya.n
 * 
 */
public class DefaultContactService extends DefaultCustomerAccountService implements ContactService
{

	Logger LOG = Logger.getLogger(DefaultContactService.class);

	private EventService eventService;

	/**
	 * @return the eventService
	 */
	@Override
	public EventService getEventService()
	{
		return eventService;
	}

	/**
	 * @param eventService
	 *           the eventService to set
	 */
	@Override
	public void setEventService(final EventService eventService)
	{
		this.eventService = eventService;
	}

	/**
	 * @param contactEmailData
	 * 
	 *           This method publishes the Contact Us Email Event by passing the captured user data from the storefront
	 * 
	 */
	@Override
	public void contactEmail(final ContactEmailData contactEmailData)
	{
		if (Config.getBoolean(CnwcoreConstants.ALL_EMAILS_TRIGGERING_ENABBLED, false))
		{
			eventService.publishEvent(initializeEvent(new ContactEvent(contactEmailData.getYourName(), contactEmailData
					.getEmailAddress(), contactEmailData.getPostCode(), contactEmailData.getContactNumber(), contactEmailData
					.getEnquiry())));
		}

	}

	/**
	 * This method is used to set the required basic data like site,store,currency and language data to the event
	 * 
	 * @param event
	 * @return AbstractCommerceUserEvent
	 */
	@SuppressWarnings(
	{ "rawtypes", "rawtypes", "rawtypes" })
	protected AbstractCommerceUserEvent initializeEvent(final AbstractCommerceUserEvent event)
	{
		LOG.debug("Initializing Event to trigger");
		event.setBaseStore(getBaseStoreService().getCurrentBaseStore());
		event.setSite(getBaseSiteService().getCurrentBaseSite());
		event.setLanguage(getCommonI18NService().getCurrentLanguage());
		event.setCurrency(getCommonI18NService().getCurrentCurrency());
		return event;
	}

}
