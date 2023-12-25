package com.feas.domain.config;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/**
 * @author Sherif Nouh
 * @Date ١٠/٠٩/٢٠٢٣
 */


public class CustomDateDeserializer extends JsonDeserializer<Date> {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY", new Locale("en"));

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String dateAsString = jsonParser.getText();
        try {
            return dateFormat.parse(dateAsString);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format: " + dateAsString, e);
        }
    }
}