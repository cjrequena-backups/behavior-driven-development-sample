package com.sample.jbehave.junitstories;

import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import com.sample.jbehave.junitstories.steps.AddProductToShoppingCartSteps;
import com.sample.jbehave.junitstories.steps.AddUserToRepositorySteps;

public class MyStories extends JUnitStories {

	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration()
				//
				.useStoryLoader(new LoadFromClasspath(getClass().getClassLoader()))
				//
				.useStoryReporterBuilder(new StoryReporterBuilder().withFormats(Format.CONSOLE, Format.TXT, Format.HTML, Format.XML));
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(),
				//
				new AddProductToShoppingCartSteps(),
				//
				new AddUserToRepositorySteps());
	}

	@Override
	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(getClass()), "stories/**/*.story", "");
	}

}
