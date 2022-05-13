package com.alibaba.fastjson2.annotation;

/**
 * @since 1.2.15
 */
public enum NamingStrategy {
    CamelCase,
    PascalCase,
    SnakeCase,
    UpperCase,
    KebabCase;

    private static final int CHARACTER_CODE_SPACE = 32;

    public static String snakeToCamel(String name) {

        int underscoreCount = getNumberOfUnderscoresInName(name);
        if (0 == underscoreCount) {
            return name;
        }

        char[] chars = new char[name.length() - underscoreCount];
        for (int i = 0, j = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (isUnderscore(ch)) {
                continue;
            }

            if (i > 0 && name.charAt(i - 1) == '_') {
                if (ch >= 'a' && ch <= 'z') {
                    ch -= CHARACTER_CODE_SPACE;
                }
            }
            chars[j++] = ch;
        }

        return new String(chars);

    }

    private static boolean isUnderscore(char c) {
        return '_' == c;
    }

    private static int getNumberOfUnderscoresInName(String name) {

        if (null == name) {
            return 0;
        }

        if (-1 == name.indexOf('_')) {
            return 0;
        }

        int underscoreCount = 0;
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (isUnderscore(ch)) {
                underscoreCount++;
            }
        }

        return underscoreCount;

    }

}
