package uz.elmurodov.enums.settings;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Language {

    UZ("UZ", "Uzbek"),
    RU("RU", "Russian"),
    EN("EN", "English");

    private final String code;
    private final String name;

    public static Language getByCode(String lang) {
        for (Language language : values()) {
            if (language.getCode().equalsIgnoreCase(lang)) return language;
        }
        return null;
    }
}
