package org.lightadmin.core.web.util;

import org.lightadmin.core.config.domain.DomainTypeAdministrationConfiguration;
import org.lightadmin.core.persistence.metamodel.DomainTypeEntityMetadata;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

import static java.lang.String.valueOf;
import static org.lightadmin.core.web.util.WebContextUtils.getCurrentRequest;
import static org.lightadmin.core.web.util.WebContextUtils.globalAdministrationConfiguration;

public final class ApplicationUrlResolver {

    private ApplicationUrlResolver() {
    }

    public static String domainBaseUrl(DomainTypeAdministrationConfiguration configuration) {
        return "/domain/" + configuration.getDomainTypeName();
    }

    public static String domainRestBaseUrl(DomainTypeAdministrationConfiguration configuration) {
        return "/rest/" + configuration.getDomainTypeName();
    }

    public static String domainRestEntityBaseUrl(DomainTypeAdministrationConfiguration configuration, Object id) {
        return domainRestBaseUrl(configuration) + "/" + id;
    }

    public static String domainRestScopeBaseUrl(DomainTypeAdministrationConfiguration configuration) {
        return "/rest/" + configuration.getDomainTypeName() + "/scope";
    }

    public static String filePropertyRestUrl(Object entity, String property) {
        DomainTypeAdministrationConfiguration domainTypeAdministrationConfiguration = domainTypeAdministrationConfiguration(getCurrentRequest(), entity);
        DomainTypeEntityMetadata domainTypeEntityMetadata = domainTypeAdministrationConfiguration.getDomainTypeEntityMetadata();

        String idValue = valueOf(idAttributeValue(entity, domainTypeEntityMetadata));

        return domainRestEntityBaseUrl(domainTypeAdministrationConfiguration, idValue) + "/" + property + "/file";
    }

    private static DomainTypeAdministrationConfiguration domainTypeAdministrationConfiguration(HttpServletRequest currentRequest, Object entity) {
        return globalAdministrationConfiguration(currentRequest.getServletContext()).forManagedDomainType(entity.getClass());
    }

    private static Serializable idAttributeValue(Object entity, DomainTypeEntityMetadata domainTypeEntityMetadata) {
        return (Serializable) domainTypeEntityMetadata.getIdAttribute().getValue(entity);
    }
}