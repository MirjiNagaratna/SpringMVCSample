/**
 * 
 */
package au.com.cnw.storefront.controllers.pages;

import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;

import java.util.Collections;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.com.cnw.contact.email.ContactEmailData;
import au.com.cnw.facades.contact.impl.DefaultContactFacade;
import au.com.cnw.storefront.breadcrumb.Breadcrumb;
import au.com.cnw.storefront.controllers.ControllerConstants;
import au.com.cnw.storefront.forms.ContactForm;
import au.com.cnw.storefront.forms.validation.ContactFormValidator;


/**
 * @author navya.n
 * 
 */
@Controller
@RequestMapping(value = "/contact")
public class ContactPageController extends AbstractPageController
{

	Logger LOG = Logger.getLogger(ContactPageController.class);

	private static final String CONTACT_CMS_PAGE = "contact";


	@Resource
	DefaultContactFacade contactFacade;

	@Resource
	ContactFormValidator contactFormValidator;

	/**
	 * @return the contactFormValidator
	 */
	public ContactFormValidator getContactFormValidator()
	{
		return contactFormValidator;
	}

	/**
	 * @param contactFormValidator
	 *           the contactFormValidator to set
	 */
	public void setContactFormValidator(final ContactFormValidator contactFormValidator)
	{
		this.contactFormValidator = contactFormValidator;
	}

	/**
	 * @return the contactFacade
	 */
	public DefaultContactFacade getContactFacade()
	{
		return contactFacade;
	}

	/**
	 * @param contactFacade
	 *           the contactFacade to set
	 */
	public void setContactFacade(final DefaultContactFacade contactFacade)
	{
		this.contactFacade = contactFacade;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getContactFormPage(final Model model) throws CMSItemNotFoundException
	{
		model.addAttribute(new ContactForm());
		storeCmsPageInModel(model, getContentPageForLabelOrId(CONTACT_CMS_PAGE));
		final Breadcrumb contactBreadcrumbEntry = new Breadcrumb("#", getMessageSource().getMessage("breadcrumb.text.contactUs",
				null, getI18nService().getCurrentLocale()), null);
		model.addAttribute("breadcrumbs", Collections.singletonList(contactBreadcrumbEntry));
		return ControllerConstants.Views.Pages.Contact.ContactPage;
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String processContactUserRequest(@Valid @ModelAttribute("contactForm") final ContactForm contactForm,
			final BindingResult bindingResult, final Model model) throws CMSItemNotFoundException
	{
		LOG.debug("We are in ContactPageController");
		getContactFormValidator().validate(contactForm, bindingResult);
		if (bindingResult.hasErrors())
		{
			storeCmsPageInModel(model, getContentPageForLabelOrId(CONTACT_CMS_PAGE));
			final Breadcrumb contactBreadcrumbEntry = new Breadcrumb("#", getMessageSource().getMessage("breadcrumb.text.contactUs",
					null, getI18nService().getCurrentLocale()), null);
			model.addAttribute("breadcrumbs", Collections.singletonList(contactBreadcrumbEntry));
			return ControllerConstants.Views.Pages.Contact.ContactPage;
		}
		final ContactEmailData contactEmailData = populateContactFormData(contactForm);
		contactFacade.contactEmail(contactEmailData);
		storeCmsPageInModel(model, getContentPageForLabelOrId(CONTACT_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CONTACT_CMS_PAGE));
		final Breadcrumb contactBreadcrumbEntry = new Breadcrumb("#", getMessageSource().getMessage(
				"breadcrumb.text.contactUs.success", null, getI18nService().getCurrentLocale()), null);
		model.addAttribute("breadcrumbs", Collections.singletonList(contactBreadcrumbEntry));
		return ControllerConstants.Views.Pages.Contact.SuccessPage;

	}

	public ContactEmailData populateContactFormData(final ContactForm contactForm)
	{
		final ContactEmailData contactEmailData = new ContactEmailData();
		contactEmailData.setYourName(contactForm.getYourName());
		contactEmailData.setEmailAddress(contactForm.getEmailAddress());
		contactEmailData.setPostCode(contactForm.getPostCode());
		contactEmailData.setContactNumber(contactForm.getContactNumber());
		contactEmailData.setEnquiry(contactForm.getEnquiry());
		return contactEmailData;
	}

}
