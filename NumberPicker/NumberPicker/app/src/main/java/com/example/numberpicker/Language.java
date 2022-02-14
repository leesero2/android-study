package com.example.numberpicker;

import java.util.ArrayList;

public class Language {

    private static ArrayList<Language> LanguageArrayList;

    private int id;
    private String name;

    public Language(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void initLanguages()
    {
        LanguageArrayList = new ArrayList<>();

        Language english = new Language(0,"English");
        LanguageArrayList.add(english);

        Language korean = new Language(0,"korean");
        LanguageArrayList.add(korean);

        Language japanese = new Language(0,"japanese");
        LanguageArrayList.add(japanese);

    }

    public static ArrayList<Language> getLanguageArrayList() {
        return LanguageArrayList;
    }

    public static String[] languageNames()
    {
        String[] names = new String[LanguageArrayList.size()];
        for(int i = 0; i<LanguageArrayList.size(); i++){
            names[i] = LanguageArrayList.get(i).name;
        }
        return names;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
