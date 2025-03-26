package test.test;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessService {

    @Autowired
    private KieSession kieSession;

    public Long startProcess() {
        ProcessInstance processInstance = kieSession.startProcess("sampleProcess");
        return processInstance.getId();
    }
}