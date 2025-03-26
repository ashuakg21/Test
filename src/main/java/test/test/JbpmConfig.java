package test.test;

import org.jbpm.runtime.manager.impl.RuntimeManagerFactoryImpl;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.kie.api.runtime.manager.RuntimeEnvironment;
import org.kie.api.runtime.manager.RuntimeEnvironmentBuilder;

@Configuration
public class JbpmConfig {

    @Bean
    public KieContainer kieContainer() {
        return KieServices.Factory.get().getKieClasspathContainer();
    }

    @Bean
    public KieBase kieBase() {
        return kieContainer().getKieBase();
    }

    //@Bean
    //public KieSession kieSession() {
    //    return kieContainer().newKieSession();
    //}
    
    @Bean
    public RuntimeManager runtimeManager() {
        RuntimeEnvironment environment = RuntimeEnvironmentBuilder.Factory.get()
                .newDefaultBuilder()
                .addAsset(ResourceFactory.newClassPathResource("process.bpmn2"), ResourceType.BPMN2)
                .get();
        
        return new RuntimeManagerFactoryImpl().newSingletonRuntimeManager(environment);
    }

    @Bean
    public KieSession kieSession(RuntimeManager runtimeManager) {
        return runtimeManager.getRuntimeEngine(null).getKieSession();
    }
}