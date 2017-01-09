package org.bobbyjam99.validate;

import org.bobbyjam99.web.validate.ValidateForm;
import org.hibernate.validator.constraints.NotEmpty;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ValidateControllerTest {

    private Validator validator;

    @Before
    public void before() throws Exception {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void validateNotEmpty() {
        ValidateForm validateForm = new ValidateForm();
        validateForm.setRequired("");

        Set<ConstraintViolation<ValidateForm>> violations = validator.validate(validateForm);

        assertThat(violations.size(), is(1));
        for (ConstraintViolation<ValidateForm> v : violations) {
            assertTrue(v.getConstraintDescriptor().getAnnotation() instanceof NotEmpty);
        }
    }

    @After
    public void after() throws Exception {}
}
