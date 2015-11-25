package com.sample.jbehave.junitstory;

import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

public class CookBaconStory extends JUnitStory {

	@Given("12 strips of bacon")
	@Pending
	public void given12StripsOfBacon() {
		// PENDING
	}

	@Given("a frypan on a medium heat")
	@Pending
	public void givenAFrypanOnAMediumHeat() {
		// PENDING
	}

	@When("I put the bacon into the frypan")
	@Pending
	public void whenIPutTheBaconIntoTheFrypan() {
		// PENDING
	}

	@When("wait for 10 minutes or until the bacon sizzles")
	@Pending
	public void whenWaitFor10MinutesOrUntilTheBaconSizzles() {
		// PENDING
	}

	@When("flip the bacon")
	@Pending
	public void whenFlipTheBacon() {
		// PENDING
	}

	@When("wait for 5 minutes")
	@Pending
	public void whenWaitFor5Minutes() {
		// PENDING
	}

	@Then("I get perfectly cooked crispy bacon")
	@Pending
	public void thenIGetPerfectlyCookedCrispyBacon() {
		// PENDING
	}

	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(getClass().getClassLoader())).useStoryReporterBuilder(new StoryReporterBuilder().withFormats(Format.CONSOLE));
	}

	@Override
	public List<CandidateSteps> candidateSteps() {
		return new InstanceStepsFactory(configuration(), this).createCandidateSteps();
	}
}
