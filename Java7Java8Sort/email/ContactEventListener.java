/**
 * 
 */
package au.com.cnw.core.event;

import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.constants.GeneratedCommerceServicesConstants.Enumerations.SiteChannel;
import de.hybris.platform.commerceservices.event.AbstractSiteEventListener;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.util.ServicesUtil;

import org.springframework.beans.factory.annotation.Required;

import au.com.cnw.core.model.ContactProcessModel;


/**
 * This Event Listener is used to create and start the business process i.e., Contact Process
 * 
 * @author navya.n
 * 
 */
public class ContactEventListener extends AbstractSiteEventListener<ContactEvent>
{
	ModelService modelService;

	/**
	 * @return the modelService
	 */
	public ModelService getModelService()
	{
		return modelService;
	}


	/**
	 * @param modelService
	 *           the modelService to set
	 */
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	BusinessProcessService businessProcessService;

	/**
	 * @return the businessProcessService
	 */
	public BusinessProcessService getBusinessProcessService()
	{
		return businessProcessService;
	}


	/**
	 * @param businessProcessService
	 *           the businessProcessService to set
	 */
	@Required
	public void setBusinessProcessService(final BusinessProcessService businessProcessService)
	{
		this.businessProcessService = businessProcessService;
	}


	/**
	 * @param contactEvent
	 * 
	 *           To create contact us process model and start process
	 */
	@Override
	protected void onSiteEvent(final ContactEvent contactEvent)
	{

		final ContactProcessModel contactProcessModel = (ContactProcessModel) getBusinessProcessService().createProcess(
				"contactEmailProcess" + "-" + System.currentTimeMillis(), "contactEmailProcess");
		contactProcessModel.setSite(contactEvent.getSite());
		contactProcessModel.setLanguage(contactEvent.getLanguage());
		contactProcessModel.setCurrency(contactEvent.getCurrency());
		contactProcessModel.setStore(contactEvent.getBaseStore());

		contactProcessModel.setYourName(contactEvent.getYourName());
		contactProcessModel.setEmialAddress(contactEvent.getEmailAddress());
		contactProcessModel.setPostCode(contactEvent.getPostCode());
		contactProcessModel.setContactNumber(contactEvent.getContactNumber());
		contactProcessModel.setEnquiry(contactEvent.getEnquiry());

		getModelService().save(contactProcessModel);
		getBusinessProcessService().startProcess(contactProcessModel);
	}

	@Override
	protected boolean shouldHandleEvent(final ContactEvent event)
	{
		final BaseSiteModel site = event.getSite();
		ServicesUtil.validateParameterNotNullStandardMessage("event.order.site", site);
		return SiteChannel.B2B.equals(site.getChannel().name());
	}


}
