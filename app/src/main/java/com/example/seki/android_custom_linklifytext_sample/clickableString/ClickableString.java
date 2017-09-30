package com.example.seki.android_custom_linklifytext_sample.clickableString;


import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClickableString {

    private static final String SEPARATOR = ",";

    public static Spannable create(String clickableStrings, String text) {
        if (clickableStrings == null || clickableStrings.trim().isEmpty()) {
            return new SpannableStringBuilder().append(text);
        }

        if (!clickableStrings.contains(SEPARATOR)) {
            return createSingle(clickableStrings, text);
        }

        final SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append(text);

        final String[] clickables = clickableStrings.split(SEPARATOR);

        for (final String clickable : clickables) {
            final Pattern p = Pattern.compile(clickable);
            final Matcher m = p.matcher(text);

            while(m.find()) {
                builder.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(View widget) {
                        Toast.makeText(widget.getContext(), clickable, Toast.LENGTH_SHORT).show();
                    }
                }, m.start(), m.start() + clickable.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }

        return builder;
    }


    private static Spannable createSingle(final String clickableString, String text) {
        final SpannableStringBuilder builder = new SpannableStringBuilder();
        final int clickableStringPosition = text.indexOf(clickableString);
        if (clickableStringPosition == -1) {
            builder.append(text);
            return builder;
        }

        builder.append(text)
                .setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(View widget) {
                        Toast.makeText(widget.getContext(), clickableString, Toast.LENGTH_SHORT).show();
                    }
                }, clickableStringPosition, clickableStringPosition + clickableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return builder;

    }
}
