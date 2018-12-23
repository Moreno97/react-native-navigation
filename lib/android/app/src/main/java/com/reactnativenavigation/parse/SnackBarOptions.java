package com.reactnativenavigation.parse;

import com.reactnativenavigation.parse.params.Bool;
import com.reactnativenavigation.parse.params.Colour;
import com.reactnativenavigation.parse.params.NullBool;
import com.reactnativenavigation.parse.params.NullColor;
import com.reactnativenavigation.parse.params.NullText;
import com.reactnativenavigation.parse.params.Text;
import com.reactnativenavigation.parse.parsers.BoolParser;
import com.reactnativenavigation.parse.parsers.ColorParser;
import com.reactnativenavigation.parse.parsers.TextParser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class SnackBarOptions {

    public static SnackBarOptions parse(JSONObject json) {
        SnackBarOptions options = new SnackBarOptions();
        if (json == null) return options;

        options.id = TextParser.parse(json, "id");
        options.title = TextParser.parse(json, "title");

        return options;
    }

    public Text id = new NullText();
    public Text title = new NullText();

    void mergeWith(final SnackBarOptions other) {
        if (other.id.hasValue()) {
            id = other.id;
        }

        if (other.title.hasValue()) {
            title = other.title;
        }
    }

    void mergeWithDefault(SnackBarOptions defaultOptions) {
        if (!id.hasValue()) {
            id = defaultOptions.id;
        }

        if (!title.hasValue()) {
            title = defaultOptions.title;
        }
    }

    public boolean hasValue() {
        return id.hasValue();
    }
}
