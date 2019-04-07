package com.keveon.demo.commons.converter;

import com.keveon.demo.commons.consts.Gender;
import com.keveon.demo.commons.consts.WorkingStatus;
import org.jetbrains.annotations.NotNull;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

/**
 * {@link WorkingStatus} 与数据库中的 {@link Integer} 互相转换的映射类, 扩展自 {@link AttributeConverter}.
 *
 * @author keveon on 2019/04/07.
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unused")
@Converter(autoApply = true)
public class GenderAttributeConverter implements AttributeConverter<Gender, Integer> {

    @NotNull
    @Override
    public Integer convertToDatabaseColumn(Gender attribute) {
        return Objects.requireNonNullElse(attribute, Gender.unknown).getCode();
    }

    @NotNull
    @Override
    public Gender convertToEntityAttribute(Integer dbData) {
        return Gender.of(dbData);
    }
}
