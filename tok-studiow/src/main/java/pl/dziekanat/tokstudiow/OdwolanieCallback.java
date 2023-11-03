package pl.dziekanat.tokstudiow;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class OdwolanieCallback implements JavaDelegate {


	public void execute(DelegateExecution execution) throws Exception {
		RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
		runtimeService.createMessageCorrelation("wynikodwolaniaMsg")
		  .processInstanceBusinessKey(execution.getVariable("parentBussinesKey").toString())
		  .setVariable("decyzja_czyPozytywna", execution.getVariable("decyzja_czyPozytywna"))
		  .setVariable("decyzja_uzasadnienie", execution.getVariable("decyzja_uzasadnienie"))
		  .correlateWithResult();
		
	}



}
