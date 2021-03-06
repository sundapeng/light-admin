package org.lightadmin.page.fieldDisplay.filter;

import org.junit.Assert;
import org.junit.Test;
import org.lightadmin.LoginOnce;
import org.lightadmin.RunWithConfiguration;
import org.lightadmin.SeleniumIntegrationTest;
import org.lightadmin.config.FilterTestEntityConfiguration;
import org.lightadmin.data.Domain;

@RunWithConfiguration( {FilterTestEntityConfiguration.class })
@LoginOnce( domain = Domain.FILTER_TEST_DOMAIN )
public class CaptionTest extends SeleniumIntegrationTest {

	@Test
	public void userDefinedCaptionsAreShown(){
		getStartPage().openAdvancedSearch();

		Assert.assertArrayEquals( expectedCaptions, getStartPage().getFilterCaptions());
	}

	private String[] expectedCaptions = new String[] {"Identifier:", "The Text Field:", "The Integer Field:", "The Primitive Integer Field:", "The Decimal Field:", "The Boolean Field:"};
}
