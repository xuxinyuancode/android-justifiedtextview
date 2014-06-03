/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.biubiubiu.justifytext;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import butterknife.ButterKnife;
import butterknife.InjectView;
import me.biubiubiu.justifytext.library.JustifyTextView;

public class MainActivity extends Activity {

    private static final String TAG = "CharsPerLineActivity";

    @InjectView(R.id.text)
    JustifyTextView mText;

    @SuppressLint("ResourceAsColor")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_activity_main);

        ButterKnife.inject(this);
        mText.setTextColor(0xffff0000);

        String text = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("1.txt")));
            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            text = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mText.setText(text);
        mText.setLineSpacing(20, 1);
    }

}
