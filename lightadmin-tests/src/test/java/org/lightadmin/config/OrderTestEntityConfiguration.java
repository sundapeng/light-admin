package org.lightadmin.config;

import org.lightadmin.core.config.annotation.Administration;
import org.lightadmin.core.config.domain.common.FieldSetConfigurationUnitBuilder;
import org.lightadmin.core.config.domain.configuration.EntityMetadataConfigurationUnit;
import org.lightadmin.core.config.domain.configuration.EntityMetadataConfigurationUnitBuilder;
import org.lightadmin.core.config.domain.context.ScreenContextConfigurationUnit;
import org.lightadmin.core.config.domain.context.ScreenContextConfigurationUnitBuilder;
import org.lightadmin.core.config.domain.unit.FieldSetConfigurationUnit;
import org.lightadmin.test.model.TestOrder;
import org.lightadmin.test.renderer.LineItemRenderer;

@SuppressWarnings("unused")
@Administration(TestOrder.class)
public class OrderTestEntityConfiguration {

	public static EntityMetadataConfigurationUnit configuration( EntityMetadataConfigurationUnitBuilder configurationBuilder ) {
		return configurationBuilder.pluralName( "Test Order Domain" ).build();
	}

	public static ScreenContextConfigurationUnit screenContext( ScreenContextConfigurationUnitBuilder screenContextBuilder ) {
		return screenContextBuilder.screenName( "Administration of Test Order Domain" ).build();
	}

	public static FieldSetConfigurationUnit listView( FieldSetConfigurationUnitBuilder listViewBuilder ) {
		return listViewBuilder.field( "id" ).caption( "ID" ).field( "name" ).caption( "Name" ).field( "customer" ).caption( "Customer" ).field( "shippingAddresses" ).caption( "Shipping Addresses" ).renderable( new LineItemRenderer() ).caption( "Line Items" ).build();
	}
}