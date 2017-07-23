package com.autoinsurance;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.metaworks.multitenancy.ClassManager;
import org.metaworks.multitenancy.CouchbaseMetadataService;
import org.metaworks.multitenancy.DefaultMetadataService;
import org.metaworks.multitenancy.MetadataService;
import org.metaworks.multitenancy.tenantawarefilter.TenantAwareFilter;
import org.metaworks.springboot.configuration.Metaworks4WebConfig;
import org.metaworks.multitenancy.persistence.MultitenantRepositoryImpl;
import org.metaworks.rest.MetaworksRestService;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.uengine.modeling.resource.CachedResourceManager;
import org.uengine.modeling.resource.LocalFileStorage;
import org.uengine.modeling.resource.ResourceManager;
import org.uengine.modeling.resource.Storage;
import org.uengine.persistence.couchbase.CouchbaseStorage;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = {MetaworksRestService.class, WebConfig.class, ClassManager.class, MetadataService.class, MultitenantRepositoryImpl.class})
@EnableJpaRepositories(repositoryBaseClass = MultitenantRepositoryImpl.class)
public class WebConfig extends Metaworks4WebConfig {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8082", "http://localhost:8081", "*")
                .allowedMethods("POST", "GET", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("access_token", "Content-Type");

    }

    @Bean
    public ResourceManager resourceManager() {
        ResourceManager resourceManager = new CachedResourceManager();
        resourceManager.setStorage(storage());
        return resourceManager;
    }

    @Bean
    /**
     *
     * <bean class="CouchbaseStorage">
     *    <property name="basePath" value="/"/>
     <property name="bucketName" value="default"/>
     <property name="serverIp" value="localhost"/>
     </bean>
     */
    public Storage storage() {
        LocalFileStorage storage = new LocalFileStorage();
        storage.setBasePath("/oce/repository");

        return storage;
    }

    @Bean
    public TenantAwareFilter tenantAwareFilter(){
        return new TenantAwareFilter();
    }

    @Bean
    public MetadataService metadataService() {
        DefaultMetadataService metadataService = new DefaultMetadataService();
        metadataService.setResourceManager(resourceManager());

        return metadataService;
    }

//    @Bean
//    public DataSource dataSource() {
//        //In classpath from spring-boot-starter-web
//        final Properties pool = new Properties();
//        pool.put("driverClassName", "com.mysql.jdbc.Driver");
//        pool.put("url", "jdbc:mysql://localhost:3306/uengine?useUnicode=true&characterEncoding=UTF8&useOldAliasMetadataBehavior=true");
//        pool.put("username", "root");
//        pool.put("password", "");
//        pool.put("minIdle", 1);
//        try {
//            return new org.apache.tomcat.jdbc.pool.DataSourceFactory().createDataSource(pool);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Bean
    @Primary
    public JpaProperties jpaProperties() {

        JpaProperties propertiesMap = new JpaProperties();
        propertiesMap.getProperties().put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.CREATE_OR_EXTEND);

        return propertiesMap;
    }


//    @Bean
//    public ResourceProcessor<Resource<?>> resourceProcessor() {
//        return new ResourceProcessor<Resource<?>>() {
//            @Override
//            public Resource<?> process(Resource<?> resource) {
//                // additional processing only for entities that have rest resources
//                if (resource.getContent().getClass().isAnnotationPresent(EntityWithRestResource.class)) {
//                    Map<String, String> links = new HashMap<String, String>();
//
//                    // process any fields that have the RestResourceMapper annotation
//                    Field[] fields = resource.getContent().getClass().getDeclaredFields();
//
//                    for(Field field : fields){
//
//                        RestResourceMapper restResourceMapper = field.getAnnotation(RestResourceMapper.class)
//
//                        if (restResourceMapper!=null) {
//                            String resourceId = resource.getContent()."${field.name}");
//
//                            if (resourceId) {
//                                // construct a REST endpoint URL from the annotation properties and resource id
//                                final String resourceURL = restResourceMapperService.getResourceURL(restResourceMapper, resourceId)
//
//                                // for eager fetching, fetch the resource and embed its contents within the designated property
//                                // no links are added
//                                if (restResourceMapper.resolveToProperty()) {
//                                    String resolvedResource = restResourceMapperService.getResolvedResource(resourceURL)
//
//                                    resource.content."${restResourceMapper.resolveToProperty()}" =
//                                            ResourceParsingUtil.deserializeJSON(resolvedResource)
//                                } else {
//                                    // for external links, we simply want to put the constructed URL into the JSON output
//                                    // for internal links, we want to ensure that the URL conforms to HATEOAS for the given resource
//                                    links.put(field.name, restResourceMapper.external() ?
//                                            resourceURL : restResourceMapperService.getHATEOASURLForResource(resourceURL, resource.content.class))
//                                }
//                            }
//                        }
//                    }
//
//                    // add any additional links to the output
//                    links.keySet()?.each { String linkResourceName ->
//                        resource.add(new Link(links.get(linkResourceName), linkResourceName))
//                    }
//                }
//
//                return resource
//            }
//        }
//    }


}