package io.changsoft.customers;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("io.changsoft.customers");

        noClasses()
            .that()
            .resideInAnyPackage("io.changsoft.customers.service..")
            .or()
            .resideInAnyPackage("io.changsoft.customers.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..io.changsoft.customers.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
