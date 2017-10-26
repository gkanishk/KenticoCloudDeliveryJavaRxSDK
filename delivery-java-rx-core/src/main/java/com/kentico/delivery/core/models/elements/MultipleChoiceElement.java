package com.kentico.delivery.core.models.elements;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kentico.delivery.core.models.elements.models.MultipleChoiceOption;
import com.kentico.delivery.core.models.exceptions.KenticoCloudException;

public class MultipleChoiceElement extends ContentElement<MultipleChoiceOption[]> {

    private MultipleChoiceOption[] _value;

    public MultipleChoiceElement(
            ObjectMapper objectMapper,
            String name,
            String codename,
            String type,
            JsonNode value
    ){
        super(objectMapper, name, codename, type);

        try {
            _value = this.objectMapper.treeToValue(value, MultipleChoiceOption[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new KenticoCloudException("Could not map MultipleChoice element for '" + codename + "'", e);
        }
    }

    @Override
    public MultipleChoiceOption[] getValue(){
        return this._value;
    }
}