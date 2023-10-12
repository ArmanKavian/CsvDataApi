package com.example.sundayassignment;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;


public class ArchitectureTest {

    private static final String BASE_PACKAGE = "com.example.sundayassignment";

    @Test
    public void testArchitecture() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(BASE_PACKAGE);

        ArchRule controllerAccessesRepository = layeredArchitecture()
                .layer("Controller").definedBy(BASE_PACKAGE + ".controller..")
                .layer("Service").definedBy(BASE_PACKAGE + ".service..")
                .layer("Repository").definedBy(BASE_PACKAGE + ".repository..")
                .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
                .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
                .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service");

        controllerAccessesRepository.check(importedClasses);
    }
}
