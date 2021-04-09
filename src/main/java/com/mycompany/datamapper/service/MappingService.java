package com.mycompany.datamapper.service;

import java.util.List;
import java.util.Optional;

import java.net.URL;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.datamapper.web.rest.dto.InputData;
import com.mycompany.datamapper.web.rest.dto.OutputData;

import io.atlasmap.api.AtlasContext;
import io.atlasmap.api.AtlasContextFactory;
import io.atlasmap.api.AtlasException;
import io.atlasmap.api.AtlasSession;
import io.atlasmap.core.ADMArchiveHandler;
import io.atlasmap.core.AtlasMappingUtil;
import io.atlasmap.core.DefaultAtlasContext;
import io.atlasmap.core.DefaultAtlasContextFactory;
import io.atlasmap.core.DefaultAtlasPropertyStrategy;
import io.atlasmap.java.module.JavaModule;
import io.atlasmap.spi.AtlasModuleMode;
import io.atlasmap.v2.AtlasMapping;
import io.atlasmap.v2.DataSource;
import io.atlasmap.v2.DataSourceType;
import io.atlasmap.v2.Property;

@Service
public class MappingService {

	private static final Logger log = LoggerFactory.getLogger(MappingService.class);

	public OutputData map(InputData i) {
		try {
			ADMArchiveHandler achiveHandler = new ADMArchiveHandler();
			achiveHandler.load(Paths.get("/Users/aliagamy/Desktop/mapping/simple-mapping-3.adm"));
			AtlasMapping mapping = achiveHandler.getMappingDefinition();
			
//			DataSource iDS = new DataSource();
//			iDS.setDataSourceType(DataSourceType.SOURCE);
//			iDS.setId("InputData");
//			iDS.setUri("atlas:java:InputData");
			
//			DataSource oDS = new DataSource();
//			oDS.setDataSourceType(DataSourceType.TARGET);
//			oDS.setId("OutputData");
//			mapping.getDataSource().add(iDS);
//			mapping.getDataSource().add(oDS);
//			List<Property> properties = mapping.getProperties().getProperty();
//			properties.forEach(a -> {
//				if (a.getName().equals("firstName"))
//					a.setValue("ali");
//				
//				if (a.getName().equals("lastName"))
//					a.setValue("agamy");
//			});
			
			AtlasContextFactory factory = 	DefaultAtlasContextFactory.getInstance();
			DefaultAtlasContext context = (DefaultAtlasContext) DefaultAtlasContextFactory.getInstance().createContext(mapping);
			AtlasSession session = context.createSession();
			
//			JavaModule java = new JavaModule();
//			java.setConversionService(factory.getConversionService());
//			java.setFieldActionService(factory.getFieldActionService());
//			java.setMode(AtlasModuleMode.SOURCE);
//			java.setDocId("InputData");
//			context.getSourceModules().put("InputData",java);
			session.setSourceDocument("InputData",new ObjectMapper().writeValueAsString(i));

//			DefaultAtlasPropertyStrategy strategy = new DefaultAtlasPropertyStrategy();
//			strategy.setEnvironmentPropertiesEnabled(false);
//			strategy.setSystemPropertiesEnabled(false);
//			session.setAtlasPropertyStrategy(strategy);
			
			
			OutputData o = new OutputData();
			session.setDefaultTargetDocument(o);
			context.process(session);
			log.info("mapping process has errors: {}", session.hasErrors());
			Object output = session.getDefaultTargetDocument();
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}