package com.chimpcentral.logger;

/**
 * Tags can not be extended and is not public.
 *  It holds the HTML tags in the different HTML helper files.
 * @author kbhatti
 *
 */
final class Tags {

	private Tags() {
	}
	
	/*
	 * top container element tags
	 */
	static final String titleTag = "<!-- chimp-central-title -->";
	static final String headingTag = "<!-- chimp-central-heading -->";
	static final String subHeadingTag = "<!-- chimp-central-sub-heading -->";
	
	/**
	 * navigation pane element tags
	 */
	static final String logoLinkTag = "<!-- chimp-central-logo-link -->";
	static final String logoLinkHrefTag = "<!-- chimp-central-logo-link-href -->";
	static final String logoLinkSrcURLTag = "<!-- chimp-central-logo-link-src-url -->";
	
	static final String mainLogLinkTag = "<!-- chimp-central-main-log-link -->";
	static final String mainLogLinkSrcURLTag = "<!-- chimp-central-main-log-link-src-url -->";
	
	static final String additionalLinksTag = "<!-- chimp-central-additional-links -->";
	static final String additionalLinkNameTag = "<!-- chimp-central-additional-link-name -->";
	static final String additionalLinkHrefTag = "<!-- chimp-central-additional-link-href -->";
	static final String additionalLinkSrcURLTag = "<!-- chimp-central-additional-link-src-url -->";
	
	/**
	 * log list pane element tags
	 */
	static final String logListTag = "<!-- chimp-central-log-list -->";
	static final String logListItemTag = "<!-- chimp-central-log-list-item -->";
	static final String logListItemNameTag = "<!-- chimp-central-log-list-item-name -->";
	
	/**
	 * main log container tags
	 */
	static final String logContainerStartTag = "<!-- chimp-central-log-container-start -->";
	static final String logContainerEndTag = "<!-- chimp-central-log-container-end -->";
	
	static final String logTableBodyTag = "<!-- chimp-central-log-table-body -->";
	static final String logTableBodyIdTag = "<!-- chimp-central-log-table-body-id -->";
	static final String logTableRowTag = "<!-- chimp-central-log-table-row -->";
	
	static final String logCollapsibleTopTextTag = "<!-- chimp-central-log-collapsible-top-text -->";
	static final String logCollapsibleBottomIdTag = "<!-- chimp-central-log-collapsible-bottom-id -->";
	static final String logCollapsibleBottomTextTag = "<!-- chimp-central-log-collapsible-bottom-text -->";

}
