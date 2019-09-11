package victor.training.jpa.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import victor.training.jpa.app.common.data.EntityRepositoryFactoryBean;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = EntityRepositoryFactoryBean.class)
@EnableJpaAuditing
@EnableTransactionManagement/*(mode = AdviceMode.ASPECTJ)*/
//-javaagent:spring-instrument.jar -javaagent:aspectjweaver.jar
//@EnableLoadTimeWeaving(aspectjWeaving= EnableLoadTimeWeaving.AspectJWeaving.ENABLED)
public class JpaApplication {

	@Autowired
	private DummyDataCreator dummyDataCreator;
	@Autowired
	private Playground playground;

	@Autowired
	private PlatformTransactionManager txm;
	@Autowired
	private Curiozitati curiozitati;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println(txm.getClass());
		System.out.println("Application started. Running playground code...");
		dummyDataCreator.persistDummyData();
		curiozitati.cretz();
		System.out.println(" ========= FIRST TRANSACTION ========== ");
		playground.firstTransaction();
		System.out.println(" ========= SECOND TRANSACTION ========== ");
		playground.secondTransaction();
		System.out.println(" ========= N+1 ========== ");
		playground.nPlus1();
		System.out.println(" ========= END ==========ASD&SA*D&SA*D&SA*D&SAD&*SAD*SAD ");
		transactionPlayground.tx1();

	}
	@Autowired
	TransactionPlayground transactionPlayground;

	//TODO decomenteaza aci daca ai Sp Security activat. :) si foloseste @LastModifiedBy in casa si gradina
//	@Bean
//	public AuditorAware<String> auditorProvider() {
//		return MyUtil::getUserOnCurrentThread;
//	}

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
}
