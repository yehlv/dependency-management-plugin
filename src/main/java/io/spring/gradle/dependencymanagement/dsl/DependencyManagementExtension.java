/*
 * Copyright 2014-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.spring.gradle.dependencymanagement.dsl;

import groovy.lang.Closure;
import org.gradle.api.artifacts.Configuration;

import io.spring.gradle.dependencymanagement.DependencyManagementSettings.PomCustomizationSettings;
import io.spring.gradle.dependencymanagement.PomDependencyManagementConfigurer;

/**
 * Extension that provides the entry point to the dependency management plugin's DSL.
 *
 * @author Andy Wilkinson
 */
public interface DependencyManagementExtension extends DependencyManagementConfigurer {

    /**
     * Configures the resolution strategy of all dependency management-related {@link Configuration Configurations}
     * using the given {@code closure}.
     *
     * @param closure the closure that will configure the resolution strategies
     */
    void resolutionStrategy(Closure closure);

    /**
     * Uses the given {@code closure} to configure the customization of generated poms. The closure is called with
     * a {@link PomCustomizationSettings} as its
     * delegate.
     *
     * @param closure the closure
     * @see PomCustomizationSettings
     */
    void generatedPomCustomization(Closure closure);

    /**
     * Provides access to the {@link PomDependencyManagementConfigurer} that can be used to configure dependency
     * management in a generated pom.
     *
     * @return the pom configurer
     */
    PomDependencyManagementConfigurer getPomConfigurer();

    /**
     * Whether or not Maven-style exclusions should be applied during dependency resolutions.
     *
     * @return {@code true} if Maven-style exclusions should be applied, otherwise {@code false}
     */
    boolean isApplyMavenExclusions();

    /**
     * Set whether or not Maven-style exclusions should be applied during dependency resolutions.
     * The default is {@code true}.
     *
     * @param applyMavenExclusions {@code true} if Maven-style exclusions should be applied, otherwise {@code false}
     */
    void applyMavenExclusions(boolean applyMavenExclusions);

    /**
     * Whether or not dependency management should be overridden by versions declared on a project's dependencies.
     *
     * @return {@code true} if dependency management should be overridden by dependencies' versions, otherwise {@code
     * false}
     */
    boolean isOverriddenByDependencies();

    /**
     * Set whether dependency management should be overridden by versions declared on a project's dependencies. The
     * default is {@code true}.
     *
     * @param overriddenByDependencies {@code true} if dependency management should be overridden by dependencies'
     * versions, otherwise {@code false}
     */
    void overriddenByDependencies(boolean overriddenByDependencies);

}