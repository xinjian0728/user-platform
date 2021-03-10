package org.geektimes.projects.user.validation;

import org.geektimes.projects.user.domain.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserValidAnnotationValidator implements ConstraintValidator<UserValid, User> {

    private int idRange;

    public void initialize(UserValid annotation) {
        this.idRange = annotation.idRange();
    }

    @Override
    public boolean isValid(User value, ConstraintValidatorContext context) {
        boolean ret = false;
        try{
            Long id = value.getId();
            if(id > 0 ){
                ret = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        // 获取模板信息
        String msgTemplate = context.getDefaultConstraintMessageTemplate();

        return ret;
    }
}
