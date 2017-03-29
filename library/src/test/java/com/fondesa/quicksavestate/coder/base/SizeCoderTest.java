/*
 * Copyright (c) 2017 Fondesa
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

package com.fondesa.quicksavestate.coder.base;


import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Size;

import com.fondesa.quicksavestate.common.CoderRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

/**
 * Unit test class for {@link SizeCoder}.
 */
@RunWith(RobolectricTestRunner.class)
@Config(minSdk = Build.VERSION_CODES.LOLLIPOP)
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class SizeCoderTest {
    @Rule
    public final CoderRule<SizeCoder> mCoderRule = new CoderRule<>(SizeCoder.class);

    @SuppressWarnings("NewApi")
    @Test
    public void testSerializeSize() {
        Size expectedValue = new Size(9, 5);
        mCoderRule.coder().serialize(mCoderRule.bundle(), mCoderRule.randomKey(), expectedValue);
        assertEquals(expectedValue, mCoderRule.bundle().getSize(mCoderRule.randomKey()));

    }

    @Test
    public void testDeserializeSize() {
        Size expectedValue = new Size(9, 5);
        mCoderRule.bundle().putSize(mCoderRule.randomKey(), expectedValue);
        assertEquals(expectedValue, mCoderRule.coder().deserialize(mCoderRule.bundle(), mCoderRule.randomKey()));
    }
}